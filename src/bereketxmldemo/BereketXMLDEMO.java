/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bereketxmldemo;

/**
 *
 * @author Bereket
 */

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class BereketXMLDEMO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
         File inputFile = new File("database.xml");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder;

         dBuilder = dbFactory.newDocumentBuilder();

         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();

         XPath xPath =  XPathFactory.newInstance().newXPath();

         String expression = "/class/student";	        
         NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
            doc, XPathConstants.NODESET);

         for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.print("Student roll no :" + eElement.getAttribute("rollno"));
               System.out.print(" First Name : " 
                  + eElement
                  .getElementsByTagName("firstname")
                  .item(0)
                  .getTextContent());
               System.out.print(" Last Name : " 
                  + eElement
                  .getElementsByTagName("lastname")
                  .item(0)
                  .getTextContent());
               System.out.print(" Nick Name : " 
                  + eElement
                  .getElementsByTagName("nickname")
                  .item(0)
                  .getTextContent());
               System.out.print(" Marks : " 
                  + eElement
                  .getElementsByTagName("marks")
                  .item(0)
                  .getTextContent()
                  + "\n");
            }
         }
         
         
         
         
         expression = "/class/teacher";	        
         nodeList = (NodeList) xPath.compile(expression).evaluate(
            doc, XPathConstants.NODESET);

         for (int i = 0; i < nodeList.getLength(); i++) {
            Node nNode = nodeList.item(i);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.print("Teacher roll no :" + eElement.getAttribute("rollno"));
               System.out.print(" First Name : " 
                  + eElement
                  .getElementsByTagName("firstname")
                  .item(0)
                  .getTextContent());
               System.out.print(" Last Name : " 
                  + eElement
                  .getElementsByTagName("lastname")
                  .item(0)
                  .getTextContent());
               System.out.print(" Nick Name : " 
                  + eElement
                  .getElementsByTagName("nickname")
                  .item(0)
                  .getTextContent());
               System.out.print(" Rating : " 
                  + eElement
                  .getElementsByTagName("rating")
                  .item(0)
                  .getTextContent()
                  + "\n");
            }
         }
         
         
         
         
         
         
         
      } catch (ParserConfigurationException e) {
         e.printStackTrace();
      } catch (SAXException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (XPathExpressionException e) {
         e.printStackTrace();
      }
        
    }
    
}
