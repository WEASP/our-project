# Web 应用性能分析 #



----------

----------


## 一.请求数 ##
减少请求数量可以显著提升web应用的性能

**1.http请求头的数据量**

对于每一个请求，都附带了额外的请求头数据，每个http请求都会附加一定的额外信息、每个HTTP请求都会附加一定数据流量的额外信息。当我们请求的资源很小时，HTTP请求头的数据流量甚至会大于资源下载的数据流量。

**2.http请求连接的开销**

用户通过URL下载资源至客户端主要经过以下几个过程：

1. 域名解析

2. 开启TCP连接   

3. 发送请求

4. 等待（主要包括网络延迟和服务器处理时间）  

5. 下载资源

可以发现，在等待响应阶段所花费的时间远远大于下载资源的时间。 如果你仔细的查看资源下载瀑布树，可以发现：

1. 每次请求花费的时间大部分都是在其他阶段，而不是下载资源阶段
2. 很小的资源照样会在非下载阶段花费很多时间，只是下载资源阶段所消耗的时间非常短
而已

**3.减少外部HTTP请求**

在很多情况下，网站的大部分加载时间来自于外部的 Http 请求。外部资源的加载速度随着主机提供商的服务器架构、地点等不同而不同。减少外部请求要做的第一步就是简略地检查网站。消除任何影响访问者体验不好的成分。这些成分可能是：

* 不必要的图片
* 没用的 JavaScript 代码
* 过多的 css
* 多余的插件


在去掉这些多余的成分之后，再对剩下的内容进行整理，如，压缩工具、CDN 服务和预获取（prefetching）等，这些都是管理 HTTP 请求的最佳选择。

----------

## 二.清理HTML文档
HTML 很容易被网络爬虫识别，因此搜索引擎可以根据网站的内容在一定程度上实时更新。

**1.恰当放置CSS**

Web设计者一般在网页建立起主要的 HTML 骨架之后再来创建样式表。这样一来，网页中的样式表往往会放在 HTML 的后面，接近文档结束的地方。然而推荐的做法是把 CSS 放在 HTML 的上面部分，文档头之内，这可以确保正常的渲染过程。
这个策略不能提高网站的加载速度，但它不会让访问者长时间看着空白屏幕或者无格式的文本（FOUT）等待。如果网页大部分可见元素已经加载出来了，访问者才更有可能等待加载整个页面，从而带来对前端的优化效果。

**2.正确放置Javascript**

如果将JavaScript放置在head标签内或HTML文档的上部，这会阻塞HTML和CSS元素的加载过程。这个错误会导致页面加载时间增长，增加用户等待时间，容易让人感到不耐烦而放弃对网站的访问。不过，可以通过将JavaScript属性置于HTML底部来避免此问题。

----------
## 三.优化CSS性能 ##
CSS能从HTML描述的内容生成专业而又整洁的文件。很多 CSS 需要通过 HTTP 请求来引入（除非使用内联 CSS），所以要去除累赘的CSS文件，同时注意保留其重要特征。

如果Banner、插件和布局样式是使用CSS保存在不同的文件内，那么，访问者的浏览器每次访问都会加载很多文件。虽然现在 HTTP/2 的存在，减少了这种问题的发生，但是在外部资源加载的情况下，仍会花费较长时间。

----------

## 四.压缩CSS,JS和HTML ##
压缩技术可以从文件中去掉多余的字符。在编辑器中写代码的时候，会使用缩进和注释，这些方法无疑会让你的代码简洁而且易读，但它们也会在文档中添加多余的字节。
![](http://i.imgur.com/Lg5EBYu.png)


----------

## 五.使用预先获取 ##
预先获取可以在真正需要之前通过取得必需的资源和相关数据来改善访问用户的浏览体验，主要有3类预先获取:

* 链接预先获取
* DNS预先获取
* 预先渲染


在离开当前 web 页面之前，使用预先获取方式，对应每个链接的 URL 地址，CSS，图片和脚本都会被预先获取。这保证了访问者能在最短时间内使用链接在画面间切换。

根据想要使用的预先获取形式，只需在网站 HTML 中的链接属性上增加 rel="prefetch",rel="dns-prefetch"，或者 rel="prerender" 标记。
![](http://i.imgur.com/B16tyJv.png)


----------
## 六.使用CDN和缓存提高速度 ##
内容分发网络能显著提高网站的速度和性能。使用CDN时，可以将网站的静态内容链接到全球各地的服务器扩展网络。CDN允许网站访问者从最近的服务器加载数据。如果使用CDN网站内的文件将自动压缩，以便在全球范围内快速分发。


----------
## 七.使用轻量级框架 ##
可以尝试使用一个好的前端框架来避免许多不必要的前端优化错误。

不仅确定项目所需功能很重要，选择合适的框架也很重要——它要在提供所需功能的同时保持轻量。

以下是几项可以加快读取的轻量级框架：

* Pure
* Skeleton
* Milligram


框架并不能代替网页设计，编程和维护。当使用了一个框架，就有责任确保它不会被冗余的代码，大图片和过多的 HTTP 请求破坏。
