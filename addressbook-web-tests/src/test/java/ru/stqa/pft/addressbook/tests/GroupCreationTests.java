package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("ddd", "ddd", "ddd"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    app.getNavigationHelper().gotoGroupPage();
  }

  @Test
  public void testGroupCreationWithNewButtonInBottom() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreationWithNewButtonInBottom();
    app.getGroupHelper().fillGroupForm(new GroupData("222", "222", "222"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupCreationSelectNoneParentGroup() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreationWithNewButtonInBottom();
    app.getGroupHelper().selectParentGroupByIndex(0);
    app.getGroupHelper().fillGroupForm(new GroupData("3333", "3333", "3333"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupCreationSelectSomeParentGroup() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreationWithNewButtonInBottom();
    app.getGroupHelper().selectParentGroupByIndex(1);
    app.getGroupHelper().fillGroupForm(new GroupData("4444", "4444", "4444"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupCreationSelectParentGroupOnly() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreationWithNewButtonInBottom();
    app.getGroupHelper().selectParentGroupByIndex(1);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testCreateGroupEmpty() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCreationWithNewButtonInBottom();
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }
}
