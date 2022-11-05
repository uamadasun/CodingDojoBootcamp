from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import user_model
from flask_app import app
from flask import flash
import re
from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 

class User:
    def __init__(self, data):
        self.id = data['id']
        self.first_name = data['first_name']
        self.last_name = data['last_name']
        self.email = data['email']
        self.password = data['password']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod 
    def register_user(cls, data):
        query = """
        INSERT INTO users (first_name, last_name, email, password)
        VALUES(%(first_name)s, %(last_name)s, %(email)s, %(password)s);
        """
        return connectToMySQL('registration').query_db(query,data)

    @classmethod
    def get_by_id(cls, data):
        query = '''
        SELECT * FROM users
        WHERE users.id = %(id)s;
        '''
        user = connectToMySQL('registration').query_db(query, data)
        return cls(user[0])

    @classmethod
    def get_by_email(cls, data):
        query = '''
        SELECT * FROM users
        WHERE users.email = %(email)s;
        '''
        
        user = connectToMySQL('registration').query_db(query, data)
        print(user)
        #if you get a tuple out of index error, it's because the email is not in the database and you're trying to return an index that isn't there so add this conditional.
        if len(user) > 0:
            return cls(user[0])
        return False

    @staticmethod
    def validate_user(data):
        is_valid = True
        if len(data['first_name']) < 1:
            flash("First name required.")
            is_valid = False
        elif len(data['first_name']) <2:
            flash("First name needs to be longer.")
            is_valid = False


        if len(data['last_name']) < 1:
            flash("Last name required.")
            is_valid = False
        elif len(data['last_name']) <2:
            flash("Last name needs to be longer.")
            is_valid = False


        if not EMAIL_REGEX.match(data['email']): 
            flash("Invalid email address! Try again!")
            is_valid = False
        elif not len(data['email']) > 1:
            flash('Email required.')
            is_valid = False

            
        if not data['password'] == data['confirm_password']:
            flash('Passwords must match.')
            is_valid = False
        elif not len(data['password']) > 8:
            flash('Password needs to be at least 8 characters long.')
            is_valid = False

        #check if the email provided is unique
        user_data = {
            'email':data['email']
        }
        potential_user = User.get_by_email(user_data)
        print(potential_user)
        if potential_user:
            flash('Email already in the system. Use another email or log in.')
            is_valid = False

        return is_valid