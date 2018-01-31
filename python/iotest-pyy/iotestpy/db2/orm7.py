#!/usr/bin/env python
# -*- coding: utf-8 -*-

from db2.orm2 import session, Student, Class

for student_name, in session.query(Student.name). \
join(Class, Class.address == Student.address).filter(Class.level==3).all():
    print(student_name)
