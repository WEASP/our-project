#-*- encoding=UTF-8 -*-

from Application import app, db
from flask_script import Manager
from sqlalchemy import or_,and_
from Application.models import User, Image,Comment
import random

manager = Manager(app)


def get_image_url():
    return 'http://images.nowcoder.com/head/' + str(random.randint(0, 1000)) + 't.png'


@manager.command
def init_database():
    db.drop_all()
    db.create_all()
    for i in range(0, 100):
        db.session.add(User('User'+str(i+1),'a'+str(i+1)))
        for j in range(0, 4): #每人发4张图
            db.session.add(Image(get_image_url(),i+1))
            for k in range(0,3):
                db.session.add(Comment('This is a comment'+str(k),1+3*i+j,i+1))

    db.session.commit()
'''
    for i in range(50,100,2):
        user=user.query.get(i)
        user.username='[New]'+user.username


    User.query.filter_by(id=5).update({'username':'[New2]'})

    for i in range(50,100,2):
        comment=Comment.query.get(i+1)
        db.session.delete(comment)
        #Comment.query.filter_by(id=i+1).delete()

    db.session.comit()


    #print 1,User.query.all()#print all the class of the user object,and there is not attribute
        #print has been called the method of class's __repr__
    print 2,User.query.get(3)
    print 3,User.query.filter_by(id=5).first()
    print 4,User.query.order_by(User.id.desc()).offset(1).limit(2).all()
    print 5,User.query.filter(User.username.endswith('0')).limit(3).all()
    print 6,User.query.filter(or_(User.id==88,User.id==99)).all()
    print 7, User.query.filter(and_(User.id > 88, User.id < 92)).all()
    print 8,User.query.filter(and_(User.id>88,User.id<92)).first_or_404()
    print 9,User.query.order_by(User.id.desc()).paginate(page=1,per_page=10).items
    user=User.query.get(1)
    print 10,user.images

    image=Image.query.get(1)
    print 11,image.user
'''
if __name__ == '__main__':
    manager.run()