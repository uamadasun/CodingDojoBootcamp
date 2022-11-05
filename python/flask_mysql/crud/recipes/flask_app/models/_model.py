from flask_app.config.mysqlconnection import connectToMySQL
# from flask_app.models import _model (import any models for one-to-many relationship?)
from flask_app import app
from flask import flash
import re
from flask_bcrypt import Bcrypt

bcrypt = Bcrypt(app)

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$') 