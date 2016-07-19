# dubbo-zookeeper
注意：有两个repository，dubboConsumer(服务消费者)和dubboProvider(服务提供者)  

这是一个整合了dubbo、zookeeper、SpringMVC、Spring、Mybatis的用于dubbo学习入门的小Demo，为了更快学习，我从网上找来了这个小工程，
东西还是比较简单的。网上搜了很多文章要么没代码，要么有代码但缺乏足够的说明，本示例绝对能让从没接触过dubbo的人很快入门。我也是
刚入门，哈哈！

产生背景：  
(1)当服务越来越多时，服务URL配置管理变得非常困难，F5硬件负载均衡器的单点压力也越来越大。此时需要一个服务注册中心，动态的注册和发现服务，使服务的位置透明。并通过在消费方获取服务提供方地址列表，实现软负载均衡和Failover，降低对F5硬件负载均衡器的依赖，也能减少部分成本。  
(2)当进一步发展，服务间依赖关系变得错踪复杂，甚至分不清哪个应用要在哪个应用之前启动，架构师都不能完整的描述应用的架构关系。这时，需要自动画出应用间的依赖关系图，以帮助架构师理清理关系。  
(3)接着，服务的调用量越来越大，服务的容量问题就暴露出来，这个服务需要多少机器支撑？什么时候该加机器？等等…  

dubbo能做什么：  
透明化的远程方法调用，就像调用本地方法一样调用远程方法，只需简单配置，没有任何API侵入。  
软负载均衡及容错机制，可在内网替代F5等硬件负载均衡器，降低成本，减少单点。  
服务自动注册与发现，不再需要写死服务提供方地址，注册中心基于接口名查询服务提供者的IP地址，并且能够平滑添加或删除服务提供者。  
dubbo此示例里采用的是用zookeeper作为注册中心  

关于dubbo、zookeeper使用的渊源及说明详情请看[dubbo-zookeeper应用](http://www.fwqtg.net/置顶-java集群优化-dubbozookeeper构建高可用分布式集群.html)、[dubbo实战](http://blog.csdn.net/hejingyuan6/article/details/47405377)。很详细了。  

示例中，服务提供方是Spring、Mybatis结合的工程，在Spring配置文件中有如下配置项：  
```java
<!-- 具体的实现bean -->
	<bean id="userService" class="com.cn.userserviceimpl.UserServiceImpl" />
	
	<!-- 提供方应用信息，用于计算依赖关系 -->
	<dubbo:application name="jack_provider" />
	
	<!-- 使用multicast广播注册中心暴露服务地址-->
	<!-- <dubbo:registry address="multicast://127.0.0.1:1234" />  -->
	
	<!-- 使用zookeeper注册中心暴露服务地址 -->
	<dubbo:registry address="zookeeper://127.0.0.1:2181" />
	
	<!-- 用dubbo协议在20880端口暴露服务 -->
	<dubbo:protocol name="dubbo" port="20880" />
	
	<!-- 声明需要暴露的服务接口 -->
	<dubbo:service interface="com.cn.userservice.UserService"
		ref="userService" />
```
服务提供方工程启动后会向zookeeper注册UserService服务  
![image](https://github.com/JercyChen/PhotoRef/blob/master/UserService-dubboProvider.png)
同时可以在dubbo-admin上看到提供方有纪录了  
![image](https://github.com/JercyChen/PhotoRef/blob/master/Provider.png)

服务消费方是SpringMVC，搭建了一个在前台点击按钮查询用户之类的工程，工程只有对应service的接口,并没有实现，通过Spring配置引用远程服务。
主要配置如下：  
```java
<!-- 消费方应用名，用于计算依赖关系，不是匹配条件，不要与提供方一样 -->
	<dubbo:application name="jack_consumer" />
	<!-- 使用multicast广播注册中心暴露发现服务地址 -->
	<dubbo:registry protocol="zookeeper" address="zookeeper://127.0.0.1:2181" />
	<!-- 生成远程服务代理，可以和本地bean一样使用Service -->
	<dubbo:reference id="userService" interface="com.cn.userservice.UserService" />
```

启动该应用，dubbo-admin的消费者tab页不会马上出现一条消费者纪录直到点击页面上需要远程调用的服务时才有纪录  
![image](https://github.com/JercyChen/PhotoRef/blob/master/consumer.png)
点击登录，输入test/test，返回  
![image](https://github.com/JercyChen/PhotoRef/blob/master/loginSuccess.png)
### dubboConsumer调用远程服务成功！  





