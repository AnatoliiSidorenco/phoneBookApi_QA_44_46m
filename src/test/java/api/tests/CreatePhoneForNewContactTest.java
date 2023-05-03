package api.tests;

import api.helpers.ContactHelper;
import api.helpers.PhoneHelper;
import org.testng.annotations.Test;

public class CreatePhoneForNewContactTest {
   PhoneHelper phoneHelper = new PhoneHelper();
    ContactHelper contactHelper = new ContactHelper();

    @Test
    public void lifeCycleOfPhone() {
        Integer contactId = contactHelper.createContact();
        Integer phoneId = phoneHelper.addNewPhone(contactId);
        phoneHelper.updateExistedPhone(phoneId, contactId);
        phoneHelper.deleteExistedPhone(phoneId);
    }
}
