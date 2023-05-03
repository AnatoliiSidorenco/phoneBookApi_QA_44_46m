package api.tests;

import api.helpers.AddressHelper;
import api.helpers.ContactHelper;
import org.testng.annotations.Test;

public class CreateAddressForNewContactTest {
    AddressHelper addressHelper = new AddressHelper();

    ContactHelper contactHelper = new ContactHelper();

    @Test
    public void lifeCycleAddress() {
        Integer contactId = contactHelper.createContact();
        int addressId = addressHelper.addNewAddress(contactId);
        addressHelper.updateExistedAddress(addressId, contactId);
        addressHelper.deleteExistedAddress(addressId);
    }
}
