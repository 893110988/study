package wmm.javaframe.study.encrypt;

import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.security.provider.MD5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

/**
 * Created by wangmm on 2016/11/2.
 */
public class MD5W {

    public static String getMd5(String param){
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        MessageDigest messageDigest = null;
        try {
            messageDigest =MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //装配
        byte[] by=messageDigest.digest(param.getBytes());
        int j = by.length;
        char str[] = new char[j * 2];
        int k = 0;
        for (int i = 0; i < j; i++) {
            byte byte0 = by[i];
            //无符号左移动4位  然后转16进制   例2:0000 00010->0000 0000  0:&0xf->0
            str[k++] = hexDigits[byte0 >>> 4 & 0xf];
            //转16进制   例2: 2:&0xf->2
            str[k++] = hexDigits[byte0 & 0xf];
        }
        return new String(str);
    }

    public static void main(String[] args) {
        System.out.println(getMd5("wangmengmeng"));

        System.out.println(18 & 0xf);
    }
}
