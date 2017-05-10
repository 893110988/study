package wmm.javaframe.selenium;



import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Created by wangmm on 2017/2/14.
 */
    /**
     * @author QiaoJiaofei
     * @version 创建时间：2015年8月27日 上午10:29:57
     * 类说明
     */
    public class TestYzmByElementPoint{
        ;

        /*public void before() {
            String key = "webdriver.chrome.driver";
            String value = "D:/BaiduYunDownload/selenium/chromedriver.exe";
            System.setProperty(key, value);
            dr = new ChromeDriver();
            dr.manage().window().maximize();
        }*/


        public static void test1(WebDriver dr,WebElement element) {
            /*dr.get("http://172.16.30.242:5555/register.shtml");
            WebDriverWait wait = new WebDriverWait(dr,10);
             = wait.until(new ExpectedCondition<WebElement>() {

                @Override
                public WebElement apply(WebDriver arg0) {
                    // TODO Auto-generated method stub
                    return arg0.findElement(By.id("codeimg"));
                }

            });*//*dr.get("http://172.16.30.242:5555/register.shtml");
            WebDriverWait wait = new WebDriverWait(dr,10);
             = wait.until(new ExpectedCondition<WebElement>() {

                @Override
                public WebElement apply(WebDriver arg0) {
                    // TODO Auto-generated method stub
                    return arg0.findElement(By.id("codeimg"));
                }

            });*/
            File scrFile = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
            //WebElement element = dr.findElement(By.id("codeimg"));

            try {
                Point p = element.getLocation();
                int width = element.getSize().getWidth();
                int higth = element.getSize().getHeight();
                Rectangle rect = new Rectangle(width, higth);
                BufferedImage img = ImageIO.read(scrFile);
                BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width, higth);
                ImageIO.write(dest, "png", scrFile);
                Thread.sleep(1000);
                File filepicF=new File("D:/ddd/yzm.png");

              /*  Ocr.setUp(); // one time setup
                Ocr ocr = new Ocr(); // create a new OCR engine
                ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
                String s = ocr.recognize(new File[] {filepicF},Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);*/
              /*  System.out.println("Result: " + s);
                System.out.println("图片文字为:" + s.replace(",", "").replace("i", "1").replace(" ", "").replace("'", "").replace("o", "0").replace("O", "0").replace("g", "6").replace("B", "8").replace("s", "5").replace("z", "2"));
                // ocr more images here ...*/

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
      /*  public void after() {
            dr.quit();
        }*/
}
