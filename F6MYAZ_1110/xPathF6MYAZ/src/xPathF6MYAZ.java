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

public class xPathF6MYAZ {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("F6MYAZ_1110/studentF6MYAZ.xml");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = factory.newDocumentBuilder();

            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            XPath xPath = XPathFactory.newDefaultInstance().newXPath();

            // gyökér
            // String expression = "class";

            // összes elem
            // String expression = "/class/student";

            // elem ahol id=1
            // String expression = "/class/student[id=1]";

            // összes element, függetlenül attól, hogy hol vannak a dokumentumban
            // String expression = "//student";

            // második student element, amely a class elem gyermeke
            // String expression = "/class/student[position()=2]";

            // utolsó elem
            // String expression = "/class/student[last()]";

            // utolsó előtti
            // String expression = "/class/student[last()-1]";

            String expression = "";

            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                System.out.println("\nAktuális elem:" + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
                    Element element = (Element) node;

                    System.out.println("Hallgató ID: " + element.getElementsByTagName("id").item(0).getTextContent());
                    System.out.println(
                            "Vezetéknév: " + element.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println(
                            "Keresztnév: " + element.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Becenév: " + element.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Kor: " + element.getElementsByTagName("age").item(0).getTextContent());
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
