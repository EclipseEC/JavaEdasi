package ee.itcollege.bot;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ee.itcollege.bot.entity.EmailAddress;
import ee.itcollege.bot.entity.WebPage;
import ee.itcollege.bot.service.EmailAddressService;
import ee.itcollege.bot.service.WebPageService;

public class StartBot {
	
	@Autowired
	EmailAddressService addressService;
	
	@Autowired
	WebPageService webPageService;
	
	public List<String> getEmails(Document document) {
		Elements links = document.select("a");
		List<String> result = new LinkedList<>();
		for (Element link : links) {
			String href = link.attr("href");
			if (href.startsWith("mailto:")) {
				result.add(href.substring(7));
			}
		}
		return result;
	}
	
	public void crawl(String url, int depth) {
		if (depth > 10) {
			return;
		}
		
		WebPage page = webPageService.findPage(url);
		
		if (page == null) {
			page = new WebPage();
			page.setUrl(url);
			page.setLastVisited(new Date());
			
			page = webPageService.save(page);
		}
		else {
			if (depth > 0) {
				return;
			}
		} 
		
		System.out.println(url);
		
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			
			List<String> emails = getEmails(doc);
			
			for (String email : emails) {
				if (!addressService.isEmailKnown(email)) {
					System.err.println("EMAIL: " + email);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					EmailAddress address = new EmailAddress();
					address.setAddress(email);
					address.setWebPage(page);
					addressService.save(address);
				} 
			}
			
			Elements links = doc.select("a"); // CSS selector
			
			for (Element e : links) {
				String foundUrl = e.absUrl("href");
				crawl(foundUrl, depth + 1);
			}
			
		} catch (Exception e) {
			System.out.println("viga: " + url);
			//e.printStackTrace();
		}
	}


	public static void main(String[] args) {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		StartBot bot = ctx.getBean(StartBot.class);
		bot.crawl("http://neti.ee", 0);
		ctx.close();
	}

}
