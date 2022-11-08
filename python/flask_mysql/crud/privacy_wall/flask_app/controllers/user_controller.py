from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.user_model import User
from flask_app.models.message_model import  Message
from flask_bcrypt import Bcrypt

bcrypt = Bcrypt(app)

@app.route('/')
def home_page():
    if 'user_id' in session:
        return redirect('/dashboard')
        
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
    session['user_id'] = User.register_user(data)
    
    # print(session['user_id'])
    return redirect('/dashboard')

@app.route('/dashboard')
def dashboard():
    if 'user_id' not in session:
        return redirect('/')
    data = {
        'id' : session['user_id']
    }

    user = User.get_by_id(data)

    #get All users
    all_users = User.get_all_users()

    all_messages_received = Message.show_all_messages_for_one_user(data)
    # print(all_messages_received)

    count = 0
    for each_message in all_messages_received:
        count+=1

    return render_template('dashboard.html', user=user, all_users=all_users, all_messages_received = all_messages_received, count=count)



@app.route('/send_message/<int:receiver_id>', methods = ['POST'])
def send_message(receiver_id):


    if 'user_id' not in session:
        return redirect('/')

    if not Message.validate_message(request.form):
        return redirect('/dashboard')

    data = {
        'sender_id': session['user_id'],
        'receiver_id': receiver_id,
        'message': request.form['message']
    }
    
    new_message = Message.create_message(data)

    join_data = {
        'user_id':session['user_id'],
        'message_id':new_message
    }
    # print(new_message)
    Message.insert_into_join_table(join_data)

    return redirect('/dashboard')



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
    session['user_id'] = user_in_database.id #VERY IMPORTANT

    return redirect('/dashboard')


@app.route('/logout')
def log_out():
    if'user_id' in session:
        del session['user_id']
    return redirect('/')

@app.route('/delete_message/<int:message_id>')
def delete_message(message_id):
    if 'user_id' not in session:
        return redirect('/')

    data = {
        'id' : message_id
    }

    Message.delete_message(data)
    return redirect('/dashboard')


    # keep in mind: user = session['user_id']
    #------------------------------------------
    # print(session['user_id'])
    # print(User.get_all_users())
    # for user in User.get_all_users():
    #     if user == session['user_id']:
    #         print(user)