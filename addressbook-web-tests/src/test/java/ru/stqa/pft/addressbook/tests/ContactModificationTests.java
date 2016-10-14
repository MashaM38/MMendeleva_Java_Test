package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Masha on 22.09.2016.
 */

public class ContactModificationTests extends TestBase{

  @Test
  public void testModifyContactFieldsLeaveTheSameFields() {
    app.getNavigationHelper().gotoHomePage();
    if(! app.getContactHelper().isThereContact()){
      app.getNavigationHelper().goToCreateNewContactPage();
      app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group1"));
      app.getNavigationHelper().gotoHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().clickSelectedContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), null, null, null, null, null, null, null, null);
    app.getContactHelper().fillContactData(contact);
    app.getContactHelper().selectDateOfBirthByValue("7");
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


  @Test
  public void testSelectedSingleContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if(! app.getContactHelper().isThereContact()){
      app.getNavigationHelper().goToCreateNewContactPage();
      app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"));
      app.getNavigationHelper().gotoHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().clickSelectedContact(before.size() - 2);
    app.getContactHelper().initContactModification();
    ContactData contact = new ContactData(before.get(before.size() - 2).getId(), "user3", "user3Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", null);
    app.getContactHelper().fillContactData(contact);
    app.getContactHelper().selectDateOfBirthByValue("9");
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 2);
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


  @Test
  public void testContactModificationWithUpdateButtonOnTop() {
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().clickSelectedContact(before.size() - 2);
    ContactData contact = new ContactData(before.get(before.size() - 2).getId(), "user7", "user7Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", null);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(contact);
    app.getContactHelper().submitContactModificationWitUpdateButtonOnTop();
    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 2);
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

  @Test
  public void testModifyContactWithInfo() {
    app.getNavigationHelper().gotoHomePage();
    if(! app.getContactHelper().isThereContact()){
      app.getNavigationHelper().goToCreateNewContactPage();
      app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"));
      app.getNavigationHelper().gotoHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().clickSelectedContact(before.size() - 2);
    app.getContactHelper().initContactModifyWithInfo();
    app.getContactHelper().modifyContact();
    ContactData contact = new ContactData(before.get(before.size() - 2).getId(), "user8", "333User1Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", null);
    app.getContactHelper().fillContactData(contact);
    app.getContactHelper().submitContactModificationWitUpdateButtonOnTop();
    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 2);
    before.add(contact);

    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

    @Test
    public void testModifyGroupForContact() {
      app.getNavigationHelper().gotoHomePage();
      if(! app.getContactHelper().isThereContact()){
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"));
        app.getNavigationHelper().gotoHomePage();
      }
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().clickSelectedContact(before.size() - 2);
      app.getContactHelper().selectGroupForContactByValue("group1");
      app.getContactHelper().addContactsToGroup();
      app.getNavigationHelper().gotoHomePage();

      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());

      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }

}
