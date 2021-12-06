package XMLTaskF6MYAZ.DOMParseF6MYAZ.src.hu.domparse.F6MYAZ;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMModifyF6MYAZ {
    public static void main(String arg[])
            throws SAXException, IOException, ParserConfigurationException, XPathExpressionException,
            TransformerException {
        // Get file
        File inputXMLFile = new File("XMLTaskF6MYAZ/XMLF6MYAZ.xml");
        File outputXMLFile = new File("XMLTaskF6MYAZ/XMLF6MYAZ_output.xml");

        // Get DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        // Parse docuement and normalize
        Document doc = dBuilder.parse(inputXMLFile);
        doc.getDocumentElement().normalize();

        // Build XPath tree
        XPath xPath = XPathFactory.newDefaultInstance().newXPath();

        // Get all orvos
        String expression = "//orvos";

        // NodeList declaration
        NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeList.item(i);
                if (element.getAttribute("orvos_id").equals("o1")) {
                    element.getElementsByTagName("nev").item(0).setTextContent("Új név");
                }
            }
        }

        // Write to file and console
        modify(doc, outputXMLFile);

    }

    private static void modify(Document doc, File outputFile)
            throws TransformerException, UnsupportedEncodingException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transf = transformerFactory.newTransformer();
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amunt", "2");

        DOMSource source = new DOMSource(doc);

        StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(outputFile);

        transf.transform(source, console);
        transf.transform(source, file);
    }
}