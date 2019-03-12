## IntelliJ IDEA 2018.2创建Maven项目dubbo部署

演示demo已经上传到github上了,有需要到朋友可以自行查看:
https://github.com/dsYangTM/dubbodemo

基于maven的dubbo部署,自己建了个demo跑了一下,环境配的我头都炸了,不过最后还是跑通了,写此文总结一下:
### 一:Cerate New Project(新建项目)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107163055552.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
创建maven项目,选择jdk,这里不用选择create from archetype(进去以后再配maven),直接下一步

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107163710683.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
填写GroupId和ArtifactId

GroupId和ArtifactId是确定项目在Maven仓库中的坐标，具有唯一性，可以通过他们去查找项目。

GroupId一般分为多个段，第一段为域，第二段为公司名称。域又分为org、com、cn等等。

ArtifactId是工程项目名。![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107164820897.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)

填写Project name以及项目的物理地址。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107170001743.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
点击ok
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107170051385.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
选择Enable Auto-Imported.(自动导入)![在这里插入图片描述](https://img-blog.csdnimg.cn/2018110717023620.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
找到配置输入maven设置
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107205554701.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)

## 二:填写Maven home directory，设置settings.xml文件、local repository![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107210137712.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
dubbo-service的pom.xml添加依赖,端口为8081,跟8080区分开
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>cn.dsyang.dubbodemo</groupId>
    <artifactId>dubbo-service</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>

    <properties>
        <spring.version>4.2.4.RELEASE</spring.version>
    </properties>

    <dependencies>
        <!-- Spring -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jms</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>${spring.version}</version>
        </dependency>

        <!-- dubbo相关 -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>dubbo</artifactId>
            <version>2.8.4</version>
        </dependency>
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.4.6</version>
        </dependency>
        <dependency>
            <groupId>com.github.sgroschupf</groupId>
            <artifactId>zkclient</artifactId>
            <version>0.1</version>
        </dependency>

        <dependency>
            <groupId>javassist</groupId>
            <artifactId>javassist</artifactId>
            <version>3.11.0.GA</version>
        </dependency>

    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.3.2</version>
                <configuration>
                    <source>1.7</source>
                    <target>1.7</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.tomcat.maven</groupId>
                <artifactId>tomcat7-maven-plugin</artifactId>
                <configuration>
                    <!-- 指定端口 -->
                    <port>8081</port>
                    <!-- 请求路径 -->
                    <path>/</path>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

在工程的``webapp``下创建WEB-INF文件夹，创建``web.xml``,(此时的webapp文件上一定要有小蓝点)![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107212717139.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         version="2.5">
    <!-- 加载spring容器 -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:applicationContext*.xml</param-value>
    </context-param>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
</web-app>
```
### 三:这里需要检查项目配置。
打开File>Project Struction。
### project:![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107220436143.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)

### Modules:
选择项目名字:![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107220605562.png)
### Sources:

将java设置为Sources,resources设置为Resources,target设置为Excluded。![在这里插入图片描述](https://img-blog.csdnimg.cn/2018110722081997.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
### paths：
设置java源代码编译的目标目录。![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107221021747.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
### Dependencies:

设置依赖。![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107221134302.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
### Facets:
选择web.xml和webapp文件夹位置：![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107221535356.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
``这些配置对了基本上就没太大问题了``


接下来创建业务接口
创建包``cn.dsyang.dubbodemo.service``，用于存放业务接口，创建接口

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107214039817.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
创建业务实现类
创建包``cn.dsyang.dubbodemo.service.impl ``，用于存放业务实现类。创建业务实现类：``注意：Service注解与原来不同，需要引入com.alibaba包下的``
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107214122751.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)

在resources下创建``applicationContext-service.xml``

    application name:填项目名称即可
    registry address:你远程zookeeper的ip地址(我是装在linux虚拟机里的)
    annotation package:你实现类的包地址(用于扫描@Service注解。)

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:dubbo="http://code.alibabatech.com/schema/dubbo" xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://code.alibabatech.com/schema/dubbo http://code.alibabatech.com/schema/dubbo/dubbo.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <dubbo:application name="dubbo-service"/>
    <dubbo:registry address="zookeeper://172.16.161.130:2181"/>
    <dubbo:annotation package="cn.dsyang.dubbodemo.service.impl" />
</beans>
```
这里service服务提供者就创建完了,可以右键项目运行clean install,然后tomcat7:run,把项目跑起来(然而这个项目单独跑并没什么卵用,需要搭配服务消费者一起使用)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107215305216.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)

接下来是创建服务消费者也就是web的demo

创建Maven工程（WAR）dubbo-web (``这里一定要注意,之前就是因为选中了dubbo-service新建的module项目一直跑起不来``)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107222617532.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
接下来跟新建service项目差不多,直接next

![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107222852798.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
输入GroupId和ArtifactId![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107223000343.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
输入module name,  
content root
module file location
然后finish
![在这里插入图片描述](https://img-blog.csdnimg.cn/2018110722305256.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
在webapp目录下创建WEB-INF 目录，并创建web.xml 

```
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         version="2.5">
    <!-- 解决post乱码 -->
    <filter>
        <filter-name>CharacterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>CharacterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <servlet>
        <servlet-name>springmvc</servlet-name>  	
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!-- 指定加载的配置文件 ，通过参数contextConfigLocation加载-->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:applicationContext-web.xml</param-value>
        </init-param>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>*.do</url-pattern>
    </servlet-mapping>
</web-app>
```
拷贝业务接口
将“dubbo-service”工程的cn.dsyang.dubbodemo.service 包以及下面的接口拷贝至此工程。
编写Controller ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107223805107.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)
编写spring配置文件
在src/main/resources下创建applicationContext-web.xml 
参数同service项目类似(不再赘述了)
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:p="http://www.springframework.org/schema/p"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:dubbo="http://code.alibabatech.com/schema/dubbo" xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd
        http://code.alibabatech.com/schema/dubbo http://code.alibabatech.com/schema/dubbo/dubbo.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">

    <mvc:annotation-driven >
        <mvc:message-converters register-defaults="false">
            <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                <constructor-arg value="UTF-8" />
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>
    <!-- 引用dubbo 服务 -->
    <dubbo:application name="dubbo-web" />
    <dubbo:registry address="zookeeper://172.16.161.130:2181"/>
    <dubbo:annotation package="cn.dsyang.dubbodemo.controller" />
</beans>
```
最后测试运行
tomcat7:run(``先运行dubbo-service,再运行dubbo-web``)
在浏览器输入http://localhost:8082/user/showName.do，
查看浏览器输出结果
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181107224201665.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2RzX1lhbmc=,size_16,color_FFFFFF,t_70)

大功告成,总结不易,请支持原创!若需引用或转载请附上本文地址;
