package wmm.javaframe.study.designmodule.factory.simple;

/**
 * Created by Administrator on 2016/8/25.
 */
public class AppleFactory {

    private AppleFactory(){
    }

    public static AppleInterface getApple(String name){

            try {
                String className=BeanManeger.getBeanManager(name).getClass().getName();
               Object o= ClassLoader.getSystemClassLoader().loadClass(className).newInstance();
                return (AppleInterface) o;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        return null;

    }
}
