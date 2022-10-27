from flask import Flask, render_template
app = Flask(__name__)

@app.route('/play/<int:nums>/<string:color>')
def playground(nums,color):
    return render_template("index.html", nums=nums, color=color)

if __name__ == "__main__":
    app.run(port=8000, debug=True)