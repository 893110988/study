package wmm.javaframe.study.reflect.vistor;

import java.util.Collection;

/**
 * Created by Administrator on 2016/8/10.
 */
public interface Visitor {
    public void visitCollection(Collection collection);
    public void visitString(String string);
    public void visitFloat(Float float1);

}
