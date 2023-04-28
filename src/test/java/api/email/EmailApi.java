package api.email;

import api.ApiBase;
import io.restassured.response.Response;
import schemas.email.EmailDto;

public class EmailApi extends ApiBase {
    Response response;
    EmailDto dto;

    public EmailDto randomDataForEmail(Integer contactId) {
        dto = new EmailDto();
        dto.setEmail("sty@gmail.com");
        dto.setContactId(contactId);
        return dto;
    }

    public EmailDto randomDataForAddEmail(Integer emailId,Integer contactId) {
        dto = new EmailDto();
        dto.setEmail("st@gmail.com");
        dto.setContactId(contactId);
        dto.setId(emailId);
        return dto;
    }

    //создаю метод для создания имейла
    public void addEmail(Integer code, Integer contactId) {
        String endPoint = "/api/email";
        postRequest(endPoint, code, randomDataForEmail(contactId));

    //    у меня есть  метод пост, в него надо передать данные, описаные в randomDataForEmail
    }

    // метод для обновления имейла
    public void updateEmail(Integer code, Integer emailId, Integer contactId) {
        String endPoint = "/api/email";
        putRequest(endPoint, code, randomDataForAddEmail(emailId, contactId));
    }

    // удаляю имейл по его ID
    public void deleteEmail(Integer code, int emailId) {
        String endpoint = "/api/email/{id}";
        deleteRequest(endpoint, code, emailId);
    }

    public Response getEmailByEmailId(Integer code, int emailId) {
        String endpoint = "/api/email/{id}";
        response = getRequestWithParam(endpoint, code,"id", emailId); //у имейла в боди приходит tmail id как "id"
        return response;
    }

    public Response getAllEmailsBycontactId(Integer code, Integer contactId){
        String endPoint = "/api/email/{contactId}/all";
        response = getRequestWithParam(endPoint, code, "contactId",contactId);
        return response;
    }

}
