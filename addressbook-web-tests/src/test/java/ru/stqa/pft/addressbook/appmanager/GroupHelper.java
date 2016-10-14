package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Masha on 21.09.2016.
 */
public class GroupHelper extends HelperBase{

  public GroupHelper(WebDriver wd) {
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

    if(groupData.getGroup() != null){
      String existingGroup = new Select(wd.findElement(By.xpath("//div[@id='content']/form/select[1]"))).getFirstSelectedOption().getText();

      if(!groupData.getGroup().equals(existingGroup)) {
        selectElementFromDropDownByVisibleText(By.name("group_parent_id"), groupData.getGroup());
      }
    }
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

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void selectOneMoreGroup() {
    click(By.xpath("//div[@id='content']/form/span[2]/input"));
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public boolean checkIfMessageBoxContainsText(String text){
      boolean isPresent = wd.findElement(By.cssSelector("div.msgbox")).getText().contains(text);
      return isPresent;
  }

  /*
  Checks that errorMessage (notice) is present on a group page page after deletion or not
   */
  public boolean checkIfErrorMessageIsPresentOnPage(){
      boolean isPresent = wd.findElement(By.xpath("//div[@id='content']//b[.='Notice']")).isDisplayed();
      return isPresent;
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent((By.name("selected[]")));
  }

  public void modifyGroup(int index, GroupData group){
    selectGroup(index);
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> getGroupList() {
    List<GroupData> groups = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for(WebElement e : elements){
      String name = e.getText();

      int id = Integer.parseInt(e.findElement(By.tagName("input")).getAttribute("value"));
      GroupData group = new GroupData(id, name, null, null, null);
      groups.add(group);
    }

    return groups;
  }
}
