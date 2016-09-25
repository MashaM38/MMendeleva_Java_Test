package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Masha on 21.09.2016.
 */
public class SessionHelper extends HelperBase{

  public SessionHelper(WebDriver wd) {
    super(wd);
  }

  public void login(String username, String userPass) {
    type(By.name("user"), username);
    type(By.name("pass"), userPass);
   click(By.xpath("//form[@id='LoginForm']/input[3]"));
  }
}
