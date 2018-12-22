package dummyPackage;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;


public class APITest1 {

	@Test
	public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived()
	  throws ClientProtocolException, IOException {
	  
	   // Given
	   String name = RandomStringUtils.randomAlphabetic( 8 );
	   HttpUriRequest request = new HttpGet( "https://api.github.com/users/" + name );
	 
	   // When
	   HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
	 
	   // Then
	   Assert.assertNotEquals(
	     httpResponse.getStatusLine().getStatusCode(), "404");
	}
}
