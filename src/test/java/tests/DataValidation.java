package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DataValidation {
    /**
     * Static imports:
     * In order to use Rest assured effectively, It is recommended
     *   to statically import methods:
     *      1. io.restassured.RestAssured.*;
     *      2. org.hamcrest.matchers.*;
     */
    /**
     * baseURI : A base path that is added to the baseURI by Rest assured when we are making any requests.
     * For JSON validation in the response we have to use JSON path Finder
     * for finding the proper path of the JSON response body
     */

    @Test
    public void test_data(){
        baseURI = "https://reqres.in/api";
        given().
                get("/users?page=2").
                then().
                        statusCode(200).
                body("data[1].id", equalTo(8)).
                log().
                all();

    }
}
