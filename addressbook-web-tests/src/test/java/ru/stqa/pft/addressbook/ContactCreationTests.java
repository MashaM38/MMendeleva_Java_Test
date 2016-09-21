package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{
    
    @Test
    public void testContactCreation() {
        goToCreateNewContactPage();
        fillContactData(new ContactData("User1", "User1Surname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments"));
        submitNewContact();
        observeContact();
    }
}
