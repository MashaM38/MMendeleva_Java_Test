package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Masha on 22.09.2016.
 */
public class ContactModificationTests extends TestBase{

  @Test
  public void testModifyContactFieldsLeaveTheSameFields() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().clickSelectedContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(new ContactData(null, null, null, null, null, null, null, null), true);
    app.getContactHelper().selectDateOfBirthByValue("7");
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }


  @Test
  public void testSelectedSingleContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().clickSelectedContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(new ContactData("user5", "user5Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", null), false);
    app.getContactHelper().selectDateOfBirthByValue("9");
    app.getContactHelper().submitContactModification();
    app.getNavigationHelper().gotoHomePage();
  }

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(new ContactData("user6", "user6Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", null), false);
    app.getContactHelper().submitContactModification();
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
     app.getContactHelper().clickSelectedContact();
     app.getContactHelper().initContactModifyWithInfo();
     app.getContactHelper().modifyContact();
     app.getContactHelper().fillContactData(new ContactData("user8", "333User1Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", null), false);
     app.getContactHelper().submitContactModificationWitUpdateButtonOnTop();
    app.getNavigationHelper().gotoHomePage();
  }

    @Test
    public void testModifyGroupForContact() {
      app.getNavigationHelper().gotoHomePage();
      app.getContactHelper().clickSelectedContact();
      app.getContactHelper().selectGroupForContactByValue("group3");
      app.getContactHelper().addContactsToGroup();
    }

}
