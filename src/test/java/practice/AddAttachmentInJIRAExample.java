package practice;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;


public class AddAttachmentInJIRAExample {
	static ValidatableResponse res;
	@Test
	public void validateCustomerAPIWithValidSecretKey() {
		addAttachment("SJ-25","azhar.sqa@gmail.com","omszbFmHlIeITudt8a5wDB5F", "./azhar.txt");
		/*
		
		String issueId="SJ-25";
		 RestAssured.authentication= RestAssured.preemptive().basic("azhar.sqa@gmail.com","omszbFmHlIeITudt8a5wDB5F");
	        Response res =RestAssured.given().header("X-Atlassian-Token","no-check").multiPart(new File("./azhar.txt"))
	                .post("https://jira-selenium.atlassian.net/rest/api/3/issue/"+issueId+"/attachments");
	        */
	}
	

	public static ValidatableResponse addAttachment(String issueId,String username,String token,String filepath) {
		try {
			 RestAssured.authentication= RestAssured.preemptive().basic(username,token);
			 res =RestAssured.given().header("X-Atlassian-Token","no-check").multiPart(new File(filepath))
		                .post("https://jira-selenium.atlassian.net/rest/api/3/issue/"+issueId+"/attachments").then().log().all();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return res;
	}
	

}
