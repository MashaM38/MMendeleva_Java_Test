package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    GroupData group = new GroupData("group2", null, null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();

    group.setId(max1);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
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
