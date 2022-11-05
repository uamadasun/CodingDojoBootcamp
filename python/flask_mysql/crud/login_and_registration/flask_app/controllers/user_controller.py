from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.user_model import User
from flask_bcrypt import Bcrypt
bcrypt = Bcrypt(app)

@app.route('/')
def home_page():
    if 'user_id' in session:
        return redirect('/welcome_page')
    return render_template('home_page.html')

@app.route('/register_user', methods = ['POST'])
def register_user():
    # validate the form here
    if not User.validate_user(request.form):
        return redirect('/')
    
    # create the hash
    hashed_password = bcrypt.generate_password_hash(request.form['password'])
    
    # put the hashed_password into the data dictionary
    data = {
        'first_name':request.form['first_name'],
        'last_name':request.form['last_name'],
        'email':request.form['email'],
        'password':hashed_password 
    }

    # store user id into session
    session['user_id'] = User.register_user(data)

    return redirect('/welcome_page')

@app.route('/welcome_page')
def welcome_page():
    # We have to protect our routes from users not signed in
    if 'user_id' not in session:
        return redirect('/')

    data = {
        'id': session['user_id']
    }
    user = User.get_by_id(data)
    return render_template('welcome_page.html', user=user)

@app.route('/log_out')
def log_out():

    del session['user_id']
    return redirect('/')


@app.route('/log_in', methods = ['POST'])
def log_in():
    data = {
        'email': request.form['email']
    }

    user_in_db = User.get_by_email(data)

    if not user_in_db:
        flash('Invalid login information')
        return redirect('/')
    
    if not bcrypt.check_password_hash(user_in_db.password, request.form['password']):
        flash('Invalid login information')
        return redirect('/')
    session['user_id'] = user_in_db.id
    return redirect('/welcome_page')