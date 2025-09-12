package spring.mybatis;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author Yves
 * @Data 2023/4/17 下午3:17
 */
public class SelfFactoryBean implements FactoryBean {

    private Class mapperInterface;

    public SelfFactoryBean(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Object getObject() throws Exception {
        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{mapperInterface}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        return o;
    }

    public Class<?> getObjectType() {
        return mapperInterface;
    }

    public boolean isSingleton() {
        return true;
    }
}
