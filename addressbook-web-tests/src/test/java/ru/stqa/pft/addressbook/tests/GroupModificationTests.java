package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Masha on 22.09.2016.
 */
public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);

    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "group1", "newHeader", "newFooter", null);
    app.getGroupHelper().modifyGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupModificationNotChangedFields(){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("1group1", "newHeader", "newFooter", null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "group1", "newHeader", "newFooter", null);
    app.getGroupHelper().modifyGroup(group);

    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupModificationParentGroupSelected(){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "group5", "newHeader", "newFooter", "group1");
    app.getGroupHelper().modifyGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    if(group.getGroup() != null){
      group.setName(group.getName() + " " + "(" + group.getGroup() + ")");
    }

    before.remove(before.size() - 1);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupModificationForSameGroup(){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "group6", "newHeader", "newFooter", "group1");
    app.getGroupHelper().modifyGroup(group);

    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    if(group.getGroup() != null){
      group.setName(group.getName() + " " + "(" + group.getGroup() + ")");
    }

    before.remove(before.size() - 1);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testGroupModificationForSameGroupNot(){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group2", null, null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "group7", "newHeader", "newFooter", "group2");
    app.getGroupHelper().modifyGroup(group);

    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    if(group.getGroup() != null){
      group.setName(group.getName() + " " + "(" + group.getGroup() + ")");
    }

    before.remove(before.size() - 1);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


  @Test
  public void testUndefinedGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
    }
    app.getGroupHelper().initGroupModification();
    //Assert.assertEquals(app.getGroupHelper().checkIfErrorMessageIsPresentOnPage(), false);    /* attempt to check if notice is present on group page or not*/
    app.getGroupHelper().submitGroupModification();
    Assert.assertEquals(app.getGroupHelper().checkIfMessageBoxContainsText("Invalid ID."), true);
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testUndefinedGroupModificationSetFields(){
     app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
    }
     app.getGroupHelper().initGroupModification();
     app.getGroupHelper().fillGroupForm(new GroupData("group8", "newHeader", "newFooter", null));
     app.getGroupHelper().submitGroupModification();
     Assert.assertEquals(app.getGroupHelper().checkIfMessageBoxContainsText("Invalid ID."), true);
     app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupModificationEditNothing(){
     app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("groupX", null, null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
     app.getGroupHelper().selectGroup(before.size() - 1);
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
     app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("groupEmpty", null, null, null));
    }

    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "", "", "", null);
    app.getGroupHelper().modifyGroup(group);

    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(), before.size());

    if(group.getGroup() != null){
      group.setName(group.getName() + " " + "(" + group.getGroup() + ")");
    }

    before.remove(before.size() - 1);
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

    @Test
    public void testGroupModificationOnlyParentGroup(){
        app.getNavigationHelper().gotoGroupPage();
      if(! app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroup(new GroupData("updatedGroupName", null, null, null));
      }
      List<GroupData> before = app.getGroupHelper().getGroupList();
      app.getGroupHelper().selectGroup(before.size() - 1);
      GroupData group = new GroupData(before.get(before.size() - 1).getId(), null, null, null, "group2");
      app.getGroupHelper().modifyGroup(group);

      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size());

      if(group.getGroup() != null){
        group.setName(group.getName() + " " + "(" + group.getGroup() + ")");
      }

      before.remove(before.size() - 1);
      before.add(group);

      Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }

    @Test
    public void testModifyOnlyGroupName(){
        app.getNavigationHelper().gotoGroupPage();
      if(! app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroup(new GroupData("groupToUpd", null, null, null));
      }
      List<GroupData> before = app.getGroupHelper().getGroupList();
      app.getGroupHelper().selectGroup(before.size() - 1);
      GroupData group = new GroupData(before.get(before.size() - 1).getId(), "updatedGroupName", null, null, null);
      app.getGroupHelper().modifyGroup(group);

      List<GroupData> after = app.getGroupHelper().getGroupList();
      Assert.assertEquals(after.size(), before.size());

      if(group.getGroup() != null){
        group.setName(group.getName() + " " + "(" + group.getGroup() + ")");
      }

      before.remove(before.size() - 1);
      before.add(group);

      Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }
}
