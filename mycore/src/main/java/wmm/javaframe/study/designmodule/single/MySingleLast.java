package wmm.javaframe.study.designmodule.single;

/**
 * Created by Administrator on 2016/8/23.
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
