package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {
    
    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().fillContactData(new ContactData("User2", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments"));
        app.getContactHelper().selectDateOfBirthByIndex(8);
        app.getContactHelper().submitNewContact();
        app.getContactHelper().observeContact();
    }

    @Test
    public void testContactCreationWithEnterButtonOnTop() {
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().fillContactData(new ContactData("User2", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments"));
        app.getContactHelper().submitNewContactWithButtonOnTop();
        app.getContactHelper().observeContact();
    }

    @Test
    public void testContactCreationEmpty() {
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().submitNewContactWithButtonOnTop();
        app.getContactHelper().observeContact();
    }

    @Test
    public void testContactCreationAddNextContact() {
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().fillContactData(new ContactData("User2", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments"));
        app.getContactHelper().selectDateOfBirthByIndex(8);
        app.getContactHelper().submitNewContact();
        app.getContactHelper().addNextContact();
        app.getContactHelper().fillContactData(new ContactData("User2", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments"));
        app.getContactHelper().selectDateOfBirthByIndex(8);
        app.getContactHelper().submitNewContact();
        app.getContactHelper().observeContact();
    }
}
