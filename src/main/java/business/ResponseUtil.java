package business;

import io.restassured.response.ValidatableResponse;

public final class ResponseUtil {

    private ResponseUtil() {
    }

    public static <T> T getObjectFromResponse(ValidatableResponse response, Class<T> type) {
        return response
                .extract()
                .as(type);
//        .jsonPath()
//        .getObject(path,type); // instead of .as(type) could be written like this

    }

    public static int getIntFromResponse(ValidatableResponse response, String path) {
        return response
                .extract()
                .jsonPath()
                .getInt(path);
    }

//    public static void validateResponseAgainstJsonSchema(ValidatableResponse response, String filePath){
//        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory
//                .newBuilder()
//                .setValidationConfiguration(validatationConfiguration.newBuilder)
//
//    }
}
