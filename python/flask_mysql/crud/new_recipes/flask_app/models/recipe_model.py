from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import user_model #(import any models for one-to-many relationship?)
from flask_app import app
from flask import flash
import re

class Recipe:
    def __init__(self, data):
        self.id = data['id']
        self.name = data['name']
        self.description = data['description']
        self.instructions = data['instructions']
        self.date_cooked = data['date_cooked']
        self.under_30 = data['under_30']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']

    @classmethod
    def create_recipe(cls, data):
        query = """
        INSERT INTO recipes (name, description, instructions, date_cooked, under_30, user_id)
        VALUES(%(name)s, %(description)s, %(instructions)s, %(date_cooked)s, %(under_30)s, %(user_id)s);
        """
        return connectToMySQL('recipes').query_db(query,data)

    @classmethod
    def delete_recipe(cls,data):
        query = """
        DELETE FROM recipes
        WHERE id = %(id)s;
        """
        return connectToMySQL('recipes').query_db(query, data)

    @classmethod
    def show_one_recipe(cls, data):
        query = """
        SELECT * 
        FROM recipes
        JOIN users
        ON users.id = recipes.user_id
        WHERE recipes.id = %(id)s;
        """
        recipes_from_db = connectToMySQL('recipes').query_db(query, data)
        recipes = []
        for recipe in recipes_from_db:
            recipes.append(recipe)
        return recipes[0]

    @classmethod
    def update_recipe(cls, data):
        query = """
        UPDATE recipes
        SET name=%(name)s, description=%(description)s, instructions=%(instructions)s, date_cooked=%(date_cooked)s, under_30=%(under_30)s, user_id=%(user_id)s
        WHERE id = %(id)s; 
        """
        return connectToMySQL('recipes').query_db(query, data)



    @staticmethod
    def validate_recipe(data):
        is_valid = True

        if len(data['recipe_name']) <3:
            flash("Name must be at least 3 characters long.")
            is_valid = False

        if len(data['description']) <3:
            flash("Description must be at least 3 characters long.")
            is_valid = False
        
        if len(data['instructions']) <3:
            flash("Instructions must be at least 3 characters long.")
            is_valid = False

        if 'under_30' not in data:
            flash('Under 30 minutes field required.')
            is_valid = False
        
        if data['date_cooked'] == '':
            flash('Date cooked field required.')
            is_valid = False

        return is_valid
