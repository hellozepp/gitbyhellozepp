#!/usr/bin/env python
# -*- coding: utf-8 -*-


from sqlalchemy import create_engine
from sqlalchemy.orm import scoped_session, sessionmaker
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, Integer, String

db_connect_string='mysql://root:root@localhost:3306/sqlalchemy?charset=utf8'
Base = declarative_base()

class Account(Base):
    __tablename__ = u'account'

    id = Column(Integer, primary_key=True)
    user_name = Column(String(50), nullable=False)
    password = Column(String(200), nullable=False)
    title = Column(String(50), nullable=False)
    salary = Column(Integer)

    def is_active(self):
        #"""假设所有用户都是活跃用户."""
        return True

    def get_id(self):
        #"""  返回账号ID, 用方法返回属性值提高了表的封装性."""
        return self.id

    def is_authenticated(self):
        #"""假设已经通过验证"""
        return True

    def is_anonymous(self):
        #"""具有登录名和密码的账号不是匿名用户"""
        return False

    __table_args__ = {
        "mysql_charset": "utf8"
    }


engine = create_engine(db_connect_string, max_overflow=5)
SessionType = scoped_session(sessionmaker(bind=engine,expire_on_commit=False))
def GetSession():
    return SessionType()

from contextlib import contextmanager
@contextmanager
def session_scope():
    session = GetSession()
    try:
        yield session
        session.commit()
    except:
        session.rollback()
        raise
    finally:
        session.close()









from sqlalchemy import or_

Base.metadata.create_all(engine)

def InsertAccount( user, passw, title, salary):				#新增操作
    with session_scope() as session:
        account=Account(user_name=user, password=passw, title=title, salary=salary)
	session.add(account)
	return

def GetAccount(id=None, user_name=None):		#查询操作
    with session_scope() as session:
        return session.query(Account).filter(or_(Account.id == id, Account.user_name == user_name)).first()

def DeleteAccount( user_name):				#删除操作
    with session_scope() as session:
        account = GetAccount(user_name=user_name)
	if account:	session.delete(account)

def UpdateAccount( id, user_name, password, title, salary):		#更新操作
    with session_scope() as session:
        account = session.query(Account).filter(Account.id == id).first()
	if not account:
            return
	account.user_name=user_name
	account.password=password
	account.salary = salary
	account.title = title


InsertAccount("David Li", "123", "System Manager", 3000)
InsertAccount("Rebeca Li", "", "Accountant", 3000)
InsertAccount("David Backer", "123", "Engineer", 3000)
InsertAccount("Siemon Bond", "xxx", "Engineer", 4000)
InsertAccount("Van Berg", "123", "General Manager", None)
InsertAccount("Howard", "123", "General Manager", 3000)

account = GetAccount(2)
print(account.user_name, account.salary)

DeleteAccount("Howard")
UpdateAccount(1, "admin", "none", "System Admin", 2000)



with session_scope() as session:
    for account in session.query(Account):
        print(account.id, account.user_name, account.title, account.salary)
    




