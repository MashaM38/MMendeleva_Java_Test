package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

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
      app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"), true);
      app.getNavigationHelper().gotoHomePage();
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().clickSelectedContact(before.size() - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(new ContactData(null, null, null, null, null, null, null, null), true);
    app.getContactHelper().selectDateOfBirthByValue("7");
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());
  }


  @Test
  public void testSelectedSingleContactModification() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if(! app.getContactHelper().isThereContact()){
      app.getNavigationHelper().goToCreateNewContactPage();
      app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"), true);
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().clickSelectedContact(before - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(new ContactData("user5", "user5Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", null), false);
    app.getContactHelper().selectDateOfBirthByValue("9");
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if(! app.getContactHelper().isThereContact()){
      app.getNavigationHelper().goToCreateNewContactPage();
      app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"), true);
      app.getNavigationHelper().gotoHomePage();
    }
    app.getContactHelper().performContactModification(new ContactData("user6", "user6Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", null), false);
    app.getNavigationHelper().gotoHomePage();
  }

  @Test
  public void testContactModificationWithUpdateButtonOnTop() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(new ContactData("user7", "user7Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", null), false);
    app.getContactHelper().submitContactModificationWitUpdateButtonOnTop();
    app.getNavigationHelper().gotoHomePage();
  }

  @Test
  public void testModifyContactWithInfo() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if(! app.getContactHelper().isThereContact()){
      app.getNavigationHelper().goToCreateNewContactPage();
      app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"), true);
      app.getNavigationHelper().gotoHomePage();
    }
     app.getContactHelper().clickSelectedContact(before - 1);
     app.getContactHelper().initContactModifyWithInfo();
     app.getContactHelper().modifyContact();
     app.getContactHelper().fillContactData(new ContactData("user8", "333User1Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", null), false);
     app.getContactHelper().submitContactModificationWitUpdateButtonOnTop();
    app.getNavigationHelper().gotoHomePage();
  }

    @Test
    public void testModifyGroupForContact() {
      app.getNavigationHelper().gotoHomePage();
      int before = app.getContactHelper().getContactCount();
      if(! app.getContactHelper().isThereContact()){
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().createContact(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"), true);
        app.getNavigationHelper().gotoHomePage();
      }
      app.getContactHelper().clickSelectedContact(before - 1);
      app.getContactHelper().selectGroupForContactByValue("group3");
      app.getContactHelper().addContactsToGroup();
    }

}
