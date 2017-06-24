#-*- encoding=UTF-8 -*-

from Application import app,db
from models import Image,User
from flask import render_template,redirect,request,flash,get_flashed_messages,send_from_directory
import random,hashlib,json,os,uuid
from flask_login import login_user,current_user,login_required,logout_user


@app.route('/')
def index():
    image=Image.query.order_by('id desc').limit(10).all()
    return render_template('index.html',images=image)


@app.route('/image/<int:image_id>')
def image(image_id):
    image=Image.query.get(image_id)
    if image == None:
        return redirect('/')
    return render_template('pageDetail.html',image=image)


@app.route('/profile/<int:user_id>')
@login_required             #indicate that following pages are need to required authenticated
def profile(user_id):
    user=User.query.get(user_id)
    if user == None:
        return redirect('/')
    paginate=Image.query.filter_by(user_id= user_id).paginate(page=1,per_page=3,error_out=False)
    print paginate.has_next
    #return render_template('profile.html',user=user,image=paginate.items,hsa_next=paginate.has_next)
    return render_template('profile.html', user = user, has_next=paginate.has_next, images=paginate.items)


@app.route('/profile/images/<int:user_id>/<int:page>/<int:per_page>/')
def user_images(user_id,page,per_page):
    paginate=Image.query.filter_by(user_id=user_id).paginate(page=page,per_page=per_page)
    map={'has_next':paginate.has_next}
    images=[]
    for image in paginate.items:
        imgvo={'id':image.id,'url':image.url,"comment_count":len(image.comments)}
        images.append(imgvo)

    map['image']=images
    return json.dumps(map)

@app.route('/regloginpage/')
def regloginpage():
    msg=''
    #print get_flashed_messages(with_categories=False, category_filter=['reglogin'])
    for m in get_flashed_messages(with_categories=False,category_filter=['reglogin']):
        msg=msg+m
    #print msg
    return render_template("login.html",msg=msg,next=request.values.get('next'))


def redirect_with_msg(target,msg,category):
    if msg!=None:
        flash(msg,category=category)
    return redirect(target)


@app.route('/login/',methods={'post','get'})
def login():
    username=request.values.get('username').strip()
    password=request.values.get("password").strip()
    user=User.query.filter_by(username=username).first()
    if user is None or password is None:
        return redirect_with_msg('/regloginpage/',u"Please input the valid username and password!",'reglogin')

    m=hashlib.md5()
    m.update(password + user.salt)
    if m.hexdigest() != user.password:
        return redirect_with_msg('/regloginpage/',u"The username don't match with the password!",'reglogin')

    next=request.values.get('next')
    if next!=None and next.startswith('/') is True:
        return redirect(next)
    return redirect('/')


@app.route('/reg/',methods={'get','post'})
def reg():
    username=request.values.get('username').strip()
    password=request.values.get('password').strip()
    if username==''or password=='':
        return redirect_with_msg('/regloginpage',u"The username and password can't has null value.",'reglogin')

    user=User.query.filter_by(username=username).first()
    if user != None:
        return redirect_with_msg('/regloginpage/',u"The username has been registred.You should register new name again.",'reglogin')

    salt='.'.join(random.sample('0123456789abcdefghiAbCDEFGHI',10))
    m=hashlib.md5()
    m.update(password+salt)
    password=m.hexdigest()
    user=User(username,password,salt)
    db.session.add(user)
    db.session.commit()

    login_user(user)
    next=request.values.get('next')
    if next !=None and next.startswith('/')>0:
        return redirect(next)
    return redirect('/')


@app.route('/logout/')
def logout():
    logout_user()
    return redirect('/')


def save_to_local(file,file_name):
    save_dir=app.config['UPLOAD_DIR']
    file.save(os.path.join(save_dir,file_name))
    return '/image/'+file_name


@app.route('/image/<image_name>/')
def view_image(image_name):
    return send_from_directory(app.config['UPLOAD_DIR'],image_name)


@app.route('/upload',methods={'post'})
def uoload():
    #print type(request.files)
    #type(request.files)
    file=request.files['file']
    #dir(file)
    #print dir(file)
    file.ext=''
    if file.filename.find('.') is True:
        file_ext=file.filename.rsplit('.',1)[1].strip().lower()
        #from the most righr part and after the doc chosing the filename extension and transforming lower
    if file_ext in app.config['ALLOWED_EXT']: #please notice the method of calling app.config
        file_name=str(uuid.uuid1().replace('-','')+'.'+file_ext)
        url=save_to_local(file,file_name)
        if url !=None:
            db.session.add(Image(url,current_user.id))
            db.session.commit()

    return redirect('/profile/%d'%current_user.id)
