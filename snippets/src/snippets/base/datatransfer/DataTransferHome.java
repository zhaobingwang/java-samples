package snippets.base.datatransfer;


public class DataTransferHome {
    public static void main(String[] args) {
        System.out.println("Data Transfer ...");
        try {
            System.out.println("*****XML*****");
            System.out.println("DOM:");
            Xml.dom();
            System.out.println("SAX:");
            Xml.sax();
            System.out.println("Jackson:");
            Xml.jackson();

            System.out.println("*****Json*****");
            Json.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
