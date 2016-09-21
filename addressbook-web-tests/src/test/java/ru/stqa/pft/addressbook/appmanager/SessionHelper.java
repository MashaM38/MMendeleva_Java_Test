package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Masha on 21.09.2016.
 */
public class SessionHelper extends HelperBase{

  public SessionHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void login(String username, String userPass) {
    type(By.name("user"), username);
    type(By.name("pass"), userPass);
//    wd.findElement(By.name("user")).click();
//    wd.findElement(By.name("user")).clear();
//    wd.findElement(By.name("user")).sendKeys(username);
//    wd.findElement(By.name("pass")).click();
//    wd.findElement(By.name("pass")).clear();
//    wd.findElement(By.name("pass")).sendKeys(userPass);
   click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
