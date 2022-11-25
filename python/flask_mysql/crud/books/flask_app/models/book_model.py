from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import author_model
from flask_app import app
from flask import flash
import re

class Book:

    def __init__(self, data):
        self.title = data['title']
        self.num_of_pages = data['num_of_pages']

    @classmethod
    def create_book(cls, data):
        query = """
        INSERT INTO books (title,num_of_pages)
        VALUES(%(title)s,%(num_of_pages)s);
        """
        return connectToMySQL('books').query_db(query,data)

    @classmethod
    def get_all_books(cls):
        query = "SELECT * FROM books;"
        books_from_db = connectToMySQL('books').query_db(query)
        books_list = []
        for each_book in books_from_db:
            books_list.append(cls(each_book))
        return books_list


    @classmethod
    def show_one_book(cls, data):
        query = """
        SELECT * FROM books
        WHERE books.id = %(id)s;
        """
        book_from_db = connectToMySQL('books').query_db(query, data)
        return cls(book_from_db)

    @classmethod
    def insert_into_join_table(cls, data):
        query = """
        INSERT INTO favorites (author_id, book_id)
        VALUES(%(author_id)s, %(book_id)s);
        """
        return connectToMySQL('books').query_db(query,data)