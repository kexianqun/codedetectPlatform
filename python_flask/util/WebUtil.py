from util.FileUtil import read_yaml_file

GITLAB = "X-Gitlab-Token"
GITEE = "X-Gitee-Token"
CODE_UP = "X-Codeup-Token"


def get_host(app):
    app_yaml = get_app_yaml(app)
    return app_yaml['server']['host']


def get_port(app):
    app_yaml = get_app_yaml(app)
    return app_yaml['server']['port']


def get_website_style(app):
    app_yaml = get_app_yaml(app)
    return app_yaml['website']['style']


def get_web_hook_token(request, parm=GITEE):
    return request.headers.get(parm)


def get_server_secret(app):
    app_yaml = get_app_yaml(app)
    return app_yaml['server']['secret']


def get_server_upload(app):
    app_yaml = get_app_yaml(app)
    return app_yaml['server']['upload_path']


def get_app_yaml(app):
    path = "{}/app.yaml".format(app.root_path)
    return read_yaml_file(path)



def get_login_username():
    return 'getopsite'


def get_email(app):
    app_yaml = get_app_yaml(app)
    return app_yaml['website']['email']


def get_auth_code(app):
    app_yaml = get_app_yaml(app)
    return app_yaml['website']['password']
