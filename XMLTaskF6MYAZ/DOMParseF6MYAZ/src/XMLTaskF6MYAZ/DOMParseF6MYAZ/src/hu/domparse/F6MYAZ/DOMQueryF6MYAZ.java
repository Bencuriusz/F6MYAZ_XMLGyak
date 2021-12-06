package XMLTaskF6MYAZ.DOMParseF6MYAZ.src.hu.domparse.F6MYAZ;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMQueryF6MYAZ {
    public static void main(String arg[])
            throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
        // Get file
        File xmlFile = new File("XMLTaskF6MYAZ/XMLF6MYAZ.xml");

        // Get DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        // Parse docuement and normalize
        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        // Build XPath tree
        XPath xPath = XPathFactory.newDefaultInstance().newXPath();

        // Get all páciens born after 1980
        String expression = "//paciens[number(translate(szuletesi_ido, '-', '')) > 19800101]";

        // NodeList declaration
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("paciens")) {
                Element element = (Element) node;

                System.out.println("Tajszám: " + element.getAttribute("taj_szam"));
                System.out.println("Páciens ID: " + element.getAttribute("paciens_id"));
                System.out.println("Időpont ID: " + element.getAttribute("idopont_id"));
                System.out.println("Név: " + element.getElementsByTagName("nev").item(0).getTextContent());
                System.out.println("Email: " + element.getElementsByTagName("email_cim").item(0).getTextContent());
                System.out.println("Jelszó: " + element.getElementsByTagName("jelszo").item(0).getTextContent());
                System.out.println(
                        "Születési Idő: " + element.getElementsByTagName("szuletesi_ido").item(0).getTextContent());
                System.out.println(
                        "Születési hely: " + element.getElementsByTagName("szuletesi_hely").item(0).getTextContent());
                System.out.println(
                        "Születési hely: " + element.getElementsByTagName("szuletesi_ido").item(0).getTextContent());
                System.out.println("Lakcím:");
                System.out.println("Város: " + element.getElementsByTagName("varos").item(0).getTextContent());
                System.out
                        .println("Város: " + element.getElementsByTagName("utca_es_hazszam").item(0).getTextContent());
                System.out.println("Város: " + element.getElementsByTagName("iranyitoszam").item(0).getTextContent());
            }
        }
    }
}