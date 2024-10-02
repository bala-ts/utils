package com.tsb.html;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParserExample {
	 Document document;
    public static void main(String[] args) {
    	(new HtmlParserExample()).readHtml();
    }
    private void readHtml() {
        String html = "<html>"
                    + "<head><title>Sample Page</title></head>"
                    + "<body>"
                    + "<div class='content'>Hello World</div>"
                    + "<div class='content'>Java HTML Parser</div>"
                    + "<p>This is a sample paragraph.</p>"
                    + "<p>Another paragraph with <strong>important</strong> information.</p>"
                    + "</body></html>";

        // Parse the HTML string
         document = Jsoup.parse(html);

        // Extract specific content based on tag or class
        // Example: Extract all <div> elements with class 'content'
        Elements contentDivs = document.select("div.content");
        for (Element div : contentDivs) {
            System.out.println("Div Content: " + div.text());
        }

        // Extract <p> elements and check if they contain specific words
        Elements paragraphs = document.select("p");
        for (Element paragraph : paragraphs) {
            if (paragraph.text().contains("important")) {
                System.out.println("Important paragraph: " + paragraph.text());
            }
        }
    }
}
