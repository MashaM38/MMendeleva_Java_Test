package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
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

  public void submitNewContactWithButtonOnTop(){
    click(By.name("submit"));
  }

  public void addNextContact(){
    click(By.linkText("add next"));
  }

  public void clickSelectedContact(){
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      click(By.name("selected[]"));
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
    click(By.name("add"));
  }

  public void goToGroup(){
    click(By.xpath("//div/div[4]/div/i/a"));
  }

  public void removeFromGroup(){
    click(By.name("remove"));
  }

  public void selectDateOfBirthByIndex(int i) {
    Select s = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[1]")));
    s.selectByIndex(i);
  }

  public void selectGroupForContactByIndex(int i) {
    Select s = new Select(wd.findElement(By.xpath("//div[@class='right']/select")));
    s.selectByIndex(i);
  }

}
