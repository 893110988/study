package wmm.javaframe.study.annotation.handle;

import wmm.javaframe.study.annotation.ann.MyAnnotation;
import wmm.javaframe.study.annotation.model.AppleAnno;
import wmm.javaframe.study.annotation.model.UserAnno;
import wmm.javaframe.study.reflect.vistor.PrintVisitor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2016/8/17.
 */
public class MyAnnotationHandle {
    public Object getAnno(Object o){
       String name="name:";
        Field[] fields=o.getClass().getDeclaredFields();
        for(Field field:fields)
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                try {
                    String methodName="set" + firstLetterToUpper(field.getName());
                    Method method= o.getClass().getMethod(methodName, new Class[]{String.class});
                    MyAnnotation myAnno =(MyAnnotation)field.getAnnotation(MyAnnotation.class);
                    method.invoke(o, new Object[] {name+myAnno.value() });
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        return o;
    }

    public static String firstLetterToUpper(String str){
        char[] array = str.toCharArray();
        array[0] -= 32;
        return String.valueOf(array);
    }
    public static void main(String[] args) {
        MyAnnotationHandle impl=new MyAnnotationHandle();
       System.out.println(((UserAnno) impl.getAnno(new UserAnno())).getName());
       System.out.println(((AppleAnno) impl.getAnno(new AppleAnno())).getName());
    }
}
