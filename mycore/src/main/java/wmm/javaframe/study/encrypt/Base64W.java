package wmm.javaframe.study.encrypt;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by wangmm on 2016/11/3.
 */

/**
 * base64 "wmm"->>ascii(119,109,109)->2进制01110111,01101101,01101101->2进制011101,110110,110101,101101->十进制29,54,53,45->d21t
 * 三个字母为一组  3*8=25/6=4   不足三个时后面加0   例：luck 11111111,11111111,11111111,11111111,00000000,00000000
 */
public class Base64W {

    public static void main(String[] args) {
        //默认使用iso8859-1 不支持中文，，base64   网上资料说可以加javabase64.jar进行指定编码加密没试过，原理是可以的
        String name="wmm";
        byte[] a=name.getBytes();
        String encodeBase64=Base64.getEncoder().encodeToString(a);
        System.out.println(encodeBase64);

        String nameCh="中国";
        byte[] nameChutf=nameCh.getBytes(Charset.forName("utf-8"));
        String utf=new String(nameChutf);
        byte[] nameChutf1=nameCh.getBytes(Charset.forName("gb2312"));
        String gbk=new String(nameChutf1);
        String encode=Base64.getEncoder().encodeToString(nameChutf);
        String decodeUtf=new String (Base64.getDecoder().decode(encode));
        String encode1=Base64.getEncoder().encodeToString(nameChutf1);
        System.out.println(encode);
        System.out.println(encode1);

        String s1="分";
            System.out.println(new String(s1.getBytes()));
    }

}
