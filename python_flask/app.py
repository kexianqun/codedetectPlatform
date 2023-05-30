from flask import Flask, request, render_template
from flask_uuid import FlaskUUID

from entity.models import db
from util.InitConfig import init_website_app_config, init_register_blue_point
from util.WebUtil import get_host, get_port

# define app
app = Flask(__name__, static_folder='static', static_url_path='')
# init app config
init_website_app_config(app)
init_register_blue_point(app)
FlaskUUID(app)
with app.app_context():
    db.init_app(app)
    db.create_all()

@app.teardown_appcontext
def shutdown_session(exception=None):
    db.session.remove()


@app.route("/favicon.ico")
def favicon():
    filename = "public/{}/favicon.ico".format("style1")
    return app.send_static_file(filename)


if __name__ == '__main__':
    app.run(host=get_host(app), port=get_port(app), debug=True)
