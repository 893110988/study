package wmm.javaframe.jdk.beans;

/**
 * Created by wangmm on 2016/12/12.
 */
public class EventHandler{

    public static void main(String[] args) {
      //  EventHandler my = new EventHandler();
       // java.beans.EventHandler.create(EventHandler.class,my,"testMethod");
       // java.beans.EventHandler eventHandler =new java.beans.EventHandler(my,"","","testMethod");
        testThreadLocal();
    }

    private void testMethod(){
        System.out.println("12312");
    }


    private static  void testThreadLocal(){
        ThreadLocal aa=new ThreadLocal();
        aa.set(123);
        aa.set(12);

        System.out.println(aa.get());
    }
}
