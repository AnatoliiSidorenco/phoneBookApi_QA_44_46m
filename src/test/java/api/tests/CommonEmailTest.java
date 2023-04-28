package api.tests;

import api.email.EmailApi;
import api.helpers.EmailHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CommonEmailTest {
    EmailApi emailApi = new EmailApi();
    int contactId = 4804;
    EmailHelper emailHelper = new EmailHelper();

    @Test
    public void add_Update_DeleteEmail() {
        //todo------------------------------------Создаю имейл---------------------------------------------------------------------------


        emailApi.addEmail(201, contactId);
        Response responseForAddEmail = emailApi.getAllEmailsBycontactId(200, contactId); // здесь я достаю весь список имейлов по contactid/ а так как это List то обращенее идет к первому [0] - му элементу List(как массив)

        // todo -------------------Здесь я достаю данные из Response----------------------------------------------------------------------------------
        int emailId = responseForAddEmail.jsonPath().getInt("[0].id"); // здесь я достаю Id имейла
        String emailAdded = responseForAddEmail.jsonPath().getString("[0].email"); // здесь я достаю как написан сам имейл
        int contactId = responseForAddEmail.jsonPath().getInt("[0].contactId"); // здесь я достаю contact id который прописываю в самом запросе

        //todo -------------------Проверка имейла что приходит в ответе (email) и того что я отправляю в request(randomDataForEmail() - это метод в EmailApi)
        //Assert.assertEquals(emailId, randomDataForEmail(contactId).getId(), "Edited emails is not equals"); //не проходит , логично, так как у имейла который я отправляю еще нету ID
        Assert.assertEquals(emailAdded, emailApi.randomDataForEmail(contactId).getEmail(), "Edited emails is not equals");
        Assert.assertEquals(contactId, emailApi.randomDataForEmail(contactId).getContactId(), "Edited emails is not equals");

        //todo------------------------------------Обновляю имейл---------------------------------------------------------------------------

        emailApi.updateEmail(200, emailId, contactId);
        Response responseForUpdateEmail = emailApi.getAllEmailsBycontactId(200, contactId);
        int emailIdUpdated = responseForUpdateEmail.jsonPath().getInt("[0].id");
        String emailUpdated = responseForUpdateEmail.jsonPath().getString("[0].email"); // здесь я достаю как написан сам имейл
        Assert.assertEquals(emailUpdated, emailApi.randomDataForAddEmail(emailId, contactId).getEmail(), "Edited emails is not equals");

        //todo------------------------------------Удаляю имейл---------------------------------------------------------------------------

        emailApi.deleteEmail(200, emailId);
        String expectedResponse = "Error! This email doesn't exist in our DB";
        Response actualResponse = emailApi.getEmailByEmailId(500, emailId);
        Assert.assertEquals(actualResponse.jsonPath().getString("message"), expectedResponse, "Not equals");

        //todo---------------Также удаление, но при помощи класса Helper-----------------------

        emailHelper.deleteUpdatedEmail(emailId); // тесты чище
    }


}

