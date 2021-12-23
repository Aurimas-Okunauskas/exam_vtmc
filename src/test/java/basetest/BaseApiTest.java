package basetest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

import java.util.Arrays;

public class BaseApiTest {

    protected static RequestSpecification reqSpec;

    @BeforeSuite
    public static void setUp() {
        String token = "b63f6b86db42e995e9577019bf32ffadc77f930f956f1f4bd14a3729e8d2caf1";
        reqSpec = new RequestSpecBuilder().
                setBaseUri("https://gorest.co.in/").
                setContentType(ContentType.JSON).
                addHeader("Authorization", "Bearer " + token).
                addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter())).
                build();
    }

}
