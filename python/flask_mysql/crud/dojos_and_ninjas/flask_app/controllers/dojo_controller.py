from flask_app import app
from flask import render_template, redirect, request, session, flash
from flask_app.models.dojo_model import Dojo
from flask_app.models.ninja_model import Ninja

@app.route('/dojos')
def home_page():

    return render_template('dojos.html', all_dojos = Dojo.show_all_dojos())

@app.route('/create_dojo', methods= ['POST'])
def create_dojo():
    data = {
    "name": request.form['dojo_name']
    }
    Dojo.create_dojo(data)
    return redirect('/dojos')

@app.route('/show_dojo/<int:dojo_id>')
def get_one_dojo(dojo_id):
    data = {
        'id':dojo_id
    }

    return render_template("show_dojo.html", dojo=Dojo.show_ninjas_in_dojo(data))