﻿# web应用设计

## 一、交互设计
### 1、用户页面组织
用户页面需要展示大量的信息、信息上的操作，以及信息之间的关系。
问题广场的应用界面首页如图：
![Paste_Image.png]![mark](http://oroucdagq.bkt.clouddn.com/blog/170617/jb7fhjcKhb.jpg?imageslim)
其具有以下特点：
#### （1）向用户展示了问题广场的主要内容信息，即提问和回答。
#### （2）展示了几项主要操作：提问，评论，点赞，关注，搜索，注册，登录等。
#### （3）应用界面具有滚动功能。
#### （4）应用界面具有很强的可移植性。
### 2、导航设计
问题广场的导航设计如图所示：

![Paste_Image.png](http://oroucdagq.bkt.clouddn.com/blog/170617/4bD4H5lAee.png?imageslim)
有以下功能：
#### （1）链接认知功能：当用户需要寻找问题时，可进入搜索模块，输入关键字寻找关联的问题。如像寻找带有“后台”关键字的问题，可在搜索栏中输入“后台”，结果如图：

![Paste_Image.png](http://oroucdagq.bkt.clouddn.com/blog/170617/hl4gJbE77h.png?imageslim)

#### （2）方向援助功能：当用户找不到自己所在页面位置时，可点击“首页”返回首页；当用户想寻找自己关注或浏览过的问题时，可点击“发现”找到。
### 3、出错处理及出错跳转页面
问题广场的出错处理部分主要体现在用户登录界面：

![Paste_Image.png](http://oroucdagq.bkt.clouddn.com/blog/170617/GkGb12e3hg.png?imageslim)
当输入的帐号有误时，会提示

![Paste_Image.png](http://oroucdagq.bkt.clouddn.com/blog/170617/hkeLJbgh7g.png?imageslim)
当输入的账户存在但是密码有误时，会提示

![Paste_Image.png](http://oroucdagq.bkt.clouddn.com/blog/170617/CF4JhEcliG.png?imageslim)
## 二、展示设计
问题广场的主页设计上文已经给出，主要有如下设计特点：
### 1、采用国字型布局。
这种传统的布局方式，能让绝大多数用户感觉操作方便简单，内容明了，不会让用户难以上手

![Paste_Image.png](http://oroucdagq.bkt.clouddn.com/blog/170617/5K5jA8EfE9.png?imageslim)

### 2、符合用户行为习惯
大多数用户浏览习惯是从上到下，因此用户能迅速看到主页的导航和主题内容，能快速获取自己想要得到的信息。
### 3、美学设计令人愉悦
问题广场的文字、图片搭配合理，颜色清爽、干净，要素协调，充分并有效地利用空间格局，追求页面的静态美，内容明确，易用可读，并且提供站内搜索。
## 三、内容设计
### 1、内容设计
问题广场为用户主要提供了以下可用内容：
#### （1）提问
登陆后点击导航栏的“提问”按钮

![Paste_Image.png](http://oroucdagq.bkt.clouddn.com/blog/170617/5ck1I5gCf5.png?imageslim)
即可进入问题编辑页面

![Paste_Image.png](http://oroucdagq.bkt.clouddn.com/blog/170617/I8LD5jadkf.png?imageslim)
输入问题的题目，并在下框中填写问题的补充性说明

![Paste_Image.png](http://oroucdagq.bkt.clouddn.com/blog/170617/k3LCDKfL08.png?imageslim)

点击“发布”，提出的问题就会出现在页面主体部分“最新动态”的第一个

![Paste_Image.png]](http://oroucdagq.bkt.clouddn.com/blog/170617/6eh5agK86a.png?imageslim)
#### （2）发布回答
当用户看到自己有能力回答的问题时，可点击问题，即可转到“发布答案”页面

![Paste_Image.png](http://oroucdagq.bkt.clouddn.com/blog/170617/cml5H7BAa9.png?imageslim)
在方框中填写答案，并点击“发布回答”按钮，即可发布

![Paste_Image.png](http://oroucdagq.bkt.clouddn.com/blog/170617/DAc0a85g6J.png?imageslim)

答案在问题下予以显示

![Paste_Image.png](http://oroucdagq.bkt.clouddn.com/blog/170617/LhK9g182K3.png?imageslim)

#### （3）点赞与关注
在问题界面点击左侧箭头上按钮，即可对用户认为好的回答进行点赞，点赞后，该按钮上数字会发生变化，如一人点赞就会显示“1”

![mark](http://oroucdagq.bkt.clouddn.com/blog/170617/L8F98h54Bh.png?imageslim)
同理，如果用户对问题的回答不认可，也可点击箭头下按钮，表示不赞同。
如果用户想持续关注这个问题的后续答案，可以点击问题下方的“关注提问”，这样一旦有新的回答，会在“发现”界面给与用户通知

![mark](http://oroucdagq.bkt.clouddn.com/blog/170617/if7kbmC46f.png?imageslim)
#### （4）站内私信
如果用户想与问题广场的其他用户进行私下交流，可以点击“消息”按钮

![mark](http://oroucdagq.bkt.clouddn.com/blog/170617/eiBKALc5ea.png?imageslim)
填写要发给的用户昵称，并输入内容，点击发送，对方即可收到消息。
#### （5）个人主页
问题广场还提供了“个人主页”功能，先将鼠标指向自己头像，出现下拉栏，点击“个人主页”即可进入

![mark](http://oroucdagq.bkt.clouddn.com/blog/170617/hghI78K2ma.png?imageslim)
个人主页中主要显示了自己的动态，如粉丝，关注，回答，点赞等信息

![mark](http://oroucdagq.bkt.clouddn.com/blog/170617/eCG0EEj9E8.png?imageslim)

### 2、导航设计
问题广场的导航按钮和使用方法已在上文中详细介绍和说明过，此处不在赘述。
