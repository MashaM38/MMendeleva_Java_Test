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

  public void groupPage() {
    if(isElementPresent(By.cssSelector("#header div.cf>h1>a"))
            && wd.findElement(By.cssSelector("#header div.cf>h1>a")).getText().equals("Groups")
            && isElementPresent(By.name("new"))){
      return;
    }
    click(By.linkText("groups"));
  }

  public void goToCreateNewContactPage() {
    if(isElementPresent(By.cssSelector("#header div.cf>h1>a"))
            && wd.findElement(By.cssSelector("#header div.cf>h1>a")).getText().equals("Edit / add address book entry")
            && isElementPresent(By.name("submit"))){
      return;
    }
    goToPage("http://localhost/addressbook/edit.php");
  }

  public void gotoHomePage() {
    if(isElementPresent(By.id("maintable"))){

      return;
    }
    click(By.linkText("home"));
  }
}
