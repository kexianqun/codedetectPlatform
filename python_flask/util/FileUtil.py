import json
import os

import yaml


def list_files(path, list_all=False):
    all_files = []
    for file in os.listdir(path):
        cur_path = os.path.join(path, file)
        if os.path.isdir(cur_path) and list_all:
            all_files.append({file: list_files(cur_path, list_all)})
        else:
            all_files.append(file)
    return all_files


def write_object_to_json_file(obj, file_path):
    json_str = json.dumps(obj, ensure_ascii=False)
    with open(file_path, 'w', encoding='utf-8') as f:
        f.write(json_str)
    return True


def read_yaml_file(path):
    with open(path, 'rb') as f:
        decode_content = yaml.safe_load(f.read())
    return decode_content


def create_file_with_path(filename, content=''):
    if filename.find('.') == -1:
        return False
    filename = filename.replace('\\', '/')
    folders = filename.split('/')
    path = ''
    for index in range(len(folders)):
        if folders[index].find('.') == -1:
            path += '{}/'.format(folders[index])
        else:
            path += '{}'.format(folders[index])
        if not os.path.exists(path) and path.find('.') == -1:
            os.makedirs(path)
    with open(path, 'w', encoding='utf-8') as f:
        f.write(content)
    return True


def get_file_content(path):
    with open(path, 'r', encoding='utf-8') as f:
        return f.read()


def put_article_content(path, content):
    with open(path, 'w') as f:
        return f.write(content)


def create_folder(path):
    filename = path.replace('\\', '/')
    folders = filename.split('/')
    new_path = ''
    for index in range(len(folders)):
        new_path += '{}/'.format(folders[index])
        if not os.path.exists(new_path):
            os.makedirs(new_path)
    return True