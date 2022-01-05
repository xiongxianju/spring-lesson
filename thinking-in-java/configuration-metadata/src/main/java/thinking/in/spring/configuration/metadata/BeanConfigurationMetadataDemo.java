package thinking.in.spring.configuration.metadata;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ObjectUtils;
import thinking.in.spring.ioc.overview.domain.User;

public class BeanConfigurationMetadataDemo {

    public static void main(String[] args) {

        // BeanDefinition 的定义（声明）
        BeanDefinitionBuilder definitionBuilder =  BeanDefinitionBuilder.genericBeanDefinition(User.class);
        definitionBuilder.addPropertyValue("name", "juzi");
        // 获取beanDefinition
        BeanDefinition beanDefinition = definitionBuilder.getBeanDefinition();
        // 附加属性（不影响 Bean populate、initialize）
        beanDefinition.setAttribute("name","桔子");

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

                if(ObjectUtils.nullSafeEquals("user", beanName) &&User.class.equals(bean.getClass())){
                    BeanDefinition definition =  beanFactory.getBeanDefinition(beanName);
                    String name = (String) definition.getAttribute("name");
                    System.out.println("postProcessAfterInitialization "  + name);
                    ((User) bean).setName(name);
                }
                return bean;
            }
        });

        // 注册 User 的 BeanDefinition
        beanFactory.registerBeanDefinition("user", beanDefinition);

        User user = beanFactory.getBean("user", User.class);

        System.out.println(user);
    }
}
