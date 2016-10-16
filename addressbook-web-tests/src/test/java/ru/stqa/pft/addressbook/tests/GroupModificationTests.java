package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Masha on 22.09.2016.
 */
public class GroupModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().list().size() == 0){
      app.group().create(new GroupData().withName("group1"));
    }
  }

  @Test
  public void testGroupModification(){
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group =
            new GroupData().withId(before.get(index).getId()).withName("group1")
                    .withHeader("newHeader").withFooter("newFooter");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    String previousName = before.get(index).getName();
    String[] parts = previousName.split(" ");

    if(parts.length > 1) {
      String groupName = parts[1];
      group.withName(group.getName() + " " + groupName);
    }

    before.remove(index);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupModificationNotChangedFields(){
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group =
            new GroupData().withId(before.get(index).getId())
            .withName("group1").withHeader("newHeader").withFooter("newFooter");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    String previousName = before.get(index).getName();
    String[] parts = previousName.split(" ");

    if(parts.length > 1) {
      String groupName = parts[1];
      group.withName(group.getName() + " " + groupName);
    }

    before.remove(index);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupModificationParentGroupSelected(){
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group =
            new GroupData().withId(before.get(index).getId())
            .withGroup("group5").withHeader("newHeader").withFooter("newFooter").withGroup("group1");
    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    String previousName = before.get(index).getName();
    String[] parts = previousName.split(" ");

    if(parts.length > 1) {
      String name = parts[0];
      String groupName = parts[1];
      group.withName(name + " " + groupName);
    }

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupModificationForSameGroup(){
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group =
            new GroupData().withId(before.get(index).getId())
                    .withName("group6").withHeader("newHeader").withFooter("newFooter").withGroup("group1");
    app.group().modify(index, group);

    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    group.withName(group.getName() + " " + "(" + group.getGroup() + ")");

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test///
  public void testGroupModificationForSameGroupNot(){
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group =
            new GroupData().withId(before.get(index).getId())
            .withName("group7").withHeader("newHeader").withFooter("newFooter").withGroup("group2");
    app.group().modify(index, group);

    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    if(group.getGroup() != null) {
      group.withName(group.getName() + " " + "(" + group.getGroup() + ")");
    }

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


  @Test
  public void testUndefinedGroupModification(){
    app.group().initGroupModification();
    //Assert.assertEquals(app.group().checkIfErrorMessageIsPresentOnPage(), false);    /* attempt to check if notice is present on group page or not*/
    app.group().submitGroupModification();
    Assert.assertEquals(app.group().checkIfMessageBoxContainsText("Invalid ID."), true);
    app.group().returnToGroupPage();
  }

  @Test
  public void testUndefinedGroupModificationSetFields(){
     app.group().initGroupModification();
     app.group().fillGroupForm(new GroupData()
                .withName("group8").withHeader("newHeader").withFooter("newFooter"));
     app.group().submitGroupModification();
     Assert.assertEquals(app.group().checkIfMessageBoxContainsText("Invalid ID."), true);
     app.group().returnToGroupPage();
  }

  @Test
  public void testGroupModificationEditNothing(){
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;

     app.group().selectGroup(index);
     app.group().initGroupModification();
     app.group().submitGroupModification();
     app.group().returnToGroupPage();

    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


  @Test
  public void testGroupModificationSetEmptyFields(){
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    GroupData group =
            new GroupData().withId(before.get(index).getId());
    app.group().modify(index, group);

    List<GroupData> after = app.group().list();
    Assert.assertEquals(after.size(), before.size());

    String previousName = before.get(index).getName();
    String[] parts = previousName.split(" ");

    if(parts.length > 1) {
      String name = parts[0];
      String groupName = parts[1];
      group.withName(name + " " + groupName);
    }
    else{
      String name = parts[0];
      group.withName(name);
    }

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

    @Test
    public void testGroupModificationOnlyParentGroup(){
      List<GroupData> before = app.group().list();
      int index = before.size() - 1;
      GroupData group =
              new GroupData().withId(before.get(index).getId()).withGroup("group1");
      app.group().modify(index, group);

      List<GroupData> after = app.group().list();
      Assert.assertEquals(after.size(), before.size());

      String previousName = before.get(index).getName();
      String[] parts = previousName.split(" ");

      if(parts.length > 1) {
        String name = parts[0];
        String groupName = parts[1];
        group.withName(name + " " + groupName);
      }

      before.remove(index);
      before.add(group);
      Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }

    @Test
    public void testModifyOnlyGroupName(){
      List<GroupData> before = app.group().list();
      int index = before.size() - 1;
      GroupData group =
              new GroupData().withId(before.get(index).getId())
                      .withName("updatedGroupName");
      app.group().modify(index, group);

      List<GroupData> after = app.group().list();
      Assert.assertEquals(after.size(), before.size());

      String previousName = before.get(index).getName();
      String[] parts = previousName.split(" ");

      if(parts.length > 1) {
        String groupName = parts[1];
        group.withName(group.getName() + " " + groupName);
      }

      before.remove(index);
      before.add(group);
      Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }
}
