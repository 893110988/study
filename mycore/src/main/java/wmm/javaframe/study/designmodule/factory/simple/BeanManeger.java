package wmm.javaframe.study.designmodule.factory.simple;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Administrator on 2016/8/25.
 */
public class BeanManeger {
    private BeanManeger(){

    }

    public static Object getBeanManager(String className){
        return BeanManagerExecute.beanMap.get(className);
    }

    private static class BeanManagerExecute{
        private static Map<String,Object> beanMap =new HashMap<String, Object>();
        private static BeanManeger beanManeger =new BeanManeger();
        static {
            beanMap.put("apple1",new Apple1());
            beanMap.put("apple2",new Apple2());

        }
    }
}
