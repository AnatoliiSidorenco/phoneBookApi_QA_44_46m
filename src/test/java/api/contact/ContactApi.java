package api.contact;

import api.ApiBase;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import schemas.contacts.ContactDto;

public class ContactApi extends ApiBase {
    Response response;
    ContactDto dto;
    Faker faker = new Faker();

    public ContactDto randomDataBodyForContact(){
        dto = new ContactDto();
        dto.setFirstName(faker.internet().uuid());
        dto.setLastName(faker.internet().uuid());
        dto.setDescription(faker.internet().uuid());
        return dto;
    }
    public Response createContact(Integer code){
        String endpoint = "/api/contact";
        response = postRequest(endpoint, code, randomDataBodyForContact());
        return response;
    }

    public Response getContact(Integer code, int contactId){
        String endpoint = "/api/contact/{id}";
        response = getRequestWithParam(endpoint,code,contactId);
        return response;
    }

    public void editExistingContact(Integer code){
String endpoint = "/api/contact";
   //putRequest(endpoint,code);
    }
}
