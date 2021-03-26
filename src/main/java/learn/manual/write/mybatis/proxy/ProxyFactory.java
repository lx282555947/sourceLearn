package learn.manual.write.mybatis.proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    public Object getProxyInstance(Class<?> mapperInterface, ProxyHandler handler) {
        //绑定该类实现的所有接口，取得代理类
        return Proxy.newProxyInstance(mapperInterface.getClassLoader(),
                new Class[]{mapperInterface},
                handler);
    }
}
