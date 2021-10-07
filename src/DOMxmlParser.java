import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;

public class DOMxmlParser {
    public Library parse(String path) {
        Library library = null;
        File xmlFile = new File(path);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("Publication");

            library = new Library();
            for (int i = 0; i < nodeList.getLength(); i++) {
                library.add(getPublication(nodeList.item(i)));
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return library;
    }

    private Publication getPublication(Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            if(getTagValue("type", element).equals(Book.class.getSimpleName())) {
                return parseBook(element);
            } else if(getTagValue("type", element).equals(Newspaper.class.getSimpleName())) {
                return parseNewspaper(element);
            } else if(getTagValue("type", element).equals(Magazine.class.getSimpleName())) {
                return parseMagazine(element);
            }
        }
        return null;
    }

    private Book parseBook(Element element) {
        Book book = new Book();
        book.setAuthor(getTagValue("author", element));
        book.setCirculation(Integer.parseInt(getTagValue("circulation", element)));
        book.setCountPage(Integer.parseInt(getTagValue("countPage", element)));
        book.setTitle(getTagValue("title", element));
        book.setGenre(getTagValue("genre", element));
        return book;
    }

    private Newspaper parseNewspaper(Element element) {
        Newspaper newspaper = new Newspaper();
        newspaper.setEditor(getTagValue("editor", element));
        newspaper.setCirculation(Integer.parseInt(getTagValue("circulation", element)));
        newspaper.setCountPage(Integer.parseInt(getTagValue("countPage", element)));
        newspaper.setTitle(getTagValue("title", element));
        return newspaper;
    }

    private Magazine parseMagazine(Element element) {
        Magazine magazine = new Magazine();
        magazine.setEditor(getTagValue("editor", element));
        magazine.setCirculation(Integer.parseInt(getTagValue("circulation", element)));
        magazine.setCountPage(Integer.parseInt(getTagValue("countPage", element)));
        magazine.setTitle(getTagValue("title", element));
        return magazine;
    }

    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public void addNewBook(Book book) throws Exception {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse("library.xml");
        Node root = document.getDocumentElement();
        Element publication = document.createElement("Publication");

        Element type = document.createElement("type");
        Element author = document.createElement("author");
        Element title = document.createElement("title");
        Element circulation = document.createElement("circulation");
        Element countPage = document.createElement("countPage");
        Element genre = document.createElement("genre");

        type.setTextContent(book.getClass().getSimpleName());
        author.setTextContent(book.getAuthor());
        title.setTextContent(book.getTitle());
        circulation.setTextContent(String.valueOf(book.getCirculation()));
        countPage.setTextContent(String.valueOf(book.getCountPage()));
        genre.setTextContent(book.getGenre());

        publication.appendChild(type);
        publication.appendChild(author);
        publication.appendChild(title);
        publication.appendChild(circulation);
        publication.appendChild(countPage);
        publication.appendChild(genre);

        root.appendChild(publication);

        writeDocument(document);
    }

    public void addNewPeriodicalEdition(PeriodicalEdition periodicalEdition) throws Exception {
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse("library.xml");
        Node root = document.getDocumentElement();
        Element publication = document.createElement("Publication");

        Element type = document.createElement("type");
        Element editor = document.createElement("editor");
        Element title = document.createElement("title");
        Element circulation = document.createElement("circulation");
        Element countPage = document.createElement("countPage");

        type.setTextContent(periodicalEdition.getClass().getSimpleName());
        editor.setTextContent(periodicalEdition.getEditor());
        title.setTextContent(periodicalEdition.getTitle());
        circulation.setTextContent(String.valueOf(periodicalEdition.getCirculation()));
        countPage.setTextContent(String.valueOf(periodicalEdition.getCountPage()));

        publication.appendChild(type);
        publication.appendChild(editor);
        publication.appendChild(title);
        publication.appendChild(circulation);
        publication.appendChild(countPage);

        root.appendChild(publication);

        writeDocument(document);
    }

    private static void writeDocument(Document document) {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("library.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
}