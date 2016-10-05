package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);
    }

    @Test
    public void testGroupDeletionWithBottomDeleteButton() {
        app.getNavigationHelper().gotoGroupPage();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroupsWithBottomDeleteButton();
        app.getGroupHelper().returnToGroupPage();
    }

    @Test
    public void testGroupDeletionSelectSeveralGroups() {
        app.getNavigationHelper().gotoGroupPage();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
            app.getGroupHelper().createGroup(new GroupData("group2", null, null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().selectOneMoreGroup();
        app.getGroupHelper().deleteSelectedGroupsWithBottomDeleteButton();
        app.getGroupHelper().returnToGroupPage();
    }

    @Test
    public void testNoGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
        }
        app.getGroupHelper().deleteSelectedGroupsWithBottomDeleteButton();
        //Assert.assertEquals(app.getGroupHelper().checkIfErrorMessageIsPresentOnPage(), false);    /* attempt to check if notice is present on group page or not*/
        app.getGroupHelper().returnToGroupPage();
    }
}