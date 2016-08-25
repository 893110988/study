package wmm.javaframe.study.designmodule.proxy.mydynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/8/24.
 */
public class GoHomeProxy implements InvocationHandler{
    private Object target;
    public GoHomeProxy(Object target) {
        this.target=target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //System.out.println("asdffffffff");
        if( target.getClass().isAssignableFrom(GoHome.class))
            return "哈哈哈哈哈哈哈哈哈哈哈哈啊哈哈哈";
       // System.out.println("asdffffffff");
        return method.invoke(target,args);
    }
}
