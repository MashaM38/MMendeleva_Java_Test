package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    
    @Test
    public void testContactDeletion() {
        app.getContactHelper().observeContact();
        app.getContactHelper().clickSelectedContact();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().observeContact();
    }

    @Test
    public void testContactDeletionThroughEditMenu() {
        app.getContactHelper().observeContact();
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteSelectedContactFromEditForm();
        app.getContactHelper().observeContact();
    }

    @Test
    public void testDeleteAllContacts() {
        app.getContactHelper().observeContact();
        app.getContactHelper().selectAllRecords();
        app.getContactHelper().deleteSelectedContact();
        app.getContactHelper().observeContact();
    }
}
