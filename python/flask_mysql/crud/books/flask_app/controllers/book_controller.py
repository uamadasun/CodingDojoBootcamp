from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.author_model import Author
from flask_app.models.book_model import Book

from flask_bcrypt import Bcrypt

@app.route('/add_book')
def click_add_book():
    return redirect('/books_page')

@app.route('/books_page')
def book_page():
    all_books = Book.get_all_books()
    return render_template('books_page.html', all_books = all_books)

@app.route('/create_book', methods = ['POST'])
def create_book():
    data = {
        'title':request.form['title'],
        'num_of_pages': request.form['num_of_pages']
    }

    Book.create_book(data)
    return redirect('/books_page')

@app.route('/link_show_book/<int:book_id>')
def show_one_book(book_id):
    data = {
        'id':book_id
    }

    this_book = Book.show_one_book(data)
    all_authors = Author.get_all_authors()
    

    return render_template('show_one_book.html', this_book=this_book, all_authors= all_authors)


@app.route('/create_favorite/<int:book_id>/', methods = ['POST'])
def create_favorite(book_id):
    data = {
        'author_id': request.form['book_fave_author'],
        'book_id': book_id
    }

    print("DATA----------",data)


    new_insert = Book.insert_into_join_table(data)
    print('GOING INTO JOIN TABLE', new_insert)
    pint('book id',book_id)
    return redirect(f'/link_show_book/{book_id}')

