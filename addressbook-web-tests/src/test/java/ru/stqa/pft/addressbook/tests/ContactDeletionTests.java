package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {
    
    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if(! app.getContactHelper().isThereContact()){
            app.getNavigationHelper().goToCreateNewContactPage();
            app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"), true);
            app.getNavigationHelper().gotoHomePage();
        }
        app.getContactHelper().clickSelectedContact();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
    }

    @Test
    public void testContactDeletionThroughEditMenu() {
        app.getNavigationHelper().gotoHomePage();
        if(! app.getContactHelper().isThereContact()){
            app.getNavigationHelper().goToCreateNewContactPage();
            app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"), true);
            app.getNavigationHelper().gotoHomePage();
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteSelectedContactFromEditForm();
        app.getNavigationHelper().gotoHomePage();
    }

    @Test
    public void testDeleteAllContacts() {
        app.getNavigationHelper().gotoHomePage();
        if(! app.getContactHelper().isThereContact()){
            app.getNavigationHelper().goToCreateNewContactPage();
            app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"), true);
            app.getNavigationHelper().gotoHomePage();
        }
        app.getContactHelper().selectAllRecords();
        app.getContactHelper().deleteSelectedContact();
        app.getNavigationHelper().gotoHomePage();
    }
}
