package wmm.javaframe.study.designmodule.observer.listener;

/**
 * Created by Administrator on 2016/8/29.
 * 我干了某个事情之后别人也会跟着干什么事情
 */
public class Testaaa {
    public static void main(String[] args) {
        Writer w=new Writer("wmm");
        w.addNovel("asd");
        Writer w2=new Writer("wmm2");
        //w2.addNovel("asd2");
        Reader reader =new Reader("wmm1");
        w.registerListener(reader);
        Reader reader2 =new Reader("wmm2");
        w.registerListener(reader2);
        w2.registerListener(reader2);
        w.addNovel("asd1");
        w2.addNovel("asd1");
        w2.giveEvent("222");
        //reader.addEvent(w.);
    }
}
