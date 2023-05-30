import json

from flask import Blueprint, jsonify
from service import GetEmbeddings_soliditty

embedding_index = Blueprint('embedding_index', __name__)
embedding_index.url_prefix = '/embedding'


@embedding_index.route("/solidity/<path:tokens>", methods=['POST', 'GET'])
def embeddings(tokens):
    print("path: ", tokens)
    embedding = GetEmbeddings_soliditty.get_sentence_embedding(tokens)
    print(embedding)
    return json.dumps(embedding)
    # return jsonify({'embedding': embedding})
    # return jsonify({'data': user, 'ok': True})v
