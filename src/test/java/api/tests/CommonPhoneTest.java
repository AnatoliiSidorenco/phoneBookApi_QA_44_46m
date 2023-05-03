package api.tests;

import api.helpers.PhoneHelper;
import org.testng.annotations.Test;

public class CommonPhoneTest {
    PhoneHelper phoneHelper = new PhoneHelper();
    int contactId = 4804;


    @Test
    public void createEditDeletePhoneTest() {
        phoneHelper.addNewPhoneMy(contactId);
        Integer phoneId = phoneHelper.getPhoneIdMy(contactId);
        phoneHelper.updateExistedPhone(phoneId, contactId);
        phoneHelper.deleteExistedPhone(phoneId);
    }

}
