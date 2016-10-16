package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
      app.goTo().gotoHomePage();
      if(! app.contact().isThereContact()){
        app.goTo().createContact();
        app.contact().create(
                new ContactData().withName("user1").withSurname("UserSurname").withCompany("COMP")
                    .withAddress("Some address").withHomePhone("+38096-756-20-92").withEmail("someUser@mail.ru")
                    .withNotes("feel free to share any comments").withGroup("group3"));
        app.goTo().gotoHomePage();
      }
    }

    @Test
    public void testContactDeletion() {
        List<ContactData> before = app.contact().contactList();
        int index = before.size() - 1;
        app.contact().clickSelectedContact(index);
        app.contact().deleteSelectedContact();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }

    @Test
    public void testContactDeletionThroughEditMenu() {
        app.contact().initContactModification();
        app.contact().deleteSelectedContactFromEditForm();
        app.goTo().gotoHomePage();
    }

    @Test
    public void testDeleteAllContacts() {
        app.contact().selectAllRecords();
        app.contact().deleteSelectedContact();
        app.goTo().gotoHomePage();
    }
}
