package ru.stqa.pft.addressbook;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class ContactCreationTests extends TestBase{
    
    @Test
    public void testContactCreation() {
        goToCreateNewContactPage();
        fillContactData(new ContactData("User1", "User1Surname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments"));
        submitNewContact();
        observeCreatedContact();
    }
}
