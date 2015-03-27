package ee.itcollege.bot.dao.impl;

import ee.itcollege.bot.dao.WebPageDao;
import ee.itcollege.bot.entity.WebPage;

public class WebPageDaoImpl extends AbstractDaoImpl<WebPage> implements WebPageDao {

	public WebPageDaoImpl() {
		super(WebPage.class);
	}

}
