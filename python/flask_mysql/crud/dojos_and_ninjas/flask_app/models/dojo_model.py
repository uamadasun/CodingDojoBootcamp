from flask_app.config.mysqlconnection import connectToMySQL
from flask_app.models import ninja_model

class Dojo:
    def __init__(self,data):
        self.id = data['id']
        self.name = data['name']
        self.created_at = data['created_at']
        self.updated_at = data['updated_at']
        self.ninjas = []

    @classmethod 
    def create_dojo(cls, data):
        query = """
        INSERT INTO dojos (name)
        VALUES(%(name)s);
        """
        return connectToMySQL('dojos_and_ninjas').query_db(query,data)

    @classmethod
    def show_all_dojos(cls):
        query = "SELECT * FROM dojos;"
        dojos_from_db = connectToMySQL('dojos_and_ninjas').query_db(query)
        dojos = []
        for each_dojo in dojos_from_db:
            dojos.append(cls(each_dojo))
        return dojos

    @classmethod
    def show_one_dojo(cls, data):
        query = """
        SELECT * FROM dojos
        WHERE dojos.id = %(id)s;
        """
        dojo_from_db = connectToMySQL('dojos_and_ninjas').query_db(query, data)
        return cls(dojo_from_db[0])

    @classmethod
    def delete_dojo(cls, data):
        query = """
        DELETE FROM dojos
        WHERE id = %(id)s;
        """
        return connectToMySQL('dojos_and_ninjas').query_db(query, data)

    @classmethod
    def update_dojo(cls, data):
        query = """
        UPDATE dojos
        SET name=%(name)s; 
        """
        return connectToMySQL('dojos_and_ninjas').query_db(query, data)
    
    @classmethod
    def show_ninjas_in_dojo(cls, data):
        query = '''
        SELECT *
        FROM dojos
        LEFT JOIN ninjas
        ON ninjas.dojo_id = dojos.id
        WHERE dojos.id = %(id)s;
        '''
        results = connectToMySQL('dojos_and_ninjas').query_db(query, data)
        dojo = cls(results[0])
        for row_from_db in results:
            ninja_data = {
                'id': row_from_db['ninjas.id'],
                'first_name':row_from_db['first_name'],
                'last_name':row_from_db['last_name'],
                'age': row_from_db['age'],
                'created_at': row_from_db['ninjas.created_at'],
                'updated_at': row_from_db['ninjas.updated_at']
            }
            #"dojo" is referring to the dojo from this method on line 64
            #"ninjas" is from the instance attribute above
        dojo.ninjas.append(ninja_model.Ninja(ninja_data))
        return dojo
