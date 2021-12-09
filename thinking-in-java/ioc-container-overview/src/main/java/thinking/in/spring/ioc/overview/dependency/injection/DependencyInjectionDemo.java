package thinking.in.spring.ioc.overview.dependency.injection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import thinking.in.spring.ioc.overview.repository.UserRepository;

/**
 * 依赖注入
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // xml 配置文件
     //   BeanFactory beanFactory= new ClassPathXmlApplicationContext("classpath:/META_INF/dependency-injection-content.xml");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-injection-context.xml");


        // 依赖来源一：自定义 Bean
        UserRepository userRepository = applicationContext.getBean("userRepository", UserRepository.class);
     //   System.out.println(userRepository.getUsers());

        //
    /*    System.out.println(userRepository.getBeanFactory());
        System.out.println(beanFactory);*/
        //依赖查找  依赖来源2 beanFactory 是内建依赖  不是业务方
      //  System.out.println(beanFactory.getBean(BeanFactory.class));
      //  System.out.println(userRepository.getBeanFactory() == beanFactory);

   //     ObjectFactory userFactory = userRepository.getObjectFactory();
        // 
     //   System.out.println(userFactory.getObject() == beanFactory);
        //依赖来源 3   内建bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("内建bean  "+environment);

        whoIsIocContains(userRepository , applicationContext);
    }

    private static void whoIsIocContains(UserRepository userRepository , ApplicationContext applicationContext) {

        // ConfigurableApplicationContext <- ApplicationContext <- BeanFactory

        // ConfigurableApplicationContext#getBeanFactory()


        // 这个表达式为什么不会成立
        System.out.println(userRepository.getBeanFactory() == applicationContext);

        // ApplicationContext is BeanFactory
    }

}
