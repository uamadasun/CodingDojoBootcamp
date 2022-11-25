from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.author_model import Author#[Model class name or file name if it's a one to many relationship]
from flask_bcrypt import Bcrypt


@app.route('/')
def author_page():
    all_authors = Author.get_all_authors()
    return render_template('author_home.html', all_authors = all_authors)

@app.route('/create_author', methods = ['POST'])
def create_author():
    data = {
        'name': request.form['name']
    }

    Author.create_author(data)
    return redirect('/')

# @app.route('/author_page/<int:author_id>')
# def author_favorites_page(author_id):
#     data = {
#         'id':author_id
#     }

#     return render_template('author_favorites_page.html')