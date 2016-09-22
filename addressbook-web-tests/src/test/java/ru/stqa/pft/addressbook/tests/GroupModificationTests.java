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
    app.getGroupHelper().fillGroupForm(new GroupData("ccc", "cccddd", "cccdddcccc"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }

    /*
      TBD: to clarify whether it is normal that message 'Notice: Undefined variable: selected in C:\Program Files\xampp\htdocs\addressbook\group.php on line 60'
      appears in case user tries not to select any group from list, but clicks 'Edit groups' button

      It might be a bug.
       */
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
     app.getGroupHelper().selectParentGroupByIndex(0);
     app.getGroupHelper().fillGroupForm(new GroupData("someField", "someField", "someField"));
     app.getGroupHelper().submitGroupModification();
     Assert.assertEquals(app.getGroupHelper().checkIfMessageBoxContainsText("Invalid ID."), true);
     app.getGroupHelper().returnToGroupPage();
  }


  @Test
  public void testGroupModificationEditParentGroup(){
     app.getNavigationHelper().gotoGroupPage();
     app.getGroupHelper().selectGroup();
     app.getGroupHelper().initGroupModification();
     app.getGroupHelper().selectParentGroupByIndex(1);
     app.getGroupHelper().fillGroupForm(new GroupData("222ccc", "222cccddd", "222cccdddcccc"));
     app.getGroupHelper().submitGroupModification();
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
     app.getGroupHelper().selectParentGroupByIndex(0);
     app.getGroupHelper().fillGroupForm(new GroupData("new1", "new1", "new1"));
     app.getGroupHelper().submitGroupModification();
     app.getGroupHelper().returnToGroupPage();
  }

  @Test
  public void testGroupModificationSetEmptyFields(){
     app.getNavigationHelper().gotoGroupPage();
     app.getGroupHelper().selectGroup();
     app.getGroupHelper().initGroupModification();
     app.getGroupHelper().selectParentGroupByIndex(0);
     app.getGroupHelper().fillGroupForm(new GroupData("", "", ""));
     app.getGroupHelper().submitGroupModification();
     app.getGroupHelper().returnToGroupPage();
  }
}
