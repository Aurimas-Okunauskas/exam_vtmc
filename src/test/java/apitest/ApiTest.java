package apitest;

import basetest.BaseApiTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import org.hamcrest.Matcher.*;
import org.hamcrest.CoreMatchers.*;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.Matchers.is;

public class ApiTest extends BaseApiTest {




    String usersEndpoint = "public-api/users";
    String postsEndpoint = "public-api/posts";

    @Test
    public void apiTest() {

        HashMap user = new HashMap<>();
        user.put("name", "Billy Bob");
        user.put("email", randomAlphabetic(10) + "@billy.com");
        user.put("gender", "male");
        user.put("status", "active");



        // CREATE USER //
        int userID = given().
                spec(reqSpec).
                body(user).
        when().
                post(usersEndpoint).
        then().
                assertThat().
                body("code", is(201)).
                extract().
                path("data.id");

        HashMap newPost = new HashMap<>();

        newPost.put("user_id", userID);
        newPost.put("title", "Hello");
        newPost.put("body", randomAlphabetic(10));


        // CREATE NEW POST //

       int postID = given().
                spec(reqSpec).
                body(newPost).
        when().
                post(postsEndpoint).
        then().
                assertThat().
                body("code", is("201")).
               extract().
               path()

        // GET NEWLY CREATED POST //

        given().
                spec(reqSpec).
                pathParams("id", "1303").
        when().
                get(postsEndpoint).
        then().
                assertThat().
                body("c")

    }

}
