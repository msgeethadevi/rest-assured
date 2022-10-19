//package tests;
//
//import io.restassured.http.ContentType;
//import org.json.simple.JSONObject;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import java.util.Iterator;
//
//import static io.restassured.RestAssured.*;
//
//public class DataDrivenTesting {
//
//    /**
//     * How to run a test multiple times with different set of data in the TestNG?
//     * In testNG we have @DataProvider
//     * It helps us to write data sriven tests
//     * same test can be run multiple times with different set of data
//     * The annotated method can be used to return object containing Test data
//     * This test can be used in Actual testing
//     */
//    @DataProvider(name="posting multiple data")
//    public Object[][] dataForPost(){
//       //Matrix style: Rows & columns
////    Object[][] data=new Object[2][3];
////        data[0][0]="sachin";
////        data[0][1]="tendulkar";
////        data[0][2]=1;
////        data[1][0]="rahul";
////        data[1][1]="dravid";
////        data[1][2]=2;
//
//        // JSON method of giving data
//        return new Object[][] {
//                {"BN","Shruthi",1},
//                {"BN","mamatha",2}
//        };
//    }
//
//
//    @Test(dataProvider = "posting multiple data")
//    public void postInUsers(String firstName, String lastName, int subjectId){
//        baseURI = "http://localhost:3000";
//        JSONObject write=new JSONObject();
//
//        write.put("firstName",firstName);
//        write.put("lastName",lastName);
//        write.put("subjectId",subjectId);
//
//        given().contentType(ContentType.JSON).
//                accept(ContentType.JSON).
//                body(write.toJSONString()).
//                when()
//                .post("/users").
//                then().
//                statusCode(201).log().all();
//    }
//    @DataProvider(name="data for deleting")
//    public Object[][] dataForDelete(){
//        Object[][] sample= new Object[][]
//        return new Object[6][0];
//    }
//
//    @Test(dataProvider = "data for deleting")
//    public void testdelete(int userId){
//        baseURI = "http://localhost:3000";
//        when().delete("/users/").then().statusCode(200).log().all();
//
//        //Status code must be 200 or 204 when data is successfully deleted
//
//    }
//}
