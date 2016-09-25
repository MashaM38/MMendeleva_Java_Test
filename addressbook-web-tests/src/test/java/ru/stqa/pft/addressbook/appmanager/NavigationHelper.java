package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Masha on 21.09.2016.
 */
public class NavigationHelper extends HelperBase{
  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

    public void goToCreateNewContactPage() {
    goToPage("http://localhost/addressbook/edit.php");
  }
}
