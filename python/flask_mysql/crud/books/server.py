from flask_app.controllers import author_controller
from flask_app.controllers import book_controller
#import controller files
from flask_app import app




if __name__ == "__main__":
    app.run(port = 8000, debug=True)