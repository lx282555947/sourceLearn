package learn.manual.write.mybatis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 1、每一个Mapper对应一个代理类
 * 2、每个代理类交由springboot 容器进行管理
 */
public class ProxyHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //根据method名称找到对应的执行语句

        return null;
    }
}
