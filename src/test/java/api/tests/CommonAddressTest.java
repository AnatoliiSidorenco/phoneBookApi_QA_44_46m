package api.tests;

import api.address.AddressApi;
import api.helpers.AddressHelper;
import org.testng.annotations.Test;

public class CommonAddressTest {
    AddressHelper addressHelper = new AddressHelper();
    AddressApi addressApi = new AddressApi();

    int contactId = 4804;

    //int addressId = addressHelper.getAddressId(contactId);
    @Test
    public void createEditDeleteAddressTest() {
        int addressId = addressHelper.addNewAddress(contactId);
        addressHelper.updateExistedAddress(addressId, contactId);
        addressHelper.deleteExistedAddress(addressId);
    }
}
