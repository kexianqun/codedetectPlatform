import jwt
from jwt import PyJWTError


def create_jwt_token(payload=None, secret='', algorithm='HS256'):
    if payload is None:
        payload = {}
    token = jwt.encode(payload, key=secret, algorithm=algorithm)
    return token


def check_jwt_token(token, secret='', algorithm='HS256'):
    is_jwt = True
    try:
        jwt.decode(token, key=secret, algorithms=algorithm)
    except PyJWTError:
        is_jwt = False
    return is_jwt


def decode_jwt_token(token, secret='', algorithm='HS256'):
    try:
        payload = jwt.decode(token, key=secret, algorithms=algorithm)
    except PyJWTError:
        payload = {}
    return payload
