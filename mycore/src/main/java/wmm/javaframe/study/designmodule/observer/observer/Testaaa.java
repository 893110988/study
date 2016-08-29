package wmm.javaframe.study.designmodule.observer.observer;

/**
 * Created by Administrator on 2016/8/26.
 * 定义后的方法被观察者改变后  观察者会做出反应
 */
public class Testaaa {

    public static void main(String[] args) {
        Reader reader1 =new Reader("r1");
        Reader reader2 =new Reader("r2");
        Reader reader3 =new Reader("r3");
        Reader reader4 =new Reader("r4");

        Writer writer1 =new Writer("w1");
        Writer writer2 =new Writer("w2");

        reader1.addObservable("w1");
        reader1.addObservable("w2");

        writer1.writerBook("asdfasdfasd");
        writer2.writerBook("asdfasdfasd2");

    }
}
