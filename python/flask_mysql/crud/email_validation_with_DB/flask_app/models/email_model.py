from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import email_model
from flask_app import app
from flask import flash
import re

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 

class Email:
    def __init__(self,data):
        self.id = data['id']
        self.email = data['email']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod 
    def create_email(cls, data):
        query = """
        INSERT INTO emails (email)
        VALUES(%(email)s);
        """
        return connectToMySQL('emails').query_db(query,data)   

    @classmethod
    def show_all_emails(cls):
        query = "SELECT * FROM emails;"
        emails_from_db = connectToMySQL('emails').query_db(query)
        emails = []
        for each_email in emails_from_db:
            emails.append(cls(each_email))
        return emails 

    @classmethod
    def delete_email(cls, data):
        query = """
        DELETE FROM emails
        WHERE id = %(id)s;
        """
        return connectToMySQL('emails').query_db(query, data)

    @staticmethod
    def validate_email(data):
        is_valid = True
        # test whether a field matches the pattern
        all_emails = Email.show_all_emails()
        this_email = data['email']
        if not EMAIL_REGEX.match(this_email): 
            flash("Invalid email address! Try again!")
            is_valid = False

        # for each_email in all_emails:
        #     if each_email['email'] == this_email:
        #         flash('Email already in system.')
        #         is_valid = False

        return is_valid


