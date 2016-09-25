package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Masha on 22.09.2016.
 */
public class ContactModificationTests extends TestBase{

  @Test
  public void testSelectedSingleContactModification() {
    app.getContactHelper().observeContact();
    app.getContactHelper().clickSelectedContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(new ContactData("222User1", "222User1Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().observeContact();
  }

  @Test
  public void testContactModification() {
    app.getContactHelper().observeContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(new ContactData("222User1", "222User1Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().observeContact();
  }

  @Test
  public void testContactModificationWithUpdateButtonOnTop() {
    app.getContactHelper().observeContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactData(new ContactData("333User1", "333User1Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments"));
    app.getContactHelper().submitContactModificationWitUpdateButtonOnTop();
    app.getContactHelper().observeContact();
  }

  @Test
  public void testModifyContactWithInfo() {
     app.getContactHelper().observeContact();
     app.getContactHelper().clickSelectedContact();
     app.getContactHelper().initContactModifyWithInfo();
     app.getContactHelper().modifyContact();
     app.getContactHelper().fillContactData(new ContactData("333User1", "333User1Surname", "222COMP", "222Some address", "222+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments"));
     app.getContactHelper().submitContactModificationWitUpdateButtonOnTop();
     app.getContactHelper().observeContact();
  }

    @Test
    public void testModifyGroupForContact() {
        app.getContactHelper().observeContact();
        app.getContactHelper().clickSelectedContact();
        app.getContactHelper().selectGroupForContactByIndex(1);
        app.getContactHelper().addContactsToGroup();
    }

}
