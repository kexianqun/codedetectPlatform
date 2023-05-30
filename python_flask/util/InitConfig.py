from handler.index import api_index
from handler.embedding import embedding_index
from util.FileUtil import read_yaml_file
def init_register_blue_point(app):
    app.register_blueprint(api_index, url_prefix=api_index.url_prefix)
    app.register_blueprint(embedding_index, url_prefix=embedding_index.url_prefix)
def init_website_app_config(app):
    path = "{}/app.yaml".format(app.root_path)
    app_yaml = read_yaml_file(path)
    db_user = app_yaml['website']['database']['username']
    db_pass = app_yaml['website']['database']['password']
    db_name = app_yaml['website']['database']['dbname']
    db_url = app_yaml['website']['database']['url']
    db_port = app_yaml['website']['database']['port']
    db_uri = "mysql+pymysql://{}:{}@{}:{}/{}".format(db_user, db_pass, db_url, db_port, db_name)
    app.config["SQLALCHEMY_DATABASE_URI"] = db_uri
    app.config["SQLALCHEMY_POOL_RECYCLE "] = 10
    app.config["SQLALCHEMY_POOL_SIZE  "] = 30
    app.config["SQLALCHEMY_POOL_TIMEOUT  "] = 3
    app.config["SQLALCHEMY_TRACK_MODIFICATIONS"] = True
