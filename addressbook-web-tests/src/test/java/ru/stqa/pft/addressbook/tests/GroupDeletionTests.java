package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().groupPage();
    if(app.group().list().size() == 0){
      app.group().create(new GroupData("group1", null, null, null));
    }
  }

    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }


  @Test
    public void testGroupDeletionWithBottomDeleteButton() {
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        app.group().selectGroup(index);
        app.group().deleteSelectedGroupsWithBottomDeleteButton();
        app.group().returnToGroupPage();
        List<GroupData> after = app.group().list();
        before.remove(index);
        Assert.assertEquals(before, after);
    }

    @Test
    public void testGroupDeletionSelectSeveralGroups() {
        app.goTo().groupPage();
        if(! app.group().isThereAGroup()){
            app.group().create(new GroupData("group1", null, null, null));
            app.group().create(new GroupData("group2", null, null, null));
        }
        List<GroupData> before = app.group().list();
        app.group().selectGroup(before.size() - 2);
        app.group().selectGroup(before.size() - 1);
        app.group().deleteSelectedGroupsWithBottomDeleteButton();
        app.group().returnToGroupPage();
        List<GroupData> after = app.group().list();
        before.remove(before.size() - 2);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

    @Test
    public void testNoGroupDeletion() {
        List<GroupData> before = app.group().list();
        app.group().deleteSelectedGroupsWithBottomDeleteButton();
        //Assert.assertEquals(app.group().checkIfErrorMessageIsPresentOnPage(), false);    /* attempt to check if notice is present on group page or not*/
        app.group().returnToGroupPage();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(before, after);
    }
}