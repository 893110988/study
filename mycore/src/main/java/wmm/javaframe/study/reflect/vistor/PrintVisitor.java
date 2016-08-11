package wmm.javaframe.study.reflect.vistor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 详细：反射和观察者模式两种用法
 * Created by Administrator on 2016/8/10.
 */

public class PrintVisitor implements Visitor {
    public void visitCollection(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
           // visit(o);
            if (o instanceof Visitable)
                ((Visitable) o).todo(this);
        }
    }

    public void visitString(String string) {
        System.out.println("'"+string+"'");
    }
    public void visitFloat(Float float1) {
        System.out.println(float1.toString()+"f");
    }
    public void visitDefault(Object o){
        System.out.println(o.toString());
    }
    public void visit(Object o) {
        String methodName = o.getClass().getName();
        methodName = "visit"+
                methodName.substring(methodName.lastIndexOf('.')+1);
        try {
            Method m = getClass().getMethod(methodName,
                    new Class[] { o.getClass() });
            m.invoke(this, new Object[] { o });
        } catch (NoSuchMethodException e) {
            visitDefault(o);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        PrintVisitor v=new PrintVisitor();
        List ad=new ArrayList();
        Visitable aa=new VisitableString("asd");
        ad.add(123f);
        ad.add(aa);
        v.visitCollection(ad);
    }
}

