package thinking.in.spring.ioc.overview.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import thinking.in.spring.ioc.overview.annotation.Super;
import thinking.in.spring.ioc.overview.domain.SuperUser;
import thinking.in.spring.ioc.overview.domain.User;

import java.util.Map;

public class DependencyLookupDemo {


    public static void main(String[] args) {
        // xml 配置文件
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META_INF/dependency-lookup-content.xml");

      //  根据名称 实时查询
        // lookupByName(beanFactory);
         //根据名称 延迟查询
        //  lookupLazyByName(beanFactory);
        //  根据类型查询
       //  lookupByType(beanFactory);
         //根据类型查询集合
      //  lookupCollectionByType(beanFactory);
        lookupByAnnotationType(beanFactory);
    }

    /**
     * 枚举类型
     * @param beanFactory
     */
    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 所有的 User 集合对象：" + users);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, SuperUser> users = listableBeanFactory.getBeansOfType(SuperUser.class);
            System.out.println("查找到的所有的 User 集合对象：" + users);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean(User.class);
        System.out.println("根据类型查询 ： " + user);
    }

    // 根据名称 延迟查询
    private static void lookupLazyByName(BeanFactory beanFactory) {
        ObjectFactory objectFactory = (ObjectFactory) beanFactory.getBean("objectFactory");
        System.out.println("根据名称 延迟查询 ： " + objectFactory.getObject());
    }

    /**
     * 根据名称 实时查询
     */
    private static void lookupByName(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("根据名称 实时查询 ： " + user);
    }


}
