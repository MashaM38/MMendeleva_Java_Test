package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
  }

  @Test
  public void testGroupCreationSelectNewButtonInBottom() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreationWithNewButtonInBottom();
    app.getGroupHelper().fillGroupForm(new GroupData("group2", "group2", "group2", "group1"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupCreationSelectNoneParentGroup() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("group3", "group3", "group3", ""));
  }

  @Test
  public void testGroupCreationSelectSomeParentGroup() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData("group4", "group4", "group4", "group2"));
  }

  @Test
  public void testGroupCreationSelectParentGroupOnly() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().createGroup(new GroupData(null, null, null, "group1"));
  }

  @Test
  public void testCreateGroupEmpty() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreationWithNewButtonInBottom();
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }
}
