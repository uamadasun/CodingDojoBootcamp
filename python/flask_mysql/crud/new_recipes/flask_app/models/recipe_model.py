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
        results = connectToMySQL('recipes').query_db(query, data)
        if len(results)<1:
            return False
        this_recipe = cls(results[0])
        user_data = {
            **results[0],
            'id':results[0]['users.id'],
            'created_at': results[0]['users.created_at'],
            'updated_at': results[0]['users.updated_at']
        }

        this_user = user_model.User(user_data)
        this_recipe.creator = this_user
        return this_recipe

        #####WRONG CODE HERE
        # recipes = []
        # for recipe in recipes_from_db:
        #     recipes.append(recipe)
        # return cls(recipes[0])

    @classmethod
    def update_recipe(cls, data):
        query = """
        UPDATE recipes
        SET name=%(name)s, description=%(description)s, instructions=%(instructions)s, date_cooked=%(date_cooked)s, under_30=%(under_30)s, user_id=%(user_id)s
        WHERE id = %(id)s; 
        """
        return connectToMySQL('recipes').query_db(query, data)

    @classmethod
    def get_all_recipes_with_users(cls):
        query = """
        SELECT * 
        FROM recipes
        JOIN users
        ON users.id = recipes.user_id;
        """
        ###CORRECT code starts here
        results = connectToMySQL('recipes').query_db(query)
        all_recipes = []
        if results:
            for row in results:
                # print("*******ROW", row)
                this_recipe = cls(row)
                user_data = {
                    **row,
                    'id':row['users.id'],
                    'created_at':row['users.created_at'],
                    'updated_at':row['users.updated_at']
                }
                this_user = user_model.User(user_data)
                this_recipe.creator = this_user
                all_recipes.append(this_recipe)
                # print("THIS RECIPE\n", this_recipe)
                # print('END OF ROW\n')
        return all_recipes



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
