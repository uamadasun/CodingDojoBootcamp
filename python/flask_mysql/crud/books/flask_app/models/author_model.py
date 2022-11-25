from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import book_model
from flask_app import app
from flask import flash
import re

class Author:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def create_author(cls, data):
        query = """
        INSERT INTO authors(name)
        VALUES(%(name)s);
        """
        return connectToMySQL('books').query_db(query,data)

    @classmethod
    def get_all_authors(cls):
        query = "SELECT * FROM authors;"
        authors_from_db = connectToMySQL('books').query_db(query)
        authors_list = []
        for each_author in authors_from_db:
            authors_list.append(each_author)
        return authors_list



