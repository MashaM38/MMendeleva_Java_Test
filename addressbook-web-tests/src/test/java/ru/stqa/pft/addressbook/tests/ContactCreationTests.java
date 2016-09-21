package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {
    
    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().fillContactData(new ContactData("User1", "User1Surname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments"));
        app.getContactHelper().submitNewContact();
        app.getContactHelper().observeContact();
    }
}
