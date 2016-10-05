package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Masha on 22.09.2016.
 */
public class GroupModificationTests extends TestBase{

  @Test
  public void testGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modifyGroup(new GroupData("1group1", "newHeader", "newFooter", null));
    int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after, before);
  }

  @Test
  public void testGroupModificationNotChangedFields(){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("1group1", "newHeader", "newFooter", null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modifyGroup(new GroupData("1group1", "newHeader", "newFooter", null));
  }

  @Test
  public void testGroupModificationParentGroupSelected(){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modifyGroup(new GroupData("group5", "newHeader", "newFooter", "group2"));
  }

  @Test
  public void testGroupModificationForSameGroup(){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modifyGroup(new GroupData("group6", "newHeader", "newFooter", "group1"));
  }

  @Test
  public void testGroupModificationForSameGroupNot(){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("group2", null, null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modifyGroup(new GroupData("group7", "newHeader", "newFooter", "group2"));
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
     app.getGroupHelper().selectGroup();
     app.getGroupHelper().initGroupModification();
     app.getGroupHelper().submitGroupModification();
     app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupModificationCreateNewGroup(){
     app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("groupNew", null, null, null));
    }
    app.getGroupHelper().modifyGroup(new GroupData("new1", "new1", "new1", null));
  }

  @Test
  public void testGroupModificationSetEmptyFields(){
     app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("groupEmpty", null, null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().modifyGroup(new GroupData("", "", "", null));
  }

    @Test
    public void testGroupModificationOnlyParentGroup(){
        app.getNavigationHelper().gotoGroupPage();
      if(! app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroup(new GroupData("updatedGroupName", null, null, null));
      }
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().modifyGroup(new GroupData(null, null, null, "group2"));
    }

    @Test
    public void testModifyOnlyGroupName(){
        app.getNavigationHelper().gotoGroupPage();
      if(! app.getGroupHelper().isThereAGroup()){
        app.getGroupHelper().createGroup(new GroupData("groupToUpd", null, null, null));
      }
      app.getGroupHelper().selectGroup();
      app.getGroupHelper().modifyGroup(new GroupData("updatedGroupName", null, null, null));
    }

}
