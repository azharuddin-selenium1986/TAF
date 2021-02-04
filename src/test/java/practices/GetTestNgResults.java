package practices;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GetTestNgResults {
	
	public static void main(String[] args) {
		String path = System.getProperty("user.dir")+"/target/surefire-reports/testng-results.xml";
	    File testNgResultXmlFile = new File(path);

	  	//Get Document Builder
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	    //Build Document
	    Document document = null;
		try {
			document = builder.parse(testNgResultXmlFile);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	    //Normalize the XML Structure;
	    document.getDocumentElement().normalize();
        System.out.println("###################Over All Test Results################");
	    System.out.println("Total : " + document.getDocumentElement().getAttribute("total"));
	    System.out.println("Passed : " + document.getDocumentElement().getAttribute("passed"));
	    System.out.println("Failed : " + document.getDocumentElement().getAttribute("failed"));
	    System.out.println("Skipped : " + document.getDocumentElement().getAttribute("skipped"));
	    System.out.println("###################Over All Test Results################");
	    
	    NodeList suiteName = document.getElementsByTagName("suite");
	    NodeList tests = document.getElementsByTagName("test");
		NodeList tMethods = document.getElementsByTagName("test-method");
		
		System.out.println("###################Suite Details################");
		for (int temp = 0; temp < suiteName.getLength(); temp++){
			Node node = suiteName.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE){
				Element eElement = (Element) node;
				// Get parent element to capture suite name
				System.out.println("Suite: "    + eElement.getAttribute("name"));
				// Get test case name
				System.out.println("Duration: "    + eElement.getAttribute("duration-ms"));
				// Get test case status
				System.out.println("Start Time: "    + eElement.getAttribute("started-at"));
				// Get test case duration
				System.out.println("End Time: "    + eElement.getAttribute("finished-at"));

			}
		}
		System.out.println("###################Suite Details################");
		
		System.out.println("###################Tests Details################");
		for (int temp = 0; temp < tests.getLength(); temp++){
			Node node = tests.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE){
				Element eElement = (Element) node;
				// Get parent element to capture suite name
				System.out.println("TestName: "    + eElement.getAttribute("name"));
				// Get test case name
				System.out.println("Duration: "    + eElement.getAttribute("duration-ms"));
				// Get test case status
				System.out.println("Start Time: "    + eElement.getAttribute("started-at"));
				// Get test case duration
				System.out.println("End Time: "    + eElement.getAttribute("finished-at"));

			}
		}
		System.out.println("###################Tests Details################");
		
		System.out.println("###################Test Methods Details################");
		for (int temp = 0; temp < tMethods.getLength(); temp++){
			Node node = tMethods.item(temp);
			if (node.getNodeType() == Node.ELEMENT_NODE){
				Element eElement = (Element) node;
				// Get parent element to capture suite name
				Element suiteElement = (Element) eElement.getParentNode();
				System.out.println("Class: "    + suiteElement.getAttribute("name"));
				// Get test case name
				System.out.println("Name: "    + eElement.getAttribute("name"));
				// Get test case status
				System.out.println("Status: "    + eElement.getAttribute("status"));
				// Get test case duration
				System.out.println("Duration: "    + eElement.getAttribute("duration-ms"));
				// Get exception message if exist
				Node eNode = eElement.getElementsByTagName("exception").item(0);
				Element exceptionNode = (Element) eNode;
				if (exceptionNode != null) {
					System.out.println("Error Message: "    + exceptionNode.getAttribute("class"));
				} else {
					System.out.println("Error Message: ");
				}

			}
		}
		System.out.println("###################Test Methods Details################");
	}

}
