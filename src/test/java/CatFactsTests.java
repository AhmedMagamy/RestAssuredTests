import catsApis.CatsApis;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import org.testng.annotations.Test;
import utilites.*;

@Listeners(utilites.ReportsGenerator.class)
public class CatFactsTests {


    @Test
    public void getOneRandomCatFact(){

        //call the Api and pass the parameters
        Response res = CatsApis.getFacts("cat" , "1");
        // log the status code to the report
        ReportsGenerator.log("The Status code = "+String.valueOf(res.getStatusCode()));
        //log the response to the report
        ReportsGenerator.log("The response = "+res.asPrettyString());
        //read the random fact text
        String catFactMessage = res.jsonPath().getString("text") ;
        //log the fact to the report
        ReportsGenerator.log("The fact is  = "+catFactMessage);
        //verify it's not empty
        Assert.assertTrue(!catFactMessage.isEmpty());



    }


}
