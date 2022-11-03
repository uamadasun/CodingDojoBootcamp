from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.user_model import User


@app.route('/')
def home_page():
    return render_template('index.html')



@app.route("/users/new", methods=['POST'])
def create_users():
    data = {
    # "id":request.form['id'],
    "first_name": request.form['first_name'],
    "last_name": request.form['last_name'],
    "email": request.form['email'],
    # "created_at": request.form['created_at'],
    # "updated_at": request.form['updated_at']
    }
    User.add_user(data)
    return redirect("/users")



@app.route('/users')
def all_users_page():
    return render_template('users.html', all_users = User.get_all())



@app.route('/get_one/<int:user_id>')
def get_one_user(user_id):
    data = {
        'id': user_id
    }
    return render_template("get_one.html",user= User.get_one_user(data))



@app.route('/delete/<int:user_id>')
def delete_user(user_id):
    data = {
        'id':user_id
    }
    User.delete_user(data)
    return redirect('/users')



@app.route('/update_form/<int:user_id>')
def update_page(user_id):
    data = {
        'id':user_id
    }
    return render_template('update_user.html', user = User.get_one_user(data))



@app.route('/update/<int:user_id>', methods = ['POST'])
def update(user_id):
    data = {
        'id': user_id,
        'first_name':request.form['first_name'],
        'last_name': request.form['last_name'],
        'email': request.form['email']
    }

    User.update_user(data)
    return render_template('get_one.html', user = User.get_one_user(data))