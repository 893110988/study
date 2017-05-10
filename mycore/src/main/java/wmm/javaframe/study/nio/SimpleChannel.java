package wmm.javaframe.study.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wangmm on 2016/11/16.
 * 通道就是起到一个连接的作用，，缓冲区给定容量，然后在容量的限制内移动
 *  关键属性：position 指针
 *          limit 内容大小
 *          capacity 容量大小
 *  对buffer进行处理
 *
 *  filp:写到读的指针转化
 *  clean：也是指针的转化，其实没有清空内容
 *  compact：也是指针的转化，和clean的区别就是没有读完的会转到新的buffer里面放在开头
 *
 */
public class SimpleChannel {

    public static void main(String[] args) throws Exception {
        RandomAccessFile aFile = new RandomAccessFile("C:\\Users\\Administrator\\Desktop\\aa.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());
            }
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();

    }
}
