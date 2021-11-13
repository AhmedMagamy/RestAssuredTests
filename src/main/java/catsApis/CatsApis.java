package catsApis;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import static io.restassured.RestAssured.*;

public class CatsApis {




    //get the response of cat facts api
    public static Response getFacts(String animal ,String amount){

        Response res = given()
                .param("animal_type", animal)
                .param("amount", amount)
                .when()
                .get("https://cat-fact.herokuapp.com/facts/random")
                .then().extract().response();

        return res;

    }
}
