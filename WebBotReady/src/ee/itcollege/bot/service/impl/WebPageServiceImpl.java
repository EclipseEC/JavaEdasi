package ee.itcollege.bot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ee.itcollege.bot.dao.WebPageDao;
import ee.itcollege.bot.entity.WebPage;
import ee.itcollege.bot.service.WebPageService;

public class WebPageServiceImpl implements WebPageService {

	@Autowired
	private WebPageDao webPageDao;

	@Override
	public WebPage findPage(String url) {
		return webPageDao.findByUrl(url);
	}

	@Override
	@Transactional
	public WebPage save(WebPage page) {
		return webPageDao.persist(page);
	}

}
