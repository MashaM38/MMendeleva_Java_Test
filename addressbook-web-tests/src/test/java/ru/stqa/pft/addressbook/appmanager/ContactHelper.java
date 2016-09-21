package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Masha on 21.09.2016.
 */
public class ContactHelper {

  private FirefoxDriver wd;

  public ContactHelper(FirefoxDriver wd){
    this.wd = wd;
  }

  public void fillContactData(ContactData contactData) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactData.getName());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactData.getSurname());
      wd.findElement(By.name("company")).click();
      wd.findElement(By.name("company")).clear();
      wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
      wd.findElement(By.name("address")).click();
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
      wd.findElement(By.name("home")).click();
      wd.findElement(By.name("home")).clear();
      wd.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
      wd.findElement(By.name("notes")).click();
      wd.findElement(By.name("notes")).clear();
      wd.findElement(By.name("notes")).sendKeys(contactData.getNotes());
  }

  public void observeContact() {
      wd.findElement(By.linkText("home")).click();
  }

  public void submitNewContact() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void goToCreateNewContactPage() {
      wd.get("http://localhost/addressbook/edit.php");
  }

  public void deleteSelectedContact() {
      if (!wd.findElement(By.name("selected[]")).isSelected()) {
          wd.findElement(By.name("selected[]")).click();
      }
      wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
  }
}
