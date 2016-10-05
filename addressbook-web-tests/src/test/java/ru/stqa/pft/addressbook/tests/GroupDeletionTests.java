package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().gotoGroupPage();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);
    }

    @Test
    public void testGroupDeletionWithBottomDeleteButton() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
        }
        app.getGroupHelper().selectGroup(before - 1);
        app.getGroupHelper().deleteSelectedGroupsWithBottomDeleteButton();
        app.getGroupHelper().returnToGroupPage();
    }

    @Test
    public void testGroupDeletionSelectSeveralGroups() {
        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if(! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("group1", null, null, null));
            app.getGroupHelper().createGroup(new GroupData("group2", null, null, null));
        }
        app.getGroupHelper().selectGroup(before - 1);
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