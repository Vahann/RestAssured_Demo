package business;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

public final class RequestUtil {

    private RequestUtil(){}

    public static ValidatableResponse get(String endpoint){
        return RestAssured
                .given()
                .when()
                .get(endpoint)
                .then();
    }
    public static ValidatableResponse post (String endpoint, Object body){
        return RestAssured
                .given()
//                .header("Authorization",
//                        "Bearer b48dd4cd8fec67f6180f58aa2552df10d7c4df33908771a1cebc000cc34b262f")
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
                .spec(getRequestSpecification())
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .spec(getResponseSpecification());
    }

    private static RequestSpecification getRequestSpecification(){
        RequestSpecBuilder spec = new RequestSpecBuilder();
        return spec
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("Authorization","Bearer 0aabb9e837ba3c6128bae54b691f80e3dd6ecda9a0c71773631974359c3d8e7c")
                .build();
    }
    private static ResponseSpecification getResponseSpecification(){
        ResponseSpecBuilder specBuilder = new ResponseSpecBuilder();

        return specBuilder
                .expectResponseTime(Matchers.lessThan(10L),TimeUnit.SECONDS)
//                .expectStatusCode(Matchers.anyOf(200,300)
                .build();

    }
}
