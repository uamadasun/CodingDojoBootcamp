from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import user_model #(import any models for one-to-many relationship?)
from flask_app import app
from flask import flash
import re

class Message:
    def __init__(self, data):
        self.id = data['id']
        self.sender_id = data['sender_id']
        self.receiver_id = data['receiver_id']
        self.message = data['message']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def create_message(cls, data):
        query = """
        INSERT INTO messages (sender_id, receiver_id, message)
        VALUES(%(sender_id)s, %(receiver_id)s, %(message)s);
        """
        return connectToMySQL('privacy').query_db(query,data)


    @classmethod
    def show_all_messages_for_one_user(cls, data):
        query = """
        SELECT *
        FROM messages
        JOIN users_have_messages
        ON users_have_messages.message_id = messages.id
        JOIN users
        ON users.id = users_have_messages.user_id
        WHERE messages.receiver_id = %(id)s;
        """
        # query = """
        # SELECT *
        # FROM messages
        # LEFT JOIN users_have_messages
        # ON users_have_messages.message_id = messages.id
        # LEFT JOIN users
        # ON messages.sender_id = users.id
        # WHERE messages.receiver_id = %(id)s;
        # """
        messages_from_db = connectToMySQL('privacy').query_db(query, data)
        messages = []
        for message in messages_from_db:
            messages.append(message)
        return messages

    @classmethod
    def delete_message(cls,data):
        query = """
        DELETE FROM messages
        WHERE messages.id = %(id)s;
        """
        return connectToMySQL('privacy').query_db(query, data)

    @classmethod
    def insert_into_join_table(cls, data):
        query = """
        INSERT INTO users_have_messages (user_id, message_id)
        VALUES(%(user_id)s, %(message_id)s);
        """
        return connectToMySQL('privacy').query_db(query,data)

    @staticmethod
    def validate_message(data):
        is_valid = True

        if len(data['message']) <5:
            flash("Message must be at least 5 characters long.")
            is_valid = False

        return is_valid
