package thinking.in.spring.bean.definition;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.in.spring.bean.factory.DefaultUserFactory;
import thinking.in.spring.bean.factory.UserFactory;

import java.util.Iterator;
import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

/**
 * 特殊方式 Bean 的实例化
 * 1   ServiceLoaderFactoryBean
 * 2   AutowireCapableBeanFactory
 * 3   BeanDefinitionRegistry#registerBeanDefinition(String,BeanDefinition)
 */
public class SpecialBeanInstantiationDemo {

    public static void main(String[] args) {
        // 配置 XML 配置文件
        // 启动 Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-Instantiation-context.xml");

       // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-Instantiation-context.xml");

        // 通过 ApplicationContext 获取 AutowireCapableBeanFactory
        //AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        ServiceLoader<UserFactory> serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);

         displayServiceLoader(serviceLoader);

        demoServiceLoader();

        // 创建 UserFactory 对象，通过 AutowireCapableBeanFactory
        // UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
       //  System.out.println(userFactory.createUser());

    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }
}
