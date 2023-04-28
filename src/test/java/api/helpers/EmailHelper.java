package api.helpers;

import api.email.EmailApi;
import io.restassured.response.Response;
import org.testng.Assert;

public class EmailHelper extends  EmailApi{

    public void deleteUpdatedEmail(Integer emailId) {
       deleteEmail(200, emailId);
        Response errorMessage = getEmailByEmailId(500, emailId);
        Assert.assertEquals(errorMessage.jsonPath().getString("message"), "Error! This email doesn't exist in our DB");
    }

}
