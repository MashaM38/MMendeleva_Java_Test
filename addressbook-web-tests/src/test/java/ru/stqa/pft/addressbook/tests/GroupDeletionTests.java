package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
    }

    @Test
    public void testGroupDeletionWithBottomDeleteButton() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroupsWithBottomDeleteButton();
        app.getGroupHelper().returnToGroupPage();
    }

    @Test
    public void testGroupDeletionSelectSeveralGroups() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().selectOneMoreGroup();
        app.getGroupHelper().deleteSelectedGroupsWithBottomDeleteButton();
        app.getGroupHelper().returnToGroupPage();
    }

    /*
    TBD: to clarify whether it is normal that message 'Notice: Undefined variable: selected in C:\Program Files\xampp\htdocs\addressbook\group.php on line 60'
    appears in case user tries not to select any group from list, but clicks 'Delete groups button'

    It might be a bug.
     */
    @Test
    public void testNoGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().deleteSelectedGroupsWithBottomDeleteButton();
        //Assert.assertEquals(app.getGroupHelper().checkIfErrorMessageIsPresentOnPage(), false);    /* attempt to check if notice is present on group page or not*/
        app.getGroupHelper().returnToGroupPage();
    }
}