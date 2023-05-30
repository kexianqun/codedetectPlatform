import uuid

from entity.models import User
from entity.models import db


def get_user_by_uuid(uuid):
    return db.session.query(User).filter(User.uuid == uuid).first()


def get_user_by_account(account, account_type):
    return db.session.query(User).filter(User.type == account_type).filter(User.third_part_account == account).first()


def assemble_user_qq_login(user_info, openid):
    user = User()
    user.uuid = uuid.uuid4()
    user.username = ''

    user.password = ''
    return user


def save_user_by_qq(user):
    db.session.add(user)
    db.session.commit()
    db.session.close()
