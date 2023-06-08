package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutodocMoveToCart {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        //Открыть страницу Автодок
        driver.get("https://www.autodoc.ru/");
        Thread.sleep(5000);

        driver.manage().deleteAllCookies();

        Cookie cookie = new Cookie("accessToken", "eyJhbGciOiJSUzI1NiIsImtpZCI6IlNVUVNZUDhPNUtKWFlEWVVHV1paMEpJLTAtTEJUR0NGMTRCSTE2S1YiLCJ0eXAiOiJKV1QifQ.eyJzdWIiOiIxMTkyMDA1IiwibmFtZWlkIjoiMTE5MjAwNSIsInVuaXF1ZV9uYW1lIjoiU01BLTEyMSIsImVtYWlsIjoiSm8qKioqKkBtYWlsLnJ1Iiwic3RhdHVzIjoiMiIsImRpc2NvdW50Ijoi0J7Qv9GCMiIsImNpdHkiOiLQodCw0LzQsNGA0LAiLCJsYXRpdHVkZSI6IjUzMjQxNDQwIiwibG9uZ2l0dWRlIjoiNTAyMzYwOTMiLCJjdXJyZW50YWNjZXNzbGV2ZWwiOiIyIiwibmFtZSI6ItCe0LHQvCoqKiDQlSoqKiDQkioqKiIsImNpdHlpZCI6IjEwMiIsInBhcmVudGlkIjoiMTE4MzA5MyIsInBob25lIjoiKzcgKCoqKikgKioqLTMyLTE3IiwidG9rZW5fdXNhZ2UiOiJhY2Nlc3NfdG9rZW4iLCJqdGkiOiIyNTg4NDFmZi1mNWNkLTRlOTYtOGMyMy04OWM1YmVkYjBlNjEiLCJzY29wZSI6Im9mZmxpbmVfYWNjZXNzIiwibmJmIjoxNjg2MjI3MjgwLCJleHAiOjE2ODYyMjg0ODAsImlhdCI6MTY4NjIyNzI4MCwiaXNzIjoiaHR0cHM6Ly9hdXRoLmF1dG9kb2MucnUvIn0.lM7EHILEaegbBmYkXTBft4sWh07jhZxSnd8M5n-EH0A_e5AnFbe4TIn9JWi5RK1xLea2WZRk_5sGgx--Y_j40Iuv-rGWY0gOB07E8dYqtcLVuukU4G3PzO2gPAljnSRV-tlVcs7ttpxtBHAD-hWJ96xtfZPmh5cAqLptU1rjQ6uIDdd27sAyimP2IqIxs5UaXb05EwsaqL5f5bNNBF1DRdc9HiFhr5swHxwnH_ZeChLvHqkEZ1zKv0MIoAWc1I4XUDo5Pbe-upSwqL_8bc-fr4XK42G2beBq6934OPfLNu8lDWYhHHQsmmchg0-Vq2p8MrWAgiokzDucnDqhkcrjPQ");
        driver.manage().addCookie(cookie);

        driver.navigate().refresh();

        Thread.sleep(10000);

        driver.quit();

    }
}
