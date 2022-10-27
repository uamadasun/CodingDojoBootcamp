from flask import Flask  # Import Flask to allow us to create our app
app = Flask(__name__)    # Create a new instance of the Flask class called "app"
@app.route('/')          # The "@" decorator associates this route with the function immediately following
def hello_world():
    return 'Hello World!'
    
# import statements, maybe some other routes
@app.route('/dojo')
def dojo():
  return "Dojo"

@app.route('/say/<string:name>')
def say(name):
    return f"Hi {name.capitalize()}!"

@app.route('/repeat/<int:num>/<string:message>')
def repeat(num,message):
    return f" {message * num} "



  # Return the string 'Hello World!' as a response
if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(port=8000, debug=True)    # Run the app in debug mode.

