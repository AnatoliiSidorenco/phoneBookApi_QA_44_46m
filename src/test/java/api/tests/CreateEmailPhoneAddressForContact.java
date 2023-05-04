package api.tests;

import api.helpers.AddressHelper;
import api.helpers.ContactHelper;
import api.helpers.EmailHelper;
import api.helpers.PhoneHelper;
import org.testng.annotations.Test;

public class CreateEmailPhoneAddressForContact {
    EmailHelper emailHelper = new EmailHelper();
    PhoneHelper phoneHelper = new PhoneHelper();
    AddressHelper addressHelper = new AddressHelper();
    ContactHelper contactHelper = new ContactHelper();

    @Test
    public void lifeCycleOfEmailPhoneAddressInContact() {
        Integer contactId = contactHelper.createContact();

        Integer emailId = emailHelper.createEmail(contactId);
        Integer phoneId = phoneHelper.addNewPhone(contactId);
        Integer addressId = addressHelper.addNewAddress(contactId);

        emailHelper.updateExistedEmail(emailId, contactId);
        phoneHelper.updateExistedPhone(phoneId, contactId);
        addressHelper.updateExistedAddress(addressId, contactId);

        emailHelper.deleteEmail(emailId);
        phoneHelper.deleteExistedPhone(phoneId);
        addressHelper.deleteExistedAddress(addressId);

        contactHelper.deleteContact(contactId);
    }
}
