# MyBatis-Ignite-L2-cache-POC
Simple POC to verify MyBatis Ignite L2 cache Integration @ http://www.mybatis.org/ignite-cache/

I am using Postgresql 9.6 for the DB (schema is available under resources folder of domain project).

The server project is a spring boot application that can be run with the below command line,

java -Dserver.port=8888 -Ddb.host=10.30.3.24 -Ddb.port=5432 -Ddb.name=postgres -DIGNITE_QUIET=false -jar target\server-ignite-l2cache-poc-0.0.1-SNAPSHOT.jar

Below is the command line output i see,

C:\Users\Administrator\Documents\Work\server>java -Dserver.port=8888 -Ddb.host=10.30.3.24 -Ddb.port=5432 -Ddb.name=postgres -DIGNITE_QUIET=false -jar target\server-ignite-l2cache-poc-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.2.RELEASE)

2017-05-24 19:51:45.033  INFO 10168 --- [           main] c.b.dcm.server.ObjectCacheApplication    : Starting ObjectCacheApplication v0.0.1-SNAPSHOT on VM-W2K8-50-168 with PID 10168 (C:\Users\Administrator\Documents\Work\server\target
\server-ignite-l2cache-poc-0.0.1-SNAPSHOT.jar started by Administrator in C:\Users\Administrator\Documents\Work\server)
2017-05-24 19:51:45.043  INFO 10168 --- [           main] c.b.dcm.server.ObjectCacheApplication    : No active profile set, falling back to default profiles: default
2017-05-24 19:51:45.235  INFO 10168 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@5387f9e0: startup date [Wed May 24
 19:51:45 PDT 2017]; root of context hierarchy
2017-05-24 19:51:47.007  INFO 10168 --- [           main] o.s.b.f.xml.XmlBeanDefinitionReader      : Loading XML bean definitions from class path resource [applicationContext.xml]
2017-05-24 19:51:47.734  INFO 10168 --- [           main] o.s.b.f.s.DefaultListableBeanFactory     : Overriding bean definition for bean 'org.springframework.transaction.config.internalTransactionAdvisor' with a different definition:
replacing [Root bean: class [org.springframework.transaction.interceptor.BeanFactoryTransactionAttributeSourceAdvisor]; scope=; abstract=false; lazyInit=false; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false;
factoryBeanName=null; factoryMethodName=null; initMethodName=null; destroyMethodName=null] with [Root bean: class [null]; scope=; abstract=false; lazyInit=false; autowireMode=3; dependencyCheck=0; autowireCandidate=true; primary=false
; factoryBeanName=org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration; factoryMethodName=transactionAdvisor; initMethodName=null; destroyMethodName=(inferred); defined in class path resource [org/springf
ramework/transaction/annotation/ProxyTransactionManagementConfiguration.class]]
2017-05-24 19:51:47.734  INFO 10168 --- [           main] a.ConfigurationClassBeanDefinitionReader : Skipping bean definition for [BeanMethod:name=transactionalEventListenerFactory,declaringClass=org.springframework.transaction.annota
tion.AbstractTransactionManagementConfiguration]: a definition for bean 'org.springframework.transaction.config.internalTransactionalEventListenerFactory' already exists. This top-level bean definition is considered as an override.
2017-05-24 19:51:48.309  INFO 10168 --- [           main] f.a.AutowiredAnnotationBeanPostProcessor : JSR-330 'javax.inject.Inject' annotation found and supported for autowiring
2017-05-24 19:51:48.828  INFO 10168 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.an
notation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$b75b9f36] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2017-05-24 19:51:49.754  INFO 10168 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8888 (http)
2017-05-24 19:51:49.797  INFO 10168 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
2017-05-24 19:51:49.802  INFO 10168 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.11
2017-05-24 19:51:50.034  INFO 10168 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2017-05-24 19:51:50.036  INFO 10168 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 4805 ms
2017-05-24 19:51:50.371  INFO 10168 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
2017-05-24 19:51:50.381  INFO 10168 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2017-05-24 19:51:50.383  INFO 10168 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2017-05-24 19:51:50.384  INFO 10168 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2017-05-24 19:51:50.385  INFO 10168 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2017-05-24 19:51:51.538  INFO 10168 --- [           main] o.s.b.f.xml.XmlBeanDefinitionReader      : Loading XML bean definitions from URL [file:/C:/Users/Administrator/Documents/apache-ignite-fabric-2.0.0-bin/config/default-config.xm
l]
2017-05-24 19:51:51.572  INFO 10168 --- [           main] o.s.c.support.GenericApplicationContext  : Refreshing org.springframework.context.support.GenericApplicationContext@64485a47: startup date [Wed May 24 19:51:51 PDT 2017]; root
of context hierarchy
Can't load log handler "org.apache.ignite.logger.java.JavaLoggerFileHandler"
java.lang.ClassNotFoundException: org.apache.ignite.logger.java.JavaLoggerFileHandler
java.lang.ClassNotFoundException: org.apache.ignite.logger.java.JavaLoggerFileHandler
        at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:335)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
        at java.util.logging.LogManager$5.run(LogManager.java:965)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.util.logging.LogManager.loadLoggerHandlers(LogManager.java:958)
        at java.util.logging.LogManager.initializeGlobalHandlers(LogManager.java:1578)
        at java.util.logging.LogManager.access$1500(LogManager.java:145)
        at java.util.logging.LogManager$RootLogger.accessCheckedHandlers(LogManager.java:1667)
        at java.util.logging.Logger.getHandlers(Logger.java:1777)
        at org.apache.ignite.logger.java.JavaLogger.findHandler(JavaLogger.java:399)
        at org.apache.ignite.logger.java.JavaLogger.configure(JavaLogger.java:229)
        at org.apache.ignite.logger.java.JavaLogger.<init>(JavaLogger.java:170)
        at org.apache.ignite.logger.java.JavaLogger.<init>(JavaLogger.java:126)
        at org.apache.ignite.internal.IgnitionEx$IgniteNamedInstance.initLogger(IgnitionEx.java:2366)
        at org.apache.ignite.internal.IgnitionEx$IgniteNamedInstance.initializeConfiguration(IgnitionEx.java:2044)
        at org.apache.ignite.internal.IgnitionEx$IgniteNamedInstance.start0(IgnitionEx.java:1673)
        at org.apache.ignite.internal.IgnitionEx$IgniteNamedInstance.start(IgnitionEx.java:1647)
        at org.apache.ignite.internal.IgnitionEx.start0(IgnitionEx.java:1075)
        at org.apache.ignite.internal.IgnitionEx.startConfigurations(IgnitionEx.java:993)
        at org.apache.ignite.internal.IgnitionEx.start(IgnitionEx.java:879)
        at org.apache.ignite.internal.IgnitionEx.start(IgnitionEx.java:778)
        at org.apache.ignite.internal.IgnitionEx.start(IgnitionEx.java:501)
        at org.apache.ignite.internal.IgnitionEx.start(IgnitionEx.java:481)
        at org.apache.ignite.Ignition.start(Ignition.java:304)
        at org.mybatis.caches.ignite.IgniteCacheAdapter.<clinit>(IgniteCacheAdapter.java:68)
        at java.lang.Class.forName0(Native Method)
        at java.lang.Class.forName(Class.java:348)
        at org.apache.ibatis.io.ClassLoaderWrapper.classForName(ClassLoaderWrapper.java:186)
        at org.apache.ibatis.io.ClassLoaderWrapper.classForName(ClassLoaderWrapper.java:89)
        at org.apache.ibatis.io.Resources.classForName(Resources.java:261)
        at org.apache.ibatis.type.TypeAliasRegistry.resolveAlias(TypeAliasRegistry.java:116)
        at org.apache.ibatis.builder.xml.XMLMapperBuilder.cacheElement(XMLMapperBuilder.java:202)
        at org.apache.ibatis.builder.xml.XMLMapperBuilder.configurationElement(XMLMapperBuilder.java:114)
        at org.apache.ibatis.builder.xml.XMLMapperBuilder.parse(XMLMapperBuilder.java:92)
        at org.mybatis.spring.SqlSessionFactoryBean.buildSqlSessionFactory(SqlSessionFactoryBean.java:521)
        at org.mybatis.spring.SqlSessionFactoryBean.afterPropertiesSet(SqlSessionFactoryBean.java:380)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1687)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1624)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:555)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
        at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
        at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:208)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1138)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1066)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireByType(AbstractAutowireCapableBeanFactory.java:1342)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1249)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:553)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
        at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
        at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:208)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1138)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1066)
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:585)
        at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88)
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:366)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1264)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:553)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
        at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
        at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:208)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1138)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1066)
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:585)
        at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88)
        at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:366)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1264)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:553)
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:483)
        at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197)
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:761)
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:866)
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:542)
        at org.springframework.boot.context.embedded.EmbeddedWebApplicationContext.refresh(EmbeddedWebApplicationContext.java:122)
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:737)
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:370)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:314)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1162)
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1151)
        at com.brocade.dcm.server.ObjectCacheApplication.main(ObjectCacheApplication.java:14)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:48)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:87)
        at org.springframework.boot.loader.Launcher.launch(Launcher.java:50)
        at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:51)
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO:

>>>    __________  ________________
>>>   /  _/ ___/ |/ /  _/_  __/ __/
>>>  _/ // (7 7    // /  / / / _/
>>> /___/\___/_/|_/___/ /_/ /___/
>>>
>>> ver. 2.0.0#20170430-sha1:d4eef3c6
>>> 2017 Copyright(C) Apache Software Foundation
>>>
>>> Ignite documentation: http://ignite.apache.org

May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Config URL: file:/C:/Users/Administrator/Documents/apache-ignite-fabric-2.0.0-bin/config/default-config.xml
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Daemon mode: off
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: OS: Windows Server 2008 R2 6.1 amd64
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: OS user: Administrator
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: PID: 10168
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Language runtime: Java Platform API Specification ver. 1.8
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: VM information: Java(TM) SE Runtime Environment 1.8.0_131-b11 Oracle Corporation Java HotSpot(TM) 64-Bit Server VM 25.131-b11
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: VM total memory: 3.6GB
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Remote Management [restart: off, REST: on, JMX (remote: off)]
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: IGNITE_HOME=C:\Users\Administrator\Documents\apache-ignite-fabric-2.0.0-bin\
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: VM arguments: [-Dserver.port=8888, -Ddb.host=10.30.3.24, -Ddb.port=5432, -Ddb.name=postgres, -DIGNITE_QUIET=false]
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: System cache's MemoryPolicy size is configured to 40 MB. Use MemoryConfiguration.systemCacheMemorySize property to change the setting.
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Configured caches [in 'default' memoryPolicy: ['ignite-sys-cache', 'ignite-atomics-sys-cache', 'myBatisObjectCache2']]
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger warning
WARNING: Peer class loading is enabled (disable it in production for performance and deployment consistency reasons)
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: 3-rd party licenses can be found at: C:\Users\Administrator\Documents\apache-ignite-fabric-2.0.0-bin\\libs\licenses
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger warning
WARNING: Initial heap size is 256MB (should be no less than 512MB, use -Xms512m -Xmx512m).
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger warning
WARNING: This operating system has been tested less rigorously: Windows Server 2008 R2 6.1 amd64. Our team will appreciate the feedback if you experience any problems running ignite in this environment.
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Configured plugins:
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO:   ^-- None
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO:
May 24, 2017 7:51:52 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Successfully bound communication NIO server to TCP port [port=47102, locHost=0.0.0.0/0.0.0.0, selectorsCnt=4, selectorSpins=0, pairedConn=false]
May 24, 2017 7:51:53 PM org.apache.ignite.logger.java.JavaLogger warning
WARNING: Message queue limit is set to 0 which may lead to potential OOMEs when running cache operations in FULL_ASYNC or PRIMARY_SYNC modes due to message queues growth on sender and receiver sides.
May 24, 2017 7:51:53 PM org.apache.ignite.logger.java.JavaLogger warning
WARNING: Checkpoints are disabled (to enable configure any GridCheckpointSpi implementation)
May 24, 2017 7:51:53 PM org.apache.ignite.logger.java.JavaLogger warning
WARNING: Collision resolution is disabled (all jobs will be activated upon arrival).
May 24, 2017 7:51:53 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Security status [authentication=off, tls/ssl=off]
May 24, 2017 7:51:53 PM org.apache.ignite.logger.java.JavaLogger warning
WARNING: No user-defined default MemoryPolicy found; system default of 1GB size will be used.
May 24, 2017 7:51:54 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Command protocol successfully started [name=TCP binary, host=0.0.0.0/0.0.0.0, port=11212]
May 24, 2017 7:51:54 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Non-loopback local IPs: 10.24.50.168, 192.168.56.1, 2620:100:0:fe07:2c72:f331:9245:123d, fe80:0:0:0:0:5efe:a18:32a8%net4, fe80:0:0:0:0:5efe:c0a8:3801%net5, fe80:0:0:0:2c72:f331:9245:123d%eth3, fe80:0:0:0:697d:f11d:92cb:4697%eth4

May 24, 2017 7:51:54 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Enabled local MACs: 00000000000000E0, 00505687525E, 0A002700000D
May 24, 2017 7:51:54 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Successfully bound to TCP port [port=47502, localHost=0.0.0.0/0.0.0.0, locNodeId=5d2e7f27-47aa-4900-b166-d72da017dc8a]
May 24, 2017 7:51:57 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Started cache [name=ignite-sys-cache, memoryPolicyName=sysMemPlc, mode=REPLICATED]
May 24, 2017 7:51:57 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Started cache [name=ignite-atomics-sys-cache, memoryPolicyName=sysMemPlc, mode=PARTITIONED]
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Started cache [name=myBatisObjectCache2, memoryPolicyName=null, mode=PARTITIONED]
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Established outgoing communication connection [locAddr=/0:0:0:0:0:0:0:1:57947, rmtAddr=/0:0:0:0:0:0:0:1:47100]
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Rebalancing scheduled [order=[ignite-sys-cache, ignite-atomics-sys-cache, myBatisObjectCache2]]
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Rebalancing started [top=AffinityTopologyVersion [topVer=87, minorTopVer=0], evt=NODE_JOINED, node=5d2e7f27-47aa-4900-b166-d72da017dc8a]
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: <ignite-sys-cache> Starting rebalancing [mode=SYNC, fromNode=a043bde1-0fb5-464a-a661-dcb9d850de2c, partitionsCount=100, topology=AffinityTopologyVersion [topVer=87, minorTopVer=0], updateSeq=1]
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: <ignite-sys-cache> Completed (final) rebalancing [fromNode=a043bde1-0fb5-464a-a661-dcb9d850de2c, topology=AffinityTopologyVersion [topVer=87, minorTopVer=0], time=14 ms]
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: <ignite-atomics-sys-cache> Starting rebalancing [mode=SYNC, fromNode=a043bde1-0fb5-464a-a661-dcb9d850de2c, partitionsCount=534, topology=AffinityTopologyVersion [topVer=87, minorTopVer=0], updateSeq=1]
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: <ignite-atomics-sys-cache> Completed (final) rebalancing [fromNode=a043bde1-0fb5-464a-a661-dcb9d850de2c, topology=AffinityTopologyVersion [topVer=87, minorTopVer=0], time=52 ms]
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: <myBatisObjectCache2> Starting rebalancing [mode=ASYNC, fromNode=a043bde1-0fb5-464a-a661-dcb9d850de2c, partitionsCount=534, topology=AffinityTopologyVersion [topVer=87, minorTopVer=0], updateSeq=1]
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: <myBatisObjectCache2> Completed (final) rebalancing [fromNode=a043bde1-0fb5-464a-a661-dcb9d850de2c, topology=AffinityTopologyVersion [topVer=87, minorTopVer=0], time=38 ms]
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Performance suggestions for grid 'myBatisObjectGrid' (fix if possible)
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: To disable, set -DIGNITE_PERFORMANCE_SUGGESTIONS_DISABLED=true
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO:   ^-- Enable G1 Garbage Collector (add '-XX:+UseG1GC' to JVM options)
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO:   ^-- Specify JVM heap max size (add '-Xmx<size>[g|G|m|M|k|K]' to JVM options)
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO:   ^-- Set max direct memory size if getting 'OOME: Direct buffer memory' (add '-XX:MaxDirectMemorySize=<size>[g|G|m|M|k|K]' to JVM options)
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO:   ^-- Disable processing of calls to System.gc() (add '-XX:+DisableExplicitGC' to JVM options)
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Refer to this page for more performance suggestions: https://apacheignite.readme.io/docs/jvm-and-system-tuning
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO:
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: To start Console Management & Monitoring run ignitevisorcmd.{sh|bat}
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO:
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO:

>>> +----------------------------------------------------------------------+
>>> Ignite ver. 2.0.0#20170430-sha1:d4eef3c68ff116ee34bc13648cd82c640b3ea072
>>> +----------------------------------------------------------------------+
>>> OS name: Windows Server 2008 R2 6.1 amd64
>>> CPU(s): 4
>>> Heap: 3.6GB
>>> VM name: 10168@VM-W2K8-50-168
>>> Ignite instance name: myBatisObjectGrid
>>> Local node [ID=5D2E7F27-47AA-4900-B166-D72DA017DC8A, order=87, clientMode=false]
>>> Local node addresses: [VM-W2K8-50-168.englab.brocade.com/0:0:0:0:0:0:0:1, VM-W2K8-50-168.englab.brocade.com/10.24.50.168, VM-W2K8-50-168.englab.brocade.com/127.0.0.1, /192.168.56.1, /2620:100:0:fe07:2c72:f331:9245:123d]
>>> Local ports: TCP:11212 TCP:47102 UDP:47400 TCP:47502

May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Topology snapshot [ver=87, servers=2, clients=0, CPUs=4, heap=4.6GB]
2017-05-24 19:51:58.731  INFO 10168 --- [           main] o.s.b.f.xml.XmlBeanDefinitionReader      : Loading XML bean definitions from file [C:\Users\Administrator\Documents\Work\server\config\default-config.xml]
2017-05-24 19:51:58.732  WARN 10168 --- [           main] o.m.caches.ignite.IgniteCacheAdapter     : Initializing the default cache. Consider properly configuring 'config/default-config.xml' instead.
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Started cache [name=com.brocade.dcm.domain.mapper.PostsMapper, memoryPolicyName=null, mode=PARTITIONED]
May 24, 2017 7:51:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Skipping rebalancing (nothing scheduled) [top=AffinityTopologyVersion [topVer=87, minorTopVer=1], evt=DISCOVERY_CUSTOM_EVT, node=5d2e7f27-47aa-4900-b166-d72da017dc8a]
2017-05-24 19:51:59.705  INFO 10168 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@5387f9e0: star
tup date [Wed May 24 19:51:45 PDT 2017]; root of context hierarchy
2017-05-24 19:51:59.958  INFO 10168 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/dcm/posts],methods=[GET]}" onto public org.springframework.http.ResponseEntity<java.util.List<com.brocade.dcm.domain.model
.Posts>> com.brocade.dcm.server.controller.ObjectCacheServiceController.getPostById(java.lang.String,java.lang.String)
2017-05-24 19:51:59.974  INFO 10168 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.spring
framework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2017-05-24 19:51:59.974  INFO 10168 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfig
ure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2017-05-24 19:52:00.127  INFO 10168 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-05-24 19:52:00.344  INFO 10168 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-05-24 19:52:00.596  INFO 10168 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
May 24, 2017 7:52:00 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Skipping rebalancing (nothing scheduled) [top=AffinityTopologyVersion [topVer=87, minorTopVer=2], evt=DISCOVERY_CUSTOM_EVT, node=a043bde1-0fb5-464a-a661-dcb9d850de2c]
2017-05-24 19:52:01.174  INFO 10168 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-05-24 19:52:01.177  INFO 10168 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Bean with name 'dataSource' has been autodetected for JMX exposure
2017-05-24 19:52:01.192  INFO 10168 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Located MBean 'dataSource': registering with JMX server as MBean [org.apache.commons.dbcp2:name=dataSource,type=BasicDataSource]
May 24, 2017 7:52:01 PM org.apache.coyote.AbstractProtocol init
INFO: Initializing ProtocolHandler ["http-nio-8888"]
May 24, 2017 7:52:01 PM org.apache.coyote.AbstractProtocol start
INFO: Starting ProtocolHandler [http-nio-8888]
May 24, 2017 7:52:01 PM org.apache.tomcat.util.net.NioSelectorPool getSharedSelector
INFO: Using a shared selector for servlet write/read
2017-05-24 19:52:01.335  INFO 10168 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8888 (http)
2017-05-24 19:52:01.335  INFO 10168 --- [           main] c.b.dcm.server.ObjectCacheApplication    : Started ObjectCacheApplication in 17.309 seconds (JVM running for 18.459)
May 24, 2017 7:52:07 PM org.apache.ignite.logger.java.JavaLogger info
INFO: Your version is up to date.
May 24, 2017 7:52:58 PM org.apache.ignite.logger.java.JavaLogger info
INFO:
Metrics for local node (to disable set 'metricsLogFrequency' to 0)
    ^-- Node [id=5d2e7f27, name=myBatisObjectGrid, uptime=00:01:00:005]
    ^-- H/N/C [hosts=1, nodes=2, CPUs=4]
    ^-- CPU [cur=0.13%, avg=6.74%, GC=0%]
    ^-- PageMemory [pages=3408]
    ^-- Heap [used=174MB, free=95.22%, comm=452MB]
    ^-- Non heap [used=78MB, free=-1%, comm=80MB]
    ^-- Public thread pool [active=0, idle=0, qSize=0]
    ^-- System thread pool [active=0, idle=8, qSize=0]
    ^-- Outbound messages queue [size=0]
