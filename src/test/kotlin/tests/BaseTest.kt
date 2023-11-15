package tests

import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import util.Properties
import java.util.concurrent.TimeUnit

open class BaseTest {
    lateinit var driver: ChromeDriver
    val properties = Properties
    @BeforeMethod
    fun setup(){
        System.setProperty("webdriver.chrome.driver","C:\\dev\\program-files\\chrome-driver\\chromedriver-win32\\chromedriver.exe");
        driver = ChromeDriver()
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS)
    }

    @AfterMethod
    fun after(){
        Thread.sleep(10000) //some basic delay to check out the webpage before quit is called
        driver.quit()
    }
}