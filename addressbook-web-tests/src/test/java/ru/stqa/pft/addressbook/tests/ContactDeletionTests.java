package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().clickSelectedContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
    }

    @Test
    public void testContactDeletionThroughEditMenu() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteSelectedContactFromEditForm();
        app.getNavigationHelper().gotoHomePage();
    }

    @Test
    public void testDeleteAllContacts() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectAllRecords();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
    }
}
