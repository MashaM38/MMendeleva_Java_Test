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
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
    }
  }

  @Test
  public void testGroupModification(){
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "group1", "newHeader", "newFooter", null);
    app.getGroupHelper().modifyGroup(index, group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupModificationNotChangedFields(){
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "group1", "newHeader", "newFooter", null);
    app.getGroupHelper().modifyGroup(index, group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupModificationParentGroupSelected(){
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "group5", "newHeader", "newFooter", "group1");
    app.getGroupHelper().modifyGroup(index, group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    if(group.getGroup() != null){
      group.setName(group.getName() + " " + "(" + group.getGroup() + ")");
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
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "group6", "newHeader", "newFooter", "group1");
    app.getGroupHelper().modifyGroup(index, group);

    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    if(group.getGroup() != null){
      group.setName(group.getName() + " " + "(" + group.getGroup() + ")");
    }

    before.remove(index);
    before.add(group);
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupModificationForSameGroupNot(){
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "group7", "newHeader", "newFooter", "group2");
    app.getGroupHelper().modifyGroup(index, group);

    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    if(group.getGroup() != null){
      group.setName(group.getName() + " " + "(" + group.getGroup() + ")");
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
    app.getGroupHelper().initGroupModification();
    //Assert.assertEquals(app.getGroupHelper().checkIfErrorMessageIsPresentOnPage(), false);    /* attempt to check if notice is present on group page or not*/
    app.getGroupHelper().submitGroupModification();
    Assert.assertEquals(app.getGroupHelper().checkIfMessageBoxContainsText("Invalid ID."), true);
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testUndefinedGroupModificationSetFields(){
     app.getGroupHelper().initGroupModification();
     app.getGroupHelper().fillGroupForm(new GroupData("group8", "newHeader", "newFooter", null));
     app.getGroupHelper().submitGroupModification();
     Assert.assertEquals(app.getGroupHelper().checkIfMessageBoxContainsText("Invalid ID."), true);
     app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupModificationEditNothing(){
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;

     app.getGroupHelper().selectGroup(index);
     app.getGroupHelper().initGroupModification();
     app.getGroupHelper().submitGroupModification();
     app.getGroupHelper().returnToGroupPage();

    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


  @Test
  public void testGroupModificationSetEmptyFields(){
    List<GroupData> before = app.getGroupHelper().getGroupList();
    int index = before.size() - 1;
    GroupData group = new GroupData(before.get(index).getId(), "", "", "", null);
    app.getGroupHelper().modifyGroup(index, group);

    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    if(group.getGroup() != null){
      group.setName(group.getName() + " " + "(" + group.getGroup() + ")");
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
      List<GroupData> before = app.getGroupHelper().getGroupList();
      int index = before.size() - 1;
      GroupData group = new GroupData(before.get(index).getId(), null, null, null, "group2");
      app.getGroupHelper().modifyGroup(index, group);

      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size());

      if(group.getGroup() != null){
        group.setName(group.getName() + " " + "(" + group.getGroup() + ")");
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
      List<GroupData> before = app.getGroupHelper().getGroupList();
      int index = before.size() - 1;
      GroupData group = new GroupData(before.get(index).getId(), "updatedGroupName", null, null, null);
      app.getGroupHelper().modifyGroup(index, group);

      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size());

      if(group.getGroup() != null){
        group.setName(group.getName() + " " + "(" + group.getGroup() + ")");
      }

      before.remove(index);
      before.add(group);
      Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }
}
