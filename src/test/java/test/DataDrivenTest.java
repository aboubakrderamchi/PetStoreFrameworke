package test;

import endpoints.UserEndPointFromPropertiesFile;
import payload.User;
import utilities.BasedDataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTest {
     @Test(priority = 1,dataProvider = "Data",dataProviderClass = BasedDataProviders.class)
    public void testPostUser(String userID, String userName,String fname,String lname,String useremail,String pwd,String ph){

       User userPayload = new User();
         userPayload.setId(Integer.parseInt(userID));
         userPayload.setUsername(userName);
         userPayload.setFirstName(fname);
         userPayload.setLastName(lname);
         userPayload.setEmail(useremail);
         userPayload.setPassword(pwd);
         userPayload.setPhone(ph);

       Response response = UserEndPointFromPropertiesFile.createUser(userPayload);
       Assert.assertEquals(response.getStatusCode(),200);
    }
     @Test(priority = 2,dataProvider = "UserNames",dataProviderClass = BasedDataProviders.class)
    public void testDeleUserByName(String userName){

     Response response =  UserEndPointFromPropertiesFile.deleteUser(userName);
      Assert.assertEquals(response.getStatusCode(),200);


    }
}
