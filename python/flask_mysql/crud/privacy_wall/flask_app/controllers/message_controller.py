from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.message_model import Message 
from flask_app.models.user_model import User
from flask_bcrypt import Bcrypt

bcrypt = Bcrypt(app)







# @app.route('/create_recipe', methods = ['POST'])
# def create_recipe():
#     print(request.form)
#     if 'current_id' not in session:
#         return redirect('/')

#     if not Message.validate_recipe(request.form):
#         return redirect('/new_recipe_page')

#     data = {
#         'name': request.form['recipe_name'],
#         'description': request.form['description'],
#         'instructions': request.form['instructions'],
#         'date_cooked': request.form['date_cooked'],
#         'under_30':request.form['under_30'],
#         'user_id': session['current_id']
#     }

#     new_recipe = Recipe.create_recipe(data)
    
#     return redirect('/user_page')

# @app.route('/view_recipe/<int:recipe_id>')
# def view_recipe(recipe_id):
#     user_data = {
#         'id' : session['current_id']
#     }

#     data = {
#         'id' : recipe_id
#     }
#     user = User.get_by_id(user_data)
#     recipe = Recipe.show_one_recipe(data)
#     print(recipe)

#     return render_template("view_recipe.html", recipe=recipe, user=user)

# @app.route('/link_update_recipe/<int:recipe_id>')
# def link_to_update(recipe_id):
#     data = {
#         'id': recipe_id
#     }

#     recipe = Recipe.show_one_recipe(data)

#     return render_template('update_recipe.html', recipe = recipe)

# @app.route('/update_recipe/<int:recipe_id>', methods = ['POST'])
# def update_recipe(recipe_id):
#     if 'current_id' not in session:
#         return redirect('/')
#     if not Recipe.validate_recipe(request.form):
#         return redirect(f'/link_update_recipe/{recipe_id}')
    
#     data = {
#         'id':recipe_id,
#         'name':request.form['recipe_name'],
#         'description':request.form['description'],
#         'instructions':request.form['instructions'],
#         'date_cooked':request.form['date_cooked'],
#         'under_30':request.form['under_30'],
#         'user_id':session['current_id'],
#     }
#     Recipe.update_recipe(data)
#     return redirect('/user_page')
