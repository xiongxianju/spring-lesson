package thinking.in.spring.ioc.overview.repository;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import thinking.in.spring.ioc.overview.domain.User;

import javax.jws.soap.SOAPBinding;
import java.util.Collection;

public class UserRepository {

    private Collection<User> users;  // 自定义bean

    private BeanFactory beanFactory;  //  内建非  bean  对象 （依赖）

   // private ObjectFactory<User> objectFactory;  //  内建非  bean  对象 （依赖）

    private ObjectFactory<ApplicationContext> objectFactory;  //  内建非  bean  对象 （依赖）

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public ObjectFactory<ApplicationContext> getObjectFactory() {
        return objectFactory;
    }

    public void setObjectFactory(ObjectFactory<ApplicationContext> objectFactory) {
        this.objectFactory = objectFactory;
    }
}
