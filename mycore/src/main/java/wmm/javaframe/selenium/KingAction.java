package wmm.javaframe.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by wangmm on 2017/2/14.
 */
public class KingAction {

    public static void testBrowser() throws Exception
    {
        System.setProperty("webdriver.firefox.bin", "E:\\work\\tool\\firefox\\33\\install\\firefox.exe");
       // DesiredCapabilities des = DesiredCapabilities.firefox();
        //des.setCapability("webdriver.firefox.bin", "E:\\work\\tool\\firefox\\install\\firefox.exe");
        WebDriver driver = new FirefoxDriver();//直接new一个FirefoxDriver即可
        WebDriver.Navigation navigation = driver.navigate();
        navigation.to("http://user.snh48.com/login.php?return_url=https://shop.48.cn/tickets/item/682");
        //driver.get("");
        // 浏览器最大化
        driver.manage().window().maximize();
        WebElement editBox = driver.findElement(By
                .id("username"));
        editBox.sendKeys("zuiyuan");
        WebElement editBox2 = driver.findElement(By
                .id("password"));
        editBox2.sendKeys("wmm123456");
        TestYzmByElementPoint.test1(driver,driver.findElement(By
                .id("img")));
       // driver.navigate().to("http://www.baidu.com");
        // 刷新浏览器
       // driver.navigate().refresh();
        // 浏览器后退
       // driver.navigate().back();
        // 浏览器前进
        //driver.navigate().forward();
        // 浏览器退出
       // driver.quit();
    }

    public static void main(String[] args) throws Exception {
        testBrowser();

    }
}
