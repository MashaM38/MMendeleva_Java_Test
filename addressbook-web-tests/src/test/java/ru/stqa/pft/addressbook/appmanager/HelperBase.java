package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Masha on 21.09.2016.
 */
public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void doubleClick(By locator){
    new Actions(wd).doubleClick(wd.findElement(locator)).build().perform();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText))
      {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  protected void goToPage(String url) {
    wd.get(url);
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public void select(By by, int text){
    Select s = new Select(wd.findElement(by));
    s.selectByIndex(text);
  }

  protected boolean isElementPresent(By locator) {

    try{
      wd.findElement(locator);
      return true;
    }
    catch (NoSuchElementException e){
      return false;
    }
  }

  protected void selectElementFromDropDownByVisibleText(By locator, String text){
    new Select(wd.findElement(locator)).selectByVisibleText(text);
  }
}
