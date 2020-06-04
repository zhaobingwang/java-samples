package snippets.base.datatransfer;


import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.*;
import java.io.IOException;
import java.io.InputStream;

public class Xml {
    // 1.使用DOM
    public static void dom() throws ParserConfigurationException, IOException, SAXException {
        InputStream input = DataTransferHome.class.getResourceAsStream("book.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(input);
        Node node = doc.getFirstChild();
        System.out.println("aa");
        Xml.printNode(node, 0);
    }

    // 2.使用SAX
    public static void sax() throws ParserConfigurationException, SAXException, IOException {
        InputStream input = Xml.class.getResourceAsStream("book.xml");
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser saxParser = spf.newSAXParser();
        saxParser.parse(input, new MyHandler());
    }

    // 3.Jackson
    public static void jackson() throws IOException {
        InputStream input = Xml.class.getResourceAsStream("book.xml");
        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper mapper = new XmlMapper(module);
        Book book=mapper.readValue(input,Book.class);
        System.out.println(book.id);
        System.out.println(book.name);
        System.out.println(book.author);
        System.out.println(book.isbn);
        System.out.println(book.tags);
        System.out.println(book.pubDate);
    }

    private static void printNode(Node n, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(' ');
        }
        switch (n.getNodeType()) {
            case Node.DOCUMENT_NODE: // Document节点
                System.out.println("Document: " + n.getNodeName());
                break;
            case Node.ELEMENT_NODE: // 元素节点
                System.out.println("Element: " + n.getNodeName());
                break;
            case Node.TEXT_NODE: // 文本
                System.out.println("Text: " + n.getNodeName() + " = " + n.getNodeValue());
                break;
            case Node.ATTRIBUTE_NODE: // 属性
                System.out.println("Attr: " + n.getNodeName() + " = " + n.getNodeValue());
                break;
            default: // 其他
                System.out.println("NodeType: " + n.getNodeType() + ", NodeName: " + n.getNodeName());
        }
        for (Node child = n.getFirstChild(); child != null; child = child.getNextSibling()) {
            printNode(child, indent + 1);
        }
    }
}

class MyHandler extends DefaultHandler {
    public void startDocument() throws SAXException {
        print("start document");
    }

    public void endDocument() throws SAXException {
        print("end document");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        print("start element:", localName, qName);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        print("end element:", localName, qName);
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        print("characters:", new String(ch, start, length));
    }

    public void error(SAXParseException e) throws SAXException {
        print("error:", e);
    }

    void print(Object... objs) {
        for (Object obj : objs) {
            System.out.print(obj);
            System.out.print(" ");
        }
        System.out.println();
    }
}