package thinking.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import thinking.in.spring.bean.factory.DefaultUserFactory;
import thinking.in.spring.bean.factory.UserFactory;

/**
 * Bean 的初始化
 * 1 @PostConstruct
 * 2 实现 InitializingBean 接口的 afterPropertiesSet() 方法
 * 3 自定义 xml /@Bean 配置
 */
public class BeanInitializationDemo {

    public static void main(String[] args) {
        // 创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类   configuration class（配置类）
        applicationContext.register(BeanInitializationDemo.class);
        //启动spring 应用上下文
        applicationContext.refresh();
        System.out.println("Spring 应用上下文已启动...");
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);

        // 关闭 Spring 应用上下文
        applicationContext.close();
        System.out.println("Spring 应用上下文已关闭...");
    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "destroyUser")
    public UserFactory userFactory(){
        return new DefaultUserFactory();
    }

}
