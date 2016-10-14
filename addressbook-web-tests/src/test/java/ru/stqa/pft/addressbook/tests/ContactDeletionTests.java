package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTests extends TestBase {
    
    @Test
    public void testContactDeletion() {
        app.goTo().gotoHomePage();
        if(! app.getContactHelper().isThereContact()){
            app.goTo().goToCreateNewContactPage();
            app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"));
            app.goTo().gotoHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().clickSelectedContact(before.size() - 1);
        app.getContactHelper().deleteSelectedContact();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

    @Test
    public void testContactDeletionThroughEditMenu() {
        app.goTo().gotoHomePage();
        if(! app.getContactHelper().isThereContact()){
            app.goTo().goToCreateNewContactPage();
            app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"));
            app.goTo().gotoHomePage();
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteSelectedContactFromEditForm();
        app.goTo().gotoHomePage();
    }

    @Test
    public void testDeleteAllContacts() {
        app.goTo().gotoHomePage();
        if(! app.getContactHelper().isThereContact()){
            app.goTo().goToCreateNewContactPage();
            app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"));
            app.goTo().gotoHomePage();
        }
        app.getContactHelper().selectAllRecords();
        app.getContactHelper().deleteSelectedContact();
        app.goTo().gotoHomePage();
    }
}
