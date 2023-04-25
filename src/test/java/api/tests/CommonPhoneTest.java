package api.tests;

import api.phone.PhoneApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonPhoneTest extends PhoneApi {
    @Test
    public void createEditDeletePhoneTest() {
        createPhone(201);
        Response response = getAllPhoneByContactId(200);
        int phoneId = response.jsonPath().getInt("[0].id");
        String phone = response.jsonPath().getString("[0].phoneNumber");
        String countryCode = response.jsonPath().getString("[0].countryCode");
        Assert.assertEquals(phone, randomDataForCreatePhone().getPhoneNumber(), "Created phone is not equals");
        Assert.assertEquals(countryCode, randomDataForCreatePhone().getCountryCode(), "Created countryCode is not equals");

        updatePhone(200, phoneId);
        Response updatedPhone = getAllPhoneByContactId(200);
        String updatedPhoneNumber = updatedPhone.jsonPath().getString("[0].phoneNumber");
        String updatedCountryCode = response.jsonPath().getString("[0].countryCode");
        Assert.assertEquals(updatedPhoneNumber, randomDataForExistingPhone(phoneId).getPhoneNumber(), "Updated phone is not equals");
        Assert.assertEquals(updatedCountryCode, randomDataForExistingPhone(phoneId).getCountryCode(), "Updated countryCode is not equals");

        deletePhone(200, phoneId);
        Response errorMessage = getCreatedPhoneByPhoneId(500, phoneId);
        Assert.assertEquals(errorMessage.jsonPath().getString("message"), "Error! This phone number doesn't exist in our DB");

    }

}
