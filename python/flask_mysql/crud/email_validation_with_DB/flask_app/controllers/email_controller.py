from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.email_model import Email

@app.route('/')
def show_home():
    return render_template('index.html')


@app.route('/create_email', methods = ['POST'])
def create_email():
    data = {
    'email' :request.form['email'],
    }
    if not Email.validate_email(request.form):
        return redirect('/')

    Email.create_email(data)
    return redirect('/show_all_emails')

@app.route('/show_all_emails')
def show_all_emails():
    all_emails = Email.show_all_emails()
    latest_email=all_emails[-1]
    return render_template('all_emails.html', all_emails=all_emails, latest_email=latest_email)

@app.route('/delete_email/<int:email_id>')
def delete_email(email_id):
    data = {
        'id' : email_id
    }
    Email.delete_email(data)
    return redirect('/show_all_emails')