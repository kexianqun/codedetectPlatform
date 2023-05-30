from flask_sqlalchemy import SQLAlchemy
from sqlalchemy.ext.declarative import declarative_base

db = SQLAlchemy()

Base = declarative_base()




class User(db.Model):
    __tablename__ = 'user'
    id = db.Column(db.String(36), primary_key=True)
    uuid = db.Column(db.String(36))
    username = db.Column(db.String(64))
    password = db.Column(db.String(64))
