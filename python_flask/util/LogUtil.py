import logging
from logging import handlers


class Logger(object):
    filename = None
    formatter = '%(asctime)s - %(pathname)s[line:%(lineno)d] - %(levelname)s: %(message)s'
    init = False

    def debug(self, msg=""):
        logger = self.get_logger(level=logging.DEBUG)
        logger.info(msg)

    def info(self, msg=""):
        logger = self.get_logger(level=logging.INFO)
        logger.info(msg)

    def warning(self, msg=""):
        logger = self.get_logger(level=logging.WARNING)
        logger.info(msg)

    def error(self, msg=""):
        logger = self.get_logger(level=logging.ERROR)
        logger.info(msg)

    def critical(self, msg=""):
        logger = self.get_logger(level=logging.CRITICAL)
        logger.info(msg)

    def get_logger(self, level=logging.INFO):
        logger = logging.getLogger(Logger.filename)
        format_str = logging.Formatter(Logger.formatter)
        logger.setLevel(level)
        # 往屏幕上输出
        stream_handler = logging.StreamHandler()
        stream_handler.setFormatter(format_str)
        logger.addHandler(stream_handler)
        if not self.init:
            rotating_file_handler = handlers.RotatingFileHandler(
                filename=Logger.filename, mode='a',
                maxBytes=1024 * 1024 * 500,
                backupCount=5, encoding='utf-8'
            )
            rotating_file_handler.setFormatter(format_str)
            logger.addHandler(rotating_file_handler)
        return logger

    def __init__(self, ):
        pass
