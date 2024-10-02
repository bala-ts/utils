package com.tsb.html;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebpageReader {
	
	 Document document;
    public static void main(String[] args) {
			(new WebpageReader()).search("281295");
		
    }
	    
	private int getTotalPage() { 
		String PAGE_ID = "Page: 1 of ";
		String s= PAGE_ID;
        int pageIndex =  document.toString().indexOf(s);
        return (pageIndex != -1)? 
     	 Integer.parseInt((document.toString().substring(pageIndex, s.length() + pageIndex + 2)).replace(PAGE_ID, "").trim())
         : null;
        
	}
    public void search(String dob){
        int page=1;
    	int totalPages=0;
    	int count=0;
    	List<String> match = new ArrayList<>();
    	String search = dob;
	 	String mmdd = search.substring(2,4) + search.substring(0,2);
    	String year = search.substring(4);
   
    	do {
//    		File inputFile = new File("resources/1.txt");
    	

        	
            // Fetch the webpage
    	   String url = "https://www.bornglorious.com/india/birthday/?pd="+mmdd+"&pg=" + page; // Replace with the URL you want to read
//        System.out.println(url);
             try {
				document = Jsoup.connect(url).get();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//             document = Jsoup.parse(inputFile,"UTF-8");
         	
            if (totalPages==0 )totalPages = getTotalPage();
             
             String delim = "<h3 class=\"panel-title\">";
             document = Jsoup.parse(document.toString().replace(delim, "~"));
             String plainText = document.text();
             // Print the plain text content
             //System.out.println("Webpage Content: ");
             //System.out.println(plainText);
             
           
            
             
             String s[] = plainText.split("~");
             //s[s.length-1] = s[s.length-1].split("[Total")[0];
          
             for (String t:s) {
            	//System.out.println(++count + " " + t);
            	if( t.contains("19"+year)  || t.contains("20"+year)) match.add(t);             
             }
            page++;
//           System.out.println(page + " / " + totalPages);
        } while (page<totalPages);
        System.out.println(search + " : " + match);
    	
//             
//            // Print the title of the page
//            String title = document.title();
//            System.out.println("Title: " + title);
//            

//            System.out.println(getContent("1657"));
//            
////            Elements contentDivs = document.select("div");
////            for (Element div : contentDivs) {
//////                System.out.println("Div Content: " + div.text());
////            }
////
////            // Extract and print all the paragraphs (<p> tags) from the webpage
////            Elements paragraphs = document.select("b");
////            for (Element paragraph : paragraphs) {
////                System.out.println("Bold: " + paragraph.text());
// //           }
//
//            // Extract and print all the links (anchor <a> tags) from the webpage
////            Elements links = document.select("a[href]");
////            for (Element link : links) {
////                System.out.println("Link: " + link.attr("href") + " Text: " + link.text());
////            }

    }
}
