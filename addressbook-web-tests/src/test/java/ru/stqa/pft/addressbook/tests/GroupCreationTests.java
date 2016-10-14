package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData().withName("group1");
    app.group().create(group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupCreationSelectNewButtonInBottom() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group =
            new GroupData().withName("group2").withHeader("group2").withFooter("group2").withGroup("group1");
            //new GroupData("group2", "group2", "group2", "group1");
    app.group().initGroupCreationWithNewButtonInBottom();
    app.group().fillGroupForm(group);
    app.group().submitGroupCreation();
    app.group().returnToGroupPage();
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    if(group.getGroup() != null && !group.getGroup().isEmpty()){
      group.withName(group.getName() + " " + "(" + group.getGroup() + ")");
    }
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupCreationSelectNoneParentGroup() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData().withName("group3").withHeader("group3").withFooter("group3");
            //new GroupData("group3", "group3", "group3", null);
    app.group().create(group);

    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    if(group.getGroup() != null){
      group.withName(group.getName() + " " + "(" + group.getGroup() + ")");
    }
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupCreationSelectSomeParentGroup() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group =
            new GroupData().withName("group4").withHeader("group4").withFooter("group4").withGroup("group2");
            //new GroupData("group4", "group4", "group4", "group2");
    app.group().create(group);

    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    if(group.getGroup() != null){
      group.withName(group.getName() + " " + "(" + group.getGroup() + ")");
    }
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupCreationSelectParentGroupOnly() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData().withGroup("group1");
    app.group().create(group);

    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    if(group.getGroup() != null && group.getName() == null){
      group.withName( "("+ group.getGroup() +")");
    }
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testCreateGroupEmpty() {
    app.goTo().groupPage();
    List<GroupData> before = app.group().list();
    GroupData group = new GroupData();
    app.group().initGroupCreationWithNewButtonInBottom();
    app.group().submitGroupCreation();
    app.group().returnToGroupPage();

    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    if(group.getName() == null){
      group.withName("");
    }

    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
