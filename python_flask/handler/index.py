from flask import Blueprint, jsonify
from service import UserService

api_index = Blueprint('api_index', __name__)
api_index.url_prefix = '/api'


@api_index.route("/test/<path:uuid>", methods=["POST", "GET"])
def test(uuid):
    print("path: ", uuid)
    user = UserService.get_user_by_uuid(uuid)
    return jsonify({'username': user.username, 'password': user.password, "uuid": user.uuid})
    # return jsonify({'data': user, 'ok': True})



