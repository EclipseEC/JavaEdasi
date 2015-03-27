package ee.itcollege.bot;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ee.itcollege.bot.service.EmailAddressService;

public class StartBot {
	
	@Autowired
	EmailAddressService addressService;
	
	public void start() {
		Document doc;
		try {
			doc = Jsoup.connect("http://en.wikipedia.org/").get();
			Elements links = doc.select("a"); // CSS selector
			
			for (Element e : links) {
				String attr = e.absUrl("href");
				
				System.out.println(attr + "->" + e.text());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		StartBot bot = ctx.getBean(StartBot.class);
		bot.start();
		ctx.close();
	}

}
