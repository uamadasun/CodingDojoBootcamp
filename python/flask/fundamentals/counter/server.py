from flask import Flask, render_template, redirect, session
app = Flask(__name__)
app.secret_key = "keep it secret"

@app.route('/')
def index():
    if 'count' not in session:
        session['count'] = 1
    else:
        session['count'] += 1
    return render_template("index.html")

@app.route('/count')
def count():
    session['count'] += 1
    return redirect('/')

@app.route('/destroy_session')
def rootRouteDestroy():
    del session['count']
    return redirect('/')


if __name__ == "__main__":
    app.run(port = 8000, debug=True)

