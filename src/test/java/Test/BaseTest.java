package Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    public String baseurl ="https://jsonplaceholder.typicode.com";
    public Response getresponse;
    public Response postresponse;
    public Response putresponse;
    public Response patchresponse;
    public Response deleteresponse;
   @BeforeSuite
    public void setUp() {
       RestAssured.baseURI = baseurl;
   }

   public void setGetresponse(String param,int id,String parampath,String header){
       getresponse=RestAssured.given().header("Authorization",header).queryParam(param,id).when().get(parampath);
       System.out.println("GET Status Code: " + getresponse.getStatusCode());
       System.out.println("GET Response: " + getresponse.getBody().prettyPrint());
   }

   public void setPostresponse(String postbody, String parampath){
       postresponse=RestAssured.given().contentType(ContentType.JSON).body(postbody).when().post(parampath);
       System.out.println("POST Status Code: " + postresponse.getStatusCode());
       System.out.println("POST Response: " + postresponse.getBody().prettyPrint());

   }

   public void setPutresponse(String putbody, String parampath){
       putresponse=RestAssured.given().contentType(ContentType.JSON).body(putbody).when().put(parampath);
       System.out.println("PUT Status Code: " + putresponse.getStatusCode());
       System.out.println("PUT Response: " + putresponse.getBody().prettyPrint());
   }

   public void setPatchresponse(String patchebody, String parampath){
       patchresponse=RestAssured.given().contentType(ContentType.JSON).body(patchebody).when().patch(parampath);
       System.out.println("PATCH Status Code: " + patchresponse.getStatusCode());
       System.out.println("PATCH Response: " + patchresponse.getBody().prettyPrint());
   }
   public void setDeleteresponse(String parampath){
       deleteresponse=RestAssured.given().delete(parampath);
       System.out.println("DELETE Status Code: " + deleteresponse.getStatusCode());
       System.out.println("DELETE Response: " + deleteresponse.getBody().prettyPrint());
   }

   public void setGetresponse(String parampath,String header){
       getresponse=RestAssured.given().header("Authorization", header).when().get(parampath);
       System.out.println("GET Status Code: " + getresponse.getStatusCode());
       System.out.println("GET Response: " + getresponse.getBody().prettyPrint());
   }

   public void setPostresponse(String parampath,String body,String header){
       postresponse=RestAssured.given().header("Authorization", header).contentType(ContentType.JSON).body(body).when().post(parampath);
       System.out.println("POST Status Code: " + postresponse.getStatusCode());
       System.out.println("POST Response: " + postresponse.getBody().prettyPrint());
   }

}
