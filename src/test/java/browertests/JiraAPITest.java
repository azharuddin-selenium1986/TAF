package browertests;

import java.io.File;

import io.restassured.RestAssured;

public class JiraAPITest {
	
	public static void main(String[] args) {
		 RestAssured.baseURI = "https://jira-selenium.atlassian.net";
	        RestAssured.authentication = RestAssured.preemptive().basic("azhar.sqa@gmail.com", "omszbFmHlIeITudt8a5wDB5F");
	        File attachment = new File("azhar.txt");
	        RestAssured.given().header("Content-Type","multipart/form-data").header("X-Atlassian-Token", "nocheck").and().multiPart(attachment).when().post("/rest/api/3/issue/SJ-9/attachments")
	        .then().log().all().assertThat().statusCode(200);
	}

}
