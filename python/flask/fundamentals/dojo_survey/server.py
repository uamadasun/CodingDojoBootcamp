from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = "keep it secret"

@app.route('/')
def display_form():
    return render_template("index.html")

@app.route('/form_submit', methods=['POST'])
def form_submit():
    session['name'] = request.form['name']
    
    session['location'] = request.form['location']
    
    session['language'] = request.form['language']
    
    session['comment'] = request.form['comment']
    return redirect('/results')

@app.route('/results')
def submit():
    return render_template("submission.html")


if __name__ == "__main__":
    app.run(port = 8000, debug=True)