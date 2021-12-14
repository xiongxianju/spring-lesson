package thinking.in.spring.bean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring Bean 垃圾回收机制
 */
public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        //创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册Bean
        applicationContext.register(BeanInitializationDemo.class);
        //启动 spring 应用容器上下文
        applicationContext.refresh();;

        //关闭
        applicationContext.close();

        Thread.sleep(5000L);
        // 强制触发 GC
        System.gc();

    }
}
