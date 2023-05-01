package api.tests;

import api.address.AddressApi;
import api.helpers.AddressHelper;
import org.testng.annotations.Test;

public class CommonAddressTest {
    AddressHelper addressHelper = new AddressHelper();
    AddressApi addressApi = new AddressApi();
    int contactId = 4804;


    @Test
    public void createEditDeleteAddressTest() {
        addressHelper.addNewAddress(contactId);
        int addressId = addressApi.getAddressId(contactId);
        addressHelper.updateExistedAddress(addressId, contactId);
        addressHelper.deleteExistedAddress(addressId);
    }
}
