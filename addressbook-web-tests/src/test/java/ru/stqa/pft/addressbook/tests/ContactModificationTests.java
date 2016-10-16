package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Masha on 22.09.2016.
 */

public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoHomePage();
    if(app.contact().contactList().size() == 0){
      app.goTo().createContact();
      app.contact().create(
              new ContactData().withName("user1").withSurname("UserSurname").withCompany("COMP")
                      .withAddress("Some address").withHomePhone("+38096-756-20-92").withEmail("someUser@mail.ru")
                      .withNotes("feel free to share any comments").withGroup("group3"));
      app.goTo().gotoHomePage();
    }
  }

  @Test
  public void testModifyContactFieldsLeaveTheSameFields() {
    List<ContactData> before = app.contact().contactList();
    int index = 0;
    ContactData contact =
            new ContactData().withId(before.get(index).getId());
    app.contact().modify(index, contact, "7");
    app.goTo().gotoHomePage();
    List<ContactData> after = app.contact().contactList();
    Assert.assertEquals(after.size(), before.size());

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testSelectedSingleContactModification() {
    List<ContactData> before = app.contact().contactList();
    int index = 0;
    ContactData contact =
            new ContactData().withId(before.get(index).getId()).withName("user3").withSurname("user3Surname")
                .withCompany("222COMP").withAddress("222Some address").withHomePhone("222+38096-756-20-92")
                    .withEmail("someUser@mail.ru").withNotes("feel free to share any comments");
    app.contact().modify(index, contact, "9");
    app.goTo().gotoHomePage();

    List<ContactData> after = app.contact().contactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


  @Test
  public void testContactModificationWithUpdateButtonOnTop() {
    List<ContactData> before = app.contact().contactList();
    int index = 0;
    app.contact().clickSelectedContact(index);
    ContactData contact =
            new ContactData().withName("userUpdatedButtonTop").withSurname("userUpdatedButtonTop")
                .withCompany("222COMP").withAddress("222Some address").withHomePhone("222+38096-756-20-92")
                .withEmail("someUser@mail.ru").withNotes("feel free to share any comments");
    app.contact().initContactModification();
    app.contact().fillContactData(contact);
    app.contact().submitContactModificationWitUpdateButtonOnTop();
    app.goTo().gotoHomePage();

    List<ContactData> after = app.contact().contactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testModifyContactWithInfo() {
    List<ContactData> before = app.contact().contactList();
    int index = 0;
    app.contact().clickSelectedContact(index);
    app.contact().initContactModifyWithInfo();
    app.contact().modifyContact();
    ContactData contact =
            new ContactData().withId(before.get(index).getId()).withName("user8").withSurname("333User1Surname")
                .withCompany("222COMP").withAddress("222Some address").withHomePhone("222+38096-756-20-92")
                .withEmail("someUser@mail.ru").withNotes("feel free to share any comments");
    app.contact().fillContactData(contact);
    app.contact().submitContactModificationWitUpdateButtonOnTop();
    app.goTo().gotoHomePage();

    List<ContactData> after = app.contact().contactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

    @Test
    public void testModifyGroupForContact() {
      List<ContactData> before = app.contact().contactList();
      app.contact().clickSelectedContact(before.size() - 2);
      app.contact().selectGroupForContactByValue("group1");
      app.contact().addContactsToGroup();
      app.goTo().gotoHomePage();

      List<ContactData> after = app.contact().contactList();
      Assert.assertEquals(after.size(), before.size());

      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }

}
