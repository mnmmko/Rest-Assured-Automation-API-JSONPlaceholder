package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestToken extends BaseTest{

    String authHeader = "Bearer your_api_token_here";
    String body = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }";
    String title;

    @Test(priority = 5,dependsOnGroups = "Test01")
    public void vertify_get_with_token(){
        setGetresponse("/posts/1",authHeader);
        title=getresponse.jsonPath().getString("title");
        Assert.assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit",title);
    }

    @Test(priority = 6,dependsOnMethods = "vertify_get_with_token")
    public void vertify_post_with_token(){
        setPostresponse("/posts",body,authHeader);
        Assert.assertEquals(201,postresponse.getStatusCode());
    }

}
