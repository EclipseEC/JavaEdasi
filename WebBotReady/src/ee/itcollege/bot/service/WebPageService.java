package ee.itcollege.bot.service;

import ee.itcollege.bot.entity.WebPage;

public interface WebPageService {

	/**
	 * @param url
	 * @return null if url is not found
	 */
	public WebPage findPage(String url);

	public WebPage save(WebPage page);
	
}
