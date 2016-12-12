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