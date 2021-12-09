package thinking.in.spring.ioc.overview.container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import thinking.in.spring.ioc.overview.domain.SuperUser;
import thinking.in.spring.ioc.overview.domain.User;

import java.util.Map;

/**
 * beanFactory  作为ioc容器
 */
public class BeanFactoryAsIoCContainsDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory() ;
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META_INF/dependency-lookup-content.xml";
        int count = reader.loadBeanDefinitions(location);
        System.out.println("加载bean的count 的数量 : " + count);
        lookupCollectionByType(beanFactory);

    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的 User 集合对象：" + users);
        }
    }


}
