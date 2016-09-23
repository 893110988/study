package wmm.javaframe.study.thread.volatile1;

/**
 * 模拟阻塞操作实验volatile关键字
 */
public class VolatileTest {

    public static volatile int a=1;


    public static void main(String[] args) {
        for (int i=0;i<300;i++){
            ThreadClass a=new ThreadClass();
            a.start();

        }

    }
}
