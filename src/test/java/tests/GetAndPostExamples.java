package tests;


import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExamples {

    //@Test
    public void testGet(){

        baseURI = "https://reqres.in/api";
       given().
               get("/users?page=2").
               then().
               statusCode(200).
               // Checking if the FirstName is equal to George
               body("data[4].first_name",equalTo("George")).
               // checking if first name parameter has George & Rachel
                body("data.first_name",hasItems("George","Rachel"));
    }

    //@Test
    public void testPut_1(){
        //Basic step by step Setup using Map
        Map<String, Object> map=new LinkedHashMap<String, Object>();
        map.put("name","Geetha");
        map.put("job","Searching");
        System.out.println(map);

    }

    @Test
    public void testPut_2(){
        JSONObject request = new JSONObject();
        request.put("name","raju");
        request.put("job","trainer");
        System.out.println(request.toJSONString());

        baseURI = "https://reqres.in/api";
        given().
                /*
                Normally Rest request also has some headers
                we can tell the server what kind of data we are sending &
                what kind of data we are accepting
                'content-type'
                 */
                        // header("Content-Type","application/json").

       header("Content-Type","application/json").
                contentType(io.restassured.http.ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().
                all();




    }



}
