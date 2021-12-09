package thinking.in.spring.ioc.overview.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import thinking.in.spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * 注解能力 {@link ApplicationContext} 作为 IoC 容器示例
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @since
 */
public class AnnotationApplicationContextAsIoCContainsDemo {
    public static void main(String[] args) {
        //创建 BeanFactory
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将当前类 AnnotationApplicationContextAsIoCContainerDemo 作为配置类（Configuration Class）
        applicationContext.register(AnnotationApplicationContextAsIoCContainsDemo.class);
        // 启动应用上下文
        applicationContext.refresh();
        lookupCollectionByType(applicationContext);
        applicationContext.close();
    }

    @Bean
    private User user(){
        User user = new User();
        user.setId(1L);
        user.setName("juzi1");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + users);
        }
    }
}
