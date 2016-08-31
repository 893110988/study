package wmm.javaframe.study.designmodule.strategy.factoryandstrategy;

import wmm.javaframe.study.designmodule.strategy.call.BaseCall;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.SortedMap;

/**
 * Created by Administrator on 2016/8/31.
 */
public class CalPriceProxy implements InvocationHandler {

    private SortedMap<Integer, Class<? extends BaseCall>> clazzMap;

    private CalPriceProxy(SortedMap<Integer, Class<? extends BaseCall>> clazzMap) {
        super();
        this.clazzMap = clazzMap;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        Double result = 0D;
        if (method.getName().equals("callPrice")) {
            for (Class<? extends BaseCall> clazz : clazzMap.values()) {
                if (result == 0) {
                    result = (Double) method.invoke(clazz.newInstance(), args);
                }else {
                    result = (Double) method.invoke(clazz.newInstance(), result);
                }
            }
            return result;
        }
        return null;
    }

    public static BaseCall getProxy(SortedMap<Integer, Class<? extends BaseCall>> clazzMap){
        return (BaseCall) Proxy.newProxyInstance(CalPriceProxy .class.getClassLoader(), new Class<?>[]{BaseCall.class}, new CalPriceProxy (clazzMap));
    }

}
