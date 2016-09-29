package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Masha on 21.09.2016.
 */
public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd){
    super(wd);
  }

  public void fillContactData(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getSurname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("notes"), contactData.getNotes());

    if(contactData.getGroup() != null) {
      if (creation) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }
      else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
    }
  }

  public void submitNewContact() {
    doubleClick(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void submitNewContactWithButtonOnTop(){
    click(By.name("submit"));
  }

  public void addNextContact(){
    click(By.xpath("//div[@class='msgbox']//a[.='add next']"));
  }

  public void clickSelectedContact(){
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      click(By.name("selected[]"));
    }
  }

  public void clickSelectedSecondContact(){
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      click(By.xpath("//input[@id='41']"));
    }
  }

  public void selectAllRecords(){
    click(By.id("MassCB"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContactFromEditForm() {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void initContactModifyWithInfo() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[7]/a/img"));
  }

  public void modifyContact() {
    click(By.name("modifiy"));
  }

  public void submitContactModification(){
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void submitContactModificationWitUpdateButtonOnTop(){
    click(By.name("update"));
  }

  public void addContactsToGroup(){
    doubleClick(By.name("add"));
  }

 public void selectDateOfBirthByValue(String value) {
   String existingDate = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[1]"))).getFirstSelectedOption().getText();
   if(value != null) {
     if (!value.equals(existingDate)) {
       selectElementFromDropDownByVisibleText(By.xpath("//div[@id='content']/form/select[1]"), value);
     }
   }
 }

  public void selectGroupForContactByValue(String text) {
    selectElementFromDropDownByVisibleText(By.xpath("//div[@class='right']/select[1]"), text);
  }
}
