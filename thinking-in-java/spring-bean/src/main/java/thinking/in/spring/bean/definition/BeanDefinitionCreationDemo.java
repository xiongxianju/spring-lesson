package thinking.in.spring.bean.definition;


import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import thinking.in.spring.ioc.overview.domain.User;

/**
 * beanDefinition 的创建
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {

        //1   BeanDefinitionBuilder 创建definition
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder.addPropertyValue("id",1);
        beanDefinitionBuilder.addPropertyValue("name","juzi");

        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();


        /**
         * 2 通过 AbstractBeanDefinition 以及派生类
         */
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue("id",1);
        mutablePropertyValues.addPropertyValue("name","juzi");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);

       // genericBeanDefinition.beande
    }
}
