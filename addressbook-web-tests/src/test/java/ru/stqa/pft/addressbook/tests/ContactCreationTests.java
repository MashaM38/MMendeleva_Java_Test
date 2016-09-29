package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {
    
    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().fillContactData(new ContactData("user1", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group3"), true);
        app.getContactHelper().selectDateOfBirthByValue("7");
        app.getContactHelper().submitNewContact();
        app.getNavigationHelper().gotoHomePage();
    }

    @Test
    public void testContactCreationWithEnterButtonOnTop() {
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().fillContactData(new ContactData("user2", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group4"), true);
        app.getContactHelper().submitNewContactWithButtonOnTop();
        app.getNavigationHelper().gotoHomePage();
    }

    @Test
    public void testContactCreationEmpty() {
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().submitNewContactWithButtonOnTop();
        app.getNavigationHelper().gotoHomePage();
    }

    @Test
    public void testContactCreationAddNextContact() {
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().fillContactData(new ContactData("user3", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group5"), true);
        app.getContactHelper().selectDateOfBirthByValue("7");
        app.getContactHelper().submitNewContact();
        app.getContactHelper().addNextContact();
        app.getContactHelper().fillContactData(new ContactData("user4", null, null, null, null, null, null, null), true);
        app.getContactHelper().selectDateOfBirthByValue("8");
        app.getContactHelper().submitNewContact();
        app.getNavigationHelper().gotoHomePage();
    }

    @Test
    public void testContactCreationDefaultData() {
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().fillContactData(new ContactData("userNew", null, null, null, null, null, null, null), true);
        app.getContactHelper().selectDateOfBirthByValue(null);
        app.getContactHelper().submitNewContact();
        app.getNavigationHelper().gotoHomePage();
    }

    @Test
    public void testContactCreationAllDefaultData() {
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().fillContactData(new ContactData(null, null, null, null, null, null, null, null), true);
        app.getContactHelper().selectDateOfBirthByValue("7");
        app.getContactHelper().submitNewContact();
        app.getNavigationHelper().gotoHomePage();
    }
}
