package thinking.in.spring.bean.definition;

import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import thinking.in.spring.bean.factory.DefaultUserFactory;
import thinking.in.spring.bean.factory.UserFactory;

/**
 * 单体 Bean 注册实例
 */
public class SingletonBeanRegistrationDemo {

    public static void main(String[] args) {
        //1 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        SingletonBeanRegistry singletonBeanRegistry = applicationContext.getBeanFactory();
        UserFactory userFactory = new DefaultUserFactory();
        singletonBeanRegistry.registerSingleton("userFactory" , userFactory);
        // 启动spring 应用上下文
        applicationContext.refresh();

        // 通过依赖查找的方式来获取 UserFactory
        UserFactory userFactoryByLookup = applicationContext.getBean("userFactory", UserFactory.class);
        System.out.println("userFactory  == userFactoryByLookup : " + (userFactory == userFactoryByLookup));

        // 关闭 Spring 应用上下文
        applicationContext.close();
    }
}
