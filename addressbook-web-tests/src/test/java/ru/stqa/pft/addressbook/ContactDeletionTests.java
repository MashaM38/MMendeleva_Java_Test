package ru.stqa.pft.addressbook;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{
    
    @Test
    public void testContactDeletion() {
        observeContact();
        deleteSelectedContact();

        try{
            observeContact();
        }
        catch (UnhandledAlertException f) {
            try {
                Alert alert = wd.switchTo().alert();
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
