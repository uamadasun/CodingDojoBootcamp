from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.dojo_model import Dojo
from flask_app.models.ninja_model import Ninja

@app.route('/ninja_page')
def ninja_page():

    return render_template("ninja_page.html", all_dojos = Dojo.show_all_dojos())

@app.route('/create_ninja', methods = ['POST'])
def create_ninja():
    data = {
        'first_name' :request.form['first_name'],
        'last_name' : request.form['last_name'],
        'age' : request.form['age'],
        'dojo_id' : request.form['dojo_id']
    }

    dojo_id = request.form['dojo_id'] 
    Ninja.create_ninja(data)
    return redirect(f'/show_dojo/{dojo_id}')