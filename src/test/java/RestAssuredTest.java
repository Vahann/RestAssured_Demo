import business.RequestUtil;
import business.ResponseUtil;
import io.restassured.response.ValidatableResponse;
import model.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class RestAssuredTest extends BaseTest{

    public void makeGetRequest(){
        ValidatableResponse response = RequestUtil.get("users");
        Assert.assertEquals(response.extract().statusCode(), HttpStatus.SC_OK);
        System.out.println(response.extract().response().prettyPrint());
    }

    public void makePostRequest(){
        String user = User.getRandomUserAsAString();

        ValidatableResponse response = RequestUtil.post("users", user);
        response.extract().response().prettyPrint();
        Assert.assertEquals(response.extract().statusCode(),HttpStatus.SC_CREATED);
    }

    public void getObjectFromResponse(){
        ValidatableResponse response = RequestUtil.get("users/2359");
        System.out.println(response.extract().statusCode());
        User userFromResponse = ResponseUtil.getObjectFromResponse(response, User.class);
        int userId = ResponseUtil.getIntFromResponse(response,"id");
        System.out.println(userId);
        System.out.println(userFromResponse);
    }
}
