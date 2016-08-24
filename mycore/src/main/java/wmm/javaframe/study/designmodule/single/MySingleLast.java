package wmm.javaframe.study.designmodule.single;

/**
 * Created by Administrator on 2016/8/23.
 * 静态方法 构造器  静态内部类（也是普通类的构建顺序）
 */
public class MySingleLast {

    private MySingleLast() {

    }
    public static MySingleLast getGetMySingleLast(){
        return GetMySingleLast.mySingleLast;
    }

    private static class  GetMySingleLast{
        static MySingleLast mySingleLast = new MySingleLast();
    }
}
