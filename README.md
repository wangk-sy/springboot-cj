# springboot-cj
springboot-cj项目是一个单体项目，未采用前后端分离开发，后端采用spring boot框架，前端则使用的是themleaf模板引擎。该项目是一个文件（主要是图片和pdf）
上传以及预览项目，中间还需要调用其他项目的webservice接口实现一些功能。项目并未使用数据库，而是通过接口进行数据的传输和保存。文件的存储和管理使用的是fastDFS
分布式文件存储系统，前端的一些功能，比如预览和上传等，采用了一些前端的插件，如viewer.js,modal.js,pdf.js,bootstrap-fileinput等等。

![预览](https://github.com/wangk-sy/springboot-cj/blob/master/1597372687.jpg?raw=true)
![预览](https://github.com/wangk-sy/springboot-cj/blob/master/1597373425.jpg?raw=true)
