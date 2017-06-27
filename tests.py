# -*-encoding=UTF-8 -*-

import unittest
from Application import app


class ApplicationTest(unittest.TestCase):
    def setUp(self):
        print 'setup'
        app.config['TESTING']=True
        self.app=app.test_client()


    # def setUpClass(cls):
    #    print 'setupClass'

    def tearDown(self):
        print 'tearDown'


    # def tearDownClass(cls):
    #    print 'tearDownClass'

    def register(self,username, password):
        return self.app.post('/reg/', data={"username":username,"password":password},follow_redirects=True)
        #  return self.app.post('/reg/', data={"username":username,"password":password},follow_redirects=True) myerror
        # return self.app.post('/reg', data={"username":username,"password":password})   myerror


    def login(self,username,password):
        return self.app.post('/login',data={"username":username,"password":password},follow_redirects=True)
        #return self.app.post('/login',data={"username":username,"password":password})  myerror

    def logout(self):
        return self.app.get('/logout/')

    def test_reg_logout_login(self):
        assert self.register("hello", "world").status_code == 200
        assert '-hello' in self.app.open('/').data
        self.logout()
        assert '-hello' not in self.app.open('/').data
        self.login("hello", "world")
        assert '-hello' in self.app.open('/').data

    def test_profile(self):
        r=self.app.open('/profile/3/',follow_redirects=True)
        assert r.status_code==200
        assert "password" in r.data
        self.register("hello2","world")
        assert self.app.open('/profile/1/',follow_redirects=True).data
