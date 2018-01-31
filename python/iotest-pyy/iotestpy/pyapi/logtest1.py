import logging
import logging.handlers

LOG_FILE = "/home/andilyliao/PycharmProjects/iotest-py/zinoutfiles/tst.log"

handler = logging.handlers.RotatingFileHandler(LOG_FILE, maxBytes=1024 * 1024, backupCount=5)  # 实例化handler
fmt = "%(asctime)s - %(filename)s:%(lineno)s - %(name)s - %(message)s"

formatter = logging.Formatter(fmt)  # 实例化formatter
handler.setFormatter(formatter)  # 为handler添加formatter

logger = logging.getLogger("tst")  # 获取名为tst的logger
logger.addHandler(handler)  # 为logger添加handler
logger.setLevel(logging.INFO)

logger.info("first info message")
logger.debug("first debug message")
logger.error("first error message")