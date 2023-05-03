package api.email;

import api.ApiBase;
import io.restassured.response.Response;
import schemas.email.EmailDto;

public class EmailApi extends ApiBase {
    Response response;
    EmailDto dto;

    public EmailDto randomDataBodyForCreateEmail(Integer contactId) {
        dto = new EmailDto();
        dto.setEmail("sty@gmail.com");
        dto.setContactId(contactId);
        return dto;
    }

    public EmailDto randomDataBodyForEditEmail(Integer emailId, Integer contactId) {
        dto = new EmailDto();
        dto.setEmail("st@gmail.com");
        dto.setContactId(contactId);
        dto.setId(emailId);
        return dto;
    }

    //создаю метод для создания имейла
    public void createNewEmail(Integer code, Integer contactId) {
        String endPoint = "/api/email";
        postRequest(endPoint, code, randomDataBodyForCreateEmail(contactId));

    //    у меня есть метод пост, в него надо передать данные, описаные в randomDataForEmail
    }

    // метод для обновления имейла
    public void editExistingEmail(Integer code, Integer emailId, Integer contactId) {
        String endPoint = "/api/email";
        putRequest(endPoint, code, randomDataBodyForEditEmail(emailId, contactId));
    }

    // удаляю имейл по его ID
    public void deleteExistingEmail(Integer code, int emailId) {
        String endpoint = "/api/email/{id}";
        deleteRequest(endpoint, code, emailId);
    }

    public Response getEmail(Integer code, int emailId) {
        String endpoint = "/api/email/{id}";
        response = getRequestWithParam(endpoint, code,"id", emailId); //у имейла в боди приходит tmail id как "id"
        return response;
    }

    public Response getAllEmails(Integer code, Integer contactId){
        String endPoint = "/api/email/{contactId}/all";
        response = getRequestWithParam(endPoint, code, "contactId",contactId);
        return response;
    }

}
