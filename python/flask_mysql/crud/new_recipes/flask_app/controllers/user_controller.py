from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.user_model import User
from flask_app.models.recipe_model import  Recipe#[Model class name or file name if it's a one to many relationship]
from flask_bcrypt import Bcrypt

bcrypt = Bcrypt(app)

@app.route('/')
def home_page():
    # if 'current_id' in session:
    #     return redirect('user_page.html')
    return render_template('home_page.html')


@app.route('/register_user', methods = ['POST'])
def register_user():
    # 1. validate the form

    if not User.validate_user(request.form):
        return redirect('/')
    
    #2. create the hashed password
    hashed_password = bcrypt.generate_password_hash(request.form['password'])

    #3 create the data dictionary with the hashed password as the password
    data = {
        'first_name' : request.form['first_name'],
        'last_name' : request.form['last_name'],
        'email' : request.form['email'],
        'password' : hashed_password
    }

    #create the new user using the register_user method and set it to session['user_id']
    session['current_id'] = User.register_user(data)
    
    # print(session['current_id'])
    return redirect('/user_page')




@app.route('/user_page')
def user_page():
    #check if the user has logged in yet. if not, redirect them back to home page
    if 'current_id' not in session:
        return redirect('/')
        
    data = {
        'id' : session['current_id']
    }

    user = User.get_by_id(data)

    all_entries = Recipe.get_all_recipes_with_users()
    print(all_entries)
    return render_template('user_page.html', user = user, all_entries=all_entries)




@app.route('/log_in', methods = ['POST'])
def log_in():
    data = {
        'email' : request.form['email']
    }

    user_in_database = User.get_by_email(data)

    if not user_in_database:
        flash("Invalid login information. Try again!")
        return redirect('/')

    if not bcrypt.check_password_hash(user_in_database.password, request.form['password']):
        flash("Invalid login information. Try again!")
        return redirect('/')
    session['current_id'] = user_in_database.id #VERY IMPORTANT

    return redirect('/user_page')

@app.route('/log_out')
def log_out():
    if'current_id' in session:
        del session['current_id']
        return redirect('/')

@app.route('/new_recipe_link')
def click_new_recipe_link():
    return redirect('/new_recipe_page')

@app.route('/new_recipe_page')
def new_recipe_page():
    return render_template('create_recipe_page.html')

@app.route('/delete_recipe/<int:recipe_id>')
def delete_recipe(recipe_id):
    data = {
        'id' : recipe_id
    }

    Recipe.delete_recipe(data)
    return redirect ('/user_page')



    # keep in mind: user = session['user_id']
    #------------------------------------------
    # print(session['user_id'])
    # print(User.get_all_users())
    # for user in User.get_all_users():
    #     if user == session['user_id']:
    #         print(user)