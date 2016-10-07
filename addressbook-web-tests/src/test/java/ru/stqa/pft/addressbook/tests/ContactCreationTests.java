package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {
    
    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToCreateNewContactPage();
        ContactData contact = new ContactData("user2", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group1");
        app.getContactHelper().fillContactData(contact);
        app.getContactHelper().selectDateOfBirthByValue("7");
        app.getContactHelper().submitNewContact();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

    @Test
    public void testContactCreationWithEnterButtonOnTop() {
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().goToCreateNewContactPage();
        ContactData contact = new ContactData("user2", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group2");
        app.getContactHelper().fillContactData(contact);
        app.getContactHelper().submitNewContactWithButtonOnTop();
        app.getNavigationHelper().gotoHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

    /* TBD: если не заполнять данные контакта, то он берет данные предыдущего, а нужно создать контакт с пустыми данными*/
    @Test
    public void testContactCreationEmpty() {
      app.getNavigationHelper().gotoHomePage();
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getNavigationHelper().goToCreateNewContactPage();
      ContactData contact = new ContactData(before.size() + 1, new String(), new String(), "", "", "", "", "", null);
      app.getContactHelper().submitNewContactWithButtonOnTop();
      app.getNavigationHelper().gotoHomePage();

      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() + 1);

      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }

    @Test
    public void testContactCreationAddNextContact() {
      app.getNavigationHelper().gotoHomePage();
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getNavigationHelper().goToCreateNewContactPage();
      ContactData contact = new ContactData("user3", "UserSurname", "COMP", "Some address", "+38096-756-20-92", "someUser@mail.ru", "feel free to share any comments", "group1");
      app.getContactHelper().fillContactData(contact);
      app.getContactHelper().selectDateOfBirthByValue("7");
      app.getContactHelper().submitNewContact();
      before.add(contact);

      app.getContactHelper().addNextContact();
      contact = new ContactData("user4", "UserSurname4", null, null, null, null, null, null);
      app.getContactHelper().fillContactData(contact);
      app.getContactHelper().selectDateOfBirthByValue("8");
      app.getContactHelper().submitNewContact();
      app.getNavigationHelper().gotoHomePage();

      before.add(contact);
      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size());

      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }

    @Test
    public void testContactCreationDefaultData() {
      app.getNavigationHelper().gotoHomePage();
      List<ContactData> before = app.getContactHelper().getContactList();
      app.getNavigationHelper().goToCreateNewContactPage();
      ContactData contact = new ContactData("userNew", "userNew", null, null, null, null, null, null);
      app.getContactHelper().fillContactData(contact);
      app.getContactHelper().selectDateOfBirthByValue(null);
      app.getContactHelper().submitNewContact();
      app.getNavigationHelper().gotoHomePage();

      List<ContactData> after = app.getContactHelper().getContactList();
      Assert.assertEquals(after.size(), before.size() + 1);

      before.add(contact);
      Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);
    }

    @Test
    public void testContactCreationAllDefaultData() {
        app.getNavigationHelper().goToCreateNewContactPage();
        app.getContactHelper().fillContactData(new ContactData(null, null, null, null, null, null, null, null));
        app.getContactHelper().selectDateOfBirthByValue("7");
        app.getContactHelper().submitNewContact();
        app.getNavigationHelper().gotoHomePage();
    }
}
