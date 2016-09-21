package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Masha on 21.09.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(FirefoxDriver wd){
    super(wd);
  }

  public void fillContactData(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getSurname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("notes"), contactData.getNotes());
  }

  public void observeContact() {
    click(By.linkText("home"));
  }

  public void submitNewContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void deleteSelectedContact() {
      if (!wd.findElement(By.name("selected[]")).isSelected()) {
        click(By.name("selected[]"));
      }
      click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
      wd.switchTo().alert().accept();
  }
}
