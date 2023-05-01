package api.address;

import api.ApiBase;
import io.restassured.response.Response;
import schemas.address.AddressDto;
import schemas.phone.PhoneDto;

public class AddressApi extends ApiBase {
    Response response;
    AddressDto dto;

    public AddressDto randomDataForCreateAddress(Integer contactId) {
        dto = new AddressDto();
        dto.setCity("Lotte");
        dto.setCountry("Germany");
        dto.setStreet("Bachstrasse 23");
        dto.setZip("49504");
        dto.setContactId(contactId);
        return dto;
    }

    public AddressDto randomDataForExistingAddress(Integer addressId,Integer contactId) {
        dto = new AddressDto();
        dto.setCity("Lotte");
        dto.setCountry("Germany");
        dto.setStreet("Bachstrasse 23");
        dto.setZip("49504");
        dto.setContactId(contactId);
        dto.setId(addressId);
        return dto;
    }

    public void createAddress(Integer code, Integer contactId) {
        String endPoint = "/api/address";
        postRequest(endPoint, code, randomDataForCreateAddress(contactId));

    }

    public void updateAddress(Integer code, Integer addressId, Integer contactId) {
        String endPoint = "/api/address";
        putRequest(endPoint, code, randomDataForExistingAddress(addressId,contactId));
    }

    public void deleteAddress(Integer code, int addressId) {
        String endpoint = "/api/address/{id}";
        deleteRequest(endpoint, code, addressId);
    }

    public Response getCreatedAddressByAddressId(Integer code, int addressId) {
        String endpoint = "/api/address/{id}";
        response = getRequestWithParam(endpoint, code, "id", addressId);
        return response;
    }

    public Response getAllAddressByContactId(Integer code,Integer contactId) {
        String endPoint = "/api/address/{contactId}/all";
        response = getRequestWithParam(endPoint, code, "contactId", contactId);
        return response;
    }

    //todo-----------------------Метод что б вытянуть addressId------------------------------------------------------------------------------------
    public Integer getAddressId(Integer contactId) {
       response = getAllAddressByContactId(200, contactId);
        int addressId = response.jsonPath().getInt("[0].id");
        return addressId;
    }
}
