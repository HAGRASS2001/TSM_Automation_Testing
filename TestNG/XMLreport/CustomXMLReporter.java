package XMLreport;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.util.List;
import java.util.Map;

public class CustomXMLReporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        // Create an XML document to store the test results
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            return;
        }
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("TestResults");
        doc.appendChild(rootElement);

        // Loop through all the test suites
        for (ISuite suite : suites) {
            // Get the suite name and other suite information if needed
            String suiteName = suite.getName();

            // Get the results of the current suite
            Map<String, ISuiteResult> suiteResults = suite.getResults();

            // Loop through the test results of the suite
            for (ISuiteResult suiteResult : suiteResults.values()) {
                ITestContext testContext = suiteResult.getTestContext();

                // Get the test name and other test context information if needed
                String testName = testContext.getName();

                // Get the test result details
                int totalTests = testContext.getAllTestMethods().length;
                int passedTests = testContext.getPassedTests().size();
                int failedTests = testContext.getFailedTests().size();
                int skippedTests = testContext.getSkippedTests().size();

                // Create a test result element and add details as attributes
                Element testResultElement = doc.createElement("TestResult");
                testResultElement.setAttribute("SuiteName", suiteName);
                testResultElement.setAttribute("TestName", testName);
                testResultElement.setAttribute("TotalTests", String.valueOf(totalTests));
                testResultElement.setAttribute("PassedTests", String.valueOf(passedTests));
                testResultElement.setAttribute("FailedTests", String.valueOf(failedTests));
                testResultElement.setAttribute("SkippedTests", String.valueOf(skippedTests));

                // Add the test result element to the root element
                rootElement.appendChild(testResultElement);
            }
        }

        // Write the XML document to a file
        String outputFileName = "custom_test_results.xml";
        File outputFile = new File(outputDirectory, outputFileName);
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(outputFile);
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        System.out.println("CustomXMLReporter: XML report generated at " + outputFile.getAbsolutePath());
    }
}