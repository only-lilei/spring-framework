### 1.开启注解配置

><?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
 
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                        http://www.springframework.org/schema/beans/spring-beans-3.1.xsd
                        http://www.springframework.org/schema/context
                        http://www.springframework.org/schema/context/spring-context-3.1.xsd">
    <!-- component-scan包含了annotation-config的效果 -->
    <context:component-scan base-package="com.joonwhee.open.demo.service"/>
    <context:annotation-config/>
    </beans>

要使用 @Autowire 注解，可以通过 <context:component-scan /> 或 <context:annotation-config/> 来开启，其中前者是包含了后者的效果的，因此现在一般都使用 <context:component-scan /> 即可。

### 2.在代码中使用
<pre>
@Service
public class ConstructorServiceImpl implements ConstructorService {
 
    // 1.属性注入
    @Autowired
    private UserService userService;
 
    private final DemoService demoService;
 
    // 2.构造函数注入
    @Autowired
    public ConstructorServiceImpl(DemoService demoService) {
        this.demoService = demoService;
    }
}
</pre>

代码中使用了目前最常见的两种注入方式：1）属性注入；2）构造函数注入。

周围最常用的是：属性注入，但是 Spring 团队建议使用的方式是：构造函数注入，当你使用属性注入时，鼠标移到属性上的 @Autowire 就可以看到如下图的提示，并且可以通过快捷键将属性注入直接修改成构造函数注入。

构造函数的常见优点是：

1. 保证依赖不可变（final 关键字）
2. 保证依赖不为空（省去了检查）
3. 以完全初始化的状态返回到客户端（调用）代码
4. 避免了循环依赖
5. 提升了代码的可复用性

构造函数的常见缺点是：

1. 构造函数会有很多参数。
2. 有些类是需要默认构造函数的，一旦使用构造函数注入，就无法使用默认构造函数。
3. 这个类里面的有些方法并不需要用到这些依赖。

### 继承结构
@Autowire 注解的功能实现都是由 AutowiredAnnotationBeanPostProcessor 实现

### 源码解析(请看此类)
>AutowiredAnnotationBeanPostProcessor
>AutowiredAnnotationBeanPostProcessor#determineCandidateConstructors


### 属性注入
AutowiredAnnotationBeanPostProcessor 中跟属性注入有关的方法出口有两个：postProcessMergedBeanDefinition 和 postProcessPropertyValues

#### 1. postProcessMergedBeanDefinition 方法介绍
postProcessMergedBeanDefinition 被定义在 MergedBeanDefinitionPostProcessor 接口中，该方法的主要作用是：对指定 bean 的给定 MergedBeanDefinition 进行后置处理。

在 AutowiredAnnotationBeanPostProcessor 的实现中，主要是对使用了 @Autowire 注解的方法和属性进行预解析，并放到 injectionMetadataCache 缓存中，用于后续使用。

在 Spring IoC 的过程中，调用的入口在：
> org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyMergedBeanDefinitionPostProcessors



