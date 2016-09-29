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
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("1group1", "newHeader", "newFooter", null));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupModificationNotChangedFields(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("1group1", "newHeader", "newFooter", null));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupModificationParentGroupSelected(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("group5", "newHeader", "newFooter", "group1"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupModificationParentGroupSelectedSame(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("group6", "newHeader", "newFooter", "group1"));//ddd
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupModificationParentGroupSelectedSameNot(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("group7", "newHeader", "newFooter", "group2"));//ddd
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }


  @Test
  public void testUndefinedGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupModification();
    //Assert.assertEquals(app.getGroupHelper().checkIfErrorMessageIsPresentOnPage(), false);    /* attempt to check if notice is present on group page or not*/
    app.getGroupHelper().submitGroupModification();
    Assert.assertEquals(app.getGroupHelper().checkIfMessageBoxContainsText("Invalid ID."), true);
    app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testUndefinedGroupModificationSetFields(){
     app.getNavigationHelper().gotoGroupPage();
     app.getGroupHelper().initGroupModification();
     app.getGroupHelper().fillGroupForm(new GroupData("group8", "newHeader", "newFooter", null));
     app.getGroupHelper().submitGroupModification();
     Assert.assertEquals(app.getGroupHelper().checkIfMessageBoxContainsText("Invalid ID."), true);
     app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupModificationEditNothing(){
     app.getNavigationHelper().gotoGroupPage();
     app.getGroupHelper().selectGroup();
     app.getGroupHelper().initGroupModification();
     app.getGroupHelper().submitGroupModification();
     app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupModificationCreateNewGroup(){
     app.getNavigationHelper().gotoGroupPage();
     app.getGroupHelper().initGroupModification();
     app.getGroupHelper().fillGroupForm(new GroupData("new1", "new1", "new1", null));
     app.getGroupHelper().submitGroupModification();
     app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupModificationSetEmptyFields(){
     app.getNavigationHelper().gotoGroupPage();
     app.getGroupHelper().selectGroup();
     app.getGroupHelper().initGroupModification();
     app.getGroupHelper().fillGroupForm(new GroupData("", "", "", null));
     app.getGroupHelper().submitGroupModification();
     app.getGroupHelper().returnToGroupPage();
  }

    @Test
    public void testGroupModificationOnlyParentGroup(){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData(null, null, null, "group3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }

    @Test
    public void testModifyOnlyGroupName(){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("updatedGroupName", null, null, null));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }

}
