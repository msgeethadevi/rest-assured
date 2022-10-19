package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class putPatchDelete {

    //@Test
    public void testPut() {
        JSONObject request = new JSONObject();
        request.put("name", "Ashank");
        request.put("job", "trainer");

        System.out.println(request.toJSONString());
        baseURI = "https://reqres.in/api";

        given().
                header("Content-Type", "application/json").
                contentType(io.restassured.http.ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).
                log().
                all();
    }

    //@Test
    public void testPatch() {
        JSONObject request =new JSONObject();
        request.put("name","Ashank");
        request.put("job","trainer");

        System.out.println(request.toJSONString());
        baseURI = "https://reqres.in";

        given().
                header("Content-Type","application/json").
                contentType(io.restassured.http.ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/api/users/2").
                then().
                statusCode(200).
                log().
                all();
    }

    @Test
    public void testDelete(){
        baseURI = "https://reqres.in";
        when().delete("/api/users/2").
                then().statusCode(204).log().all();

    }
}
