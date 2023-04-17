package api.tests;

import api.contact.ContactApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonContactTest extends ContactApi {

    @Test
    public void createEditDeleteNewContact() {
        Response actualResponse = createContact(201);
        int contactId = actualResponse.jsonPath().getInt("id");
        Response expectedResponse = getContact(200, contactId);
        Assert.assertEquals(actualResponse.jsonPath().getString("firstName"), expectedResponse.jsonPath().getString("firstName"), "First name contact not equal");


    }
}
