import smtplib
from email.header import Header
from email.mime.text import MIMEText


def send_email(user, auth_code, sender, receivers, subject, content, mail_host='smtp.163.com'):
    msg = MIMEText(content, _subtype='html', _charset='utf-8')
    msg['Subject'] = Header(subject, 'utf-8')
    msg['From'] = sender
    msg['To'] = ",".join(receivers)
    try:
        email_client = smtplib.SMTP_SSL(mail_host, 465)  # 启用SSL发信, 端口一般是465
        email_client.login(user, auth_code)  # 登录验证
        email_client.sendmail(sender, receivers, msg.as_string())  # 发送
        email_client.quit()
    except smtplib.SMTPException as e:
        return False
    return True
