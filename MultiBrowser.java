import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class TestSearchBrowser {

    @Test
    void testChrome() throws InterruptedException {
        WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.coding-midcareer.com/");
        Thread.sleep(1000);

        driver.findElement(By.className("theme-btn")).click();

        // Create a Select object for the dropdown with id "pre_name_th"
        Select dropdown = new Select(driver.findElement(By.id("pre_name_th")));
        dropdown.selectByValue("นาย");

        WebElement search_name = driver.findElement(By.name("name_th"));
        WebElement search_lastname = driver.findElement(By.name("lastname_th"));
        search_name.sendKeys("มาสาย");
        search_lastname.sendKeys("แต่สวย");

        WebElement search_nameEN = driver.findElement(By.name("name_en"));
        WebElement search_lastnameEN = driver.findElement(By.name("lastname_en"));
        search_nameEN.sendKeys("Thirayut");
        search_lastnameEN.sendKeys("Boonin");

        WebElement search_card = driver.findElement(By.name("id_card"));
        WebElement search_birthday = driver.findElement(By.name("birthday"));
        WebElement search_phone = driver.findElement(By.name("phone"));
        WebElement search_email = driver.findElement(By.name("email"));
        search_card.sendKeys("1719999999990");
        search_birthday.sendKeys("08/08/2544");
        search_phone.sendKeys("0852893235");
        search_email.sendKeys("654259005@webmail.npru.ac.th");

        WebElement ageInput = driver.findElement(By.id("age"));
        String ageValue = ageInput.getAttribute("value");

        System.out.println("อายุ : " + ageValue);

        if (!ageValue.equals("")) {
            System.out.println("Age verification successful!");
        } else {
            System.out.println("Age verification failed!");
        }

        Thread.sleep(5000);

        driver.quit();
    }
}
