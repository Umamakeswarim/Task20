package guvi.task20;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class t20one {

 public static void main(String[] args) throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver", "/Users/gokulakkannanm/Downloads/chromedriver-mac-arm64/chromedriver");
  WebDriver d= new ChromeDriver();
  d.manage().window().maximize();
  d.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

  // go to URL
  d.get("https://jqueryui.com/");
  
  //click on datepicker
  d.findElement(By.xpath("//a[contains(text(),'Datepicker')]")).click();
  
  //verify the title of page 
        if (d.getTitle().equals("Datepicker | jQuery UI")) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");}
            
  
  //switching focus to inside frame
  WebElement stringFrame =d.findElement(By.className("demo-frame"));
  d.switchTo().frame(stringFrame);
  
  //Click on Date 
  WebElement dateField = d.findElement(By.xpath("//input[@id='datepicker']"));
  dateField.click();
  
  //Click on next month
  WebElement nextmonth=d.findElement(By.xpath("//a[contains(.,'Next')]/span[contains(.,'Next')]"));
  nextmonth.click();
  
  
  //Click on date 22 
  WebElement date22 = d.findElement(By.xpath("//a[@data-date='22']"));
  date22.click();
  
  //printing the selected date by getting attribute
  String selectedDate = dateField.getAttribute("value");
  Thread.sleep(1000);
  
  System.out.println("The Selected Date is: "+ selectedDate);
  
 //Close the browser 
 d.quit();


 }
}

