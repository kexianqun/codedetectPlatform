import uuid

import pymysql
from pymysql.converters import escape_string

from util.FileUtil import get_file_content, create_file_with_path


def get_connection():
    conn = pymysql.connect(
        host='getop.site',
        user='root',
        password='286348794zz',
        database='e_blog',
        charset='')
    return conn


def get_content(c):
    if c:
        return c
    else:
        return ''


def insert_record(item, cnn):
    cursor = cnn.cursor()
    sql = "insert into article(uuid,summary,title,content_url," \
          "pic_url,status,is_top,has_source," \
          "view_count,create_at,create_by,update_at," \
          "update_by,update_times,is_comment,is_draft," \
          "comment_count,document_type,group_id) " \
          "value(%s, %s,%s, %s," \
          "%s, %s,%s, %s," \
          "%s,%s, %s,%s, " \
          "%s,%s, %s,%s, " \
          "%s,%s,%s)".format()
    uid = str(uuid.uuid4())
    print(uid)
    cursor.execute(sql, [
        uid, item['article_summary'], item['article_title'], item['article_content_url'],
        item['article_pic_url'], item['article_status'], item['article_is_top'],
        0 if item['article_source_id'] == 0 else 1,
        item['article_view_num'], item['article_create_time'], item['article_from_user'], item['article_last_update'],
        item['article_from_user'], 1, item['article_is_comment'], item['article_is_draft'],
        item['article_comment_num'], item['article_document_type'], item['article_group_id']
    ])
    create_local_text(item, uid)


def create_local_text(item, uid):
    base = "E:/Project/e-blog/static/resource/user/article"
    creat_time = str(item['article_create_time']).split(' ')[0]
    filename = '{}/{}/{}.{}'.format(base, creat_time, item['id'],
                                    'html' if item['article_document_type'] == 'html' else 'md')
    newfile = '{}/{}/{}.{}'.format(base, creat_time, uid,
                                   'html' if item['article_document_type'] == 'html' else 'md')
    try:
        content = get_file_content(filename)
    except  Exception as e:
        print("error")
    else:
        print(newfile)
        create_file_with_path(newfile, content)


def transfer():
    cnn = get_connection()
    cursor = cnn.cursor(cursor=pymysql.cursors.DictCursor)
    sql = "select * from geticsen_article"
    cursor.execute(sql)
    data = cursor.fetchall()
    for item in data:
        insert_record(item, cnn)
        print(item)
    cnn.commit()
    cnn.close()


def insert_friend_link(item, cnn):
    cursor = cnn.cursor()
    uid = str(uuid.uuid4())
    print(uid)
    sql = "insert into e_friend_link(uuid,name,status," \
          "avatar,url,description," \
          "create_at,create_by,update_at,update_by) " \
          "value('{}','{}','{}','{}','{}','{}','{}','{}','{}','{}')".format(uid,escape_string(item['friend_link_name']), "publish", escape_string(item['friend_link_head_url'])
        , escape_string(item['friend_link_url']), escape_string(item['friend_link_desc']), item['friend_link_create_time']
        , "geticsen", item['friend_link_last_update'], "geticsen")
    print(sql)
    cursor.execute(sql)


def transfer_friend_link():
    cnn = get_connection()
    cursor = cnn.cursor(cursor=pymysql.cursors.DictCursor)
    sql = "select * from geticsen_friend_link"
    cursor.execute(sql)
    data = cursor.fetchall()
    for item in data:
        if item['friend_link_status'] == 1:
            print(item)
            insert_friend_link(item, cnn)
    cnn.commit()
    cnn.close()


def get_archive_date(create_at):
    return str(create_at)[0:7]


def update_archive(item, cnn):
    cursor = cnn.cursor()
    sql = "update article set archive = %s where uuid = %s".format()
    date = get_archive_date(item['create_at'])
    cursor.execute(sql, [
        date, item['uuid']
    ])


def add_archive():
    cnn = get_connection()
    cursor = cnn.cursor(cursor=pymysql.cursors.DictCursor)
    sql = "select * from article "
    cursor.execute(sql)
    data = cursor.fetchall()
    for item in data:
        update_archive(item, cnn)
    cnn.commit()
    cnn.close()


if __name__ == '__main__':
    transfer_friend_link()
