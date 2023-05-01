package api.phone;

import api.ApiBase;
import io.restassured.response.Response;
import schemas.phone.PhoneDto;

public class PhoneApi extends ApiBase {
    Response response;
    PhoneDto dto;

    public PhoneDto randomDataForCreatePhone(Integer contactId) {
        dto = new PhoneDto();
        dto.setCountryCode("+49");
        dto.setPhoneNumber("15487789652");
        dto.setContactId(contactId);
        return dto;
    }

    public PhoneDto randomDataForExistingPhone(Integer phoneId,Integer contactId) {
        dto = new PhoneDto();
        dto.setCountryCode("+49");
        dto.setPhoneNumber("15487789652");
        dto.setContactId(contactId);
        dto.setId(phoneId);
        return dto;
    }

    public void createPhone(Integer code, Integer contactId) {
        String endPoint = "/api/phone";
        postRequest(endPoint, code, randomDataForCreatePhone(contactId));

    }

    public void updatePhone(Integer code, Integer phoneId, Integer contactId) {
        String endPoint = "/api/phone";
        putRequest(endPoint, code, randomDataForExistingPhone(phoneId,contactId));
    }

    public void deletePhone(Integer code, int phoneId) {
        String endpoint = "/api/phone/{id}";
        deleteRequest(endpoint, code, phoneId);
    }

    public Response getCreatedPhoneByPhoneId(Integer code, int phoneId) {
        String endpoint = "/api/phone/{id}";
        response = getRequestWithParam(endpoint, code, "id", phoneId);
        return response;
    }

    public Response getAllPhoneByContactId(Integer code,Integer contactId) {
        String endPoint = "/api/phone/{contactId}/all";
        response = getRequestWithParam(endPoint, code, "contactId", contactId);
        return response;
    }
}
