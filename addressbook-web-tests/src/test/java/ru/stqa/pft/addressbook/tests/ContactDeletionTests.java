package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    
    @Test
    public void testContactDeletion() {
        app.observeContact();
        app.deleteSelectedContact();

        try{
            app.observeContact();
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = app.wd.switchTo().alert();
                String alertText = alert.getText();
                System.out.println("Alert data: " + alertText);
                alert.accept();
            }
            catch (NoAlertPresentException e) {
                e.printStackTrace();
            }
        }
    }
}
