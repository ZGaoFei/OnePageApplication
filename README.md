# OnePageApplication
This is a test application.In the application include some new frameworks that current more popular.

添加依赖的时候默认是添加：

    compile 'com.google.dagger:dagger:2.8'
    annotationProcessor 'com.google.dagger:dagger-compiler:2.8'

如果上面的添加报错：

    Error:(212, 0) Could not find method annotationProcessor()
    for arguments [com.google.dagger:dagger-compiler:2.8]
    on object of type org.gradle.api.internal.artifacts.dsl.dependencies.DefaultDependencyHandler.
    可以用下面的方式进行添加

如果项目里面没有依赖Java注解的库需要添加：

    compile 'com.google.dagger:dagger:2.8'
    compile 'com.google.dagger:dagger-compiler:2.8'
    provided 'org.glassfish:javax.annotation:10.0-b28'


使用 MVP 模式

    M 层：net 包，当前只包含访问网络。
    数据库操作，文件操作都应该放在 M 层

    V 层：ui 包，包含 Activity，Fragment

    P 层：presenter 包，相应的 ui 页面，对应相应的 Presenter

    app,base 包：application 和基类和常量类

    contract：协议包，即定义接口分别声明对应的 V 层 ui 界面应该完成的操作
    和 P 层 presenter 应该完成的操作
    说明：在 presenter 中调用 ui 中实现的方法，在 ui 中调用 presenter 中实现的方法

    dagger 包：试用 dagger2 将 P 层注入到 V 层，将 M 层注入到 P 层
    说明：V 层是通过接口关联到 P 层的（BasePresenter）

    model 包：返回数据的模型

    utils 包：封装的工具类