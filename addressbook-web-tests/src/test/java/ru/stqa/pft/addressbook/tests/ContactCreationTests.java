package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.goTo().gotoHomePage();
        List<ContactData> before = app.contact().contactList();
        app.goTo().createContact();
        ContactData contact =
                new ContactData().withName("user1").withSurname("UserSurname").withCompany("COMP")
                    .withAddress("Some address").withHomePhone("+38096-756-20-92").withEmail("someUser@mail.ru")
                    .withNotes("feel free to share any comments").withGroup("group1");
        app.contact().create(contact, "7");
        app.goTo().gotoHomePage();
        List<ContactData> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }


    @Test
    public void testContactCreationWithEnterButtonOnTop() {
        app.goTo().gotoHomePage();
        List<ContactData> before = app.contact().contactList();
        app.goTo().createContact();
        ContactData contact =
                new ContactData().withName("userTop").withSurname("UserSurnameTop").withCompany("COMP")
                    .withAddress("Some address").withHomePhone("+38096-756-20-92").withEmail("someUser@mail.ru")
                    .withNotes("feel free to share any comments").withGroup("group1");
        app.contact().fillContactData(contact);
        app.contact().submitNewContactWithButtonOnTop();
        app.goTo().gotoHomePage();

        List<ContactData> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

    /* TBD: если не заполнять данные контакта, то он берет данные предыдущего, а нужно создать контакт с пустыми данными*/
    @Test
    public void testContactCreationEmpty() {
      app.goTo().gotoHomePage();
      List<ContactData> before = app.contact().contactList();
      app.goTo().createContact();
      ContactData contact =
              new ContactData().withId(before.size() + 1);
      app.contact().submitNewContactWithButtonOnTop();
      app.goTo().gotoHomePage();

      List<ContactData> after = app.contact().contactList();
      Assert.assertEquals(after.size(), before.size() + 1);

      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }

    @Test
    public void testContactCreationAddNextContact() {
      app.goTo().gotoHomePage();
      List<ContactData> before = app.contact().contactList();
      app.goTo().createContact();
      ContactData contact =
              new ContactData().withName("user3").withSurname("UserSurname3").withCompany("COMP")
                  .withAddress("Some address").withHomePhone("+38096-756-20-92").withEmail("someUser@mail.ru")
                  .withNotes("feel free to share any comments").withGroup("group1");
      app.contact().create(contact, "7");
      before.add(contact);

      app.contact().addNextContact();
      contact = new ContactData().withName("user4").withSurname("UserSurname4");
      app.contact().create(contact, "8");
      app.goTo().gotoHomePage();

      before.add(contact);
      List<ContactData> after = app.contact().contactList();
      Assert.assertEquals(after.size(), before.size());

      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }

    @Test
    public void testContactCreationDefaultData() {
      app.goTo().gotoHomePage();
      List<ContactData> before = app.contact().contactList();
      app.goTo().createContact();
      ContactData contact =
              new ContactData().withName("useNameNew").withSurname("userSurnameNew");
      app.contact().create(contact, null);
      app.goTo().gotoHomePage();

      List<ContactData> after = app.contact().contactList();
      Assert.assertEquals(after.size(), before.size() + 1);

      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }

    @Test
    public void testContactCreationAllDefaultData() {
        app.goTo().createContact();
        ContactData contactData = new ContactData();
        app.contact().create(contactData, "7");
        app.goTo().gotoHomePage();
    }
}
