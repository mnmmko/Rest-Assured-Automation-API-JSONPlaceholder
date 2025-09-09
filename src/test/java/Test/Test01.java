package Test;

import javafx.scene.layout.Priority;
import org.testng.annotations.Test;

public class Test01 extends BaseTest{
    public String newPost = "{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 7 }";
    String updatedPost = "{ \"id\": 66, \"title\": \"updated title\", \"body\": \"updated body\", \"userId\": 1 }";
    String patchBody = "{ \"title\": \"patched title\" }";
    @Test(priority=0)
    public void vertify_data_gets(){
        setGetresponse("userId",7,"/posts","");
    }

    @Test(priority = 1,dependsOnMethods = "vertify_data_gets")
    public void vertify_data_posts(){
        setPostresponse(newPost,"/posts");
    }

    @Test(priority = 2,dependsOnMethods = "vertify_data_posts")
    public void vertify_data_put(){
        setPutresponse(updatedPost,"/posts/7");
    }

    @Test(priority = 3,dependsOnMethods = "vertify_data_put")
    public void vertify_data_patch(){
        setPatchresponse(patchBody,"/posts/7");
    }

    @Test(priority = 4,dependsOnMethods = "vertify_data_patch",groups = "Test01")
    public void vertify_data_delete(){
        setDeleteresponse("/posts/1");
    }
}
