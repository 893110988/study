package wmm.javaframe.study.designmodule.proxy.mydynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/8/24.
 */
public class GoHomeProxy implements InvocationHandler{

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if( proxy instanceof GoHomeInterface && method.getName().equals("goHome"))
            return "哈哈哈哈哈哈哈哈哈哈哈哈啊哈哈哈";

        return method.invoke(GoHome.class.newInstance(),args);
    }
}
