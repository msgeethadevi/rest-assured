package tests;


import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

public class testOnJsonServer {

    //@Test
    public void get(){
      baseURI = "http://localhost:3000";
        // to get this uri run "json-server --watch db.json" in command prompt
      given().
              get("/users").
              then().statusCode(200).log().all();

    }

    //@Test
    public void postInUsers(){   // post is to insert data to the server
        baseURI = "http://localhost:3000";
        JSONObject write=new JSONObject();

        write.put("firstName","Saurav");
        write.put("lastName","sarkar");
        write.put("subjectId",1);

        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(write.toJSONString()).
                when()
                .post("/users").
                then().
                statusCode(201).log().all();
    }

    //@Test
    public void postInSubject(){
        baseURI = "http://localhost:3000";
        JSONObject writeSubject=new JSONObject();

        writeSubject.put("name","software Testing");
        writeSubject.put("id", 3);

        given().contentType(ContentType.JSON).accept(ContentType.JSON).body(writeSubject.toJSONString()).
                when().post("/subjects").
                then().statusCode(201).log().all();
    }

    //@Test
    public void put(){
        baseURI = "http://localhost:3000";
        JSONObject write=new JSONObject();

        write.put("firstName","Santhosh");
        write.put("lastName","sarkar");
        write.put("subjectId",2);

        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(write.toJSONString()).
                when()
                //using put we can update the data
                .put("/users/4").
                then().
                statusCode(200);
    }
    //@Test
    public void patch(){
        baseURI = "http://localhost:3000";
        JSONObject write=new JSONObject();

        write.put("firstName","shivalinge");
        write.put("lastName","gowda");


        given().contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(write.toJSONString()).
                when()
                //using patch we can update the data
                .patch("/users/4").
                then().
                statusCode(200);
    }
    @Test
    public void delete(){
        baseURI = "http://localhost:3000";
        when().delete("/users/5").then().statusCode(404);
    }
}
