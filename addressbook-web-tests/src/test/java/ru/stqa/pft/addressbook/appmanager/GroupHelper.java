package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Masha on 21.09.2016.
 */
public class GroupHelper extends HelperBase{

  public GroupHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void initGroupCreationWithNewButtonInBottom() {
    click(By.xpath("//div[@id='content']/form/input[4]"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void deleteSelectedGroupsWithBottomDeleteButton() {
    click(By.xpath("//div[@id='content']/form/input[5]"));
  }

  public void selectGroup() {
    click(By.name("selected[]"));
  }

  public void selectOneMoreGroup() {
    click(By.xpath("//div[@id='content']/form/span[2]/input"));
  }

  public void selectParentGroupByIndex(int i) {
    Select s = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[1]")));
    s.selectByIndex(i);
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public boolean checkIfMessageBoxContainsText(String text){
      boolean isPresent = wd.findElementByCssSelector("div.msgbox").getText().contains(text);
      return isPresent;
  }

  /*
  Checks that errorMessage (notice) is present on a group page page after deletion or not
   */
  public boolean checkIfErrorMessageIsPresentOnPage(){
      boolean isPresent = wd.findElementByXPath("//div[@id='content']//b[.='Notice']").isDisplayed();
      return isPresent;
  }
}
