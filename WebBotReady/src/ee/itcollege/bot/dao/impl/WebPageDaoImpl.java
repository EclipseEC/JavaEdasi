package ee.itcollege.bot.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import ee.itcollege.bot.dao.WebPageDao;
import ee.itcollege.bot.entity.WebPage;

public class WebPageDaoImpl extends AbstractDaoImpl<WebPage> implements WebPageDao {

	public WebPageDaoImpl() {
		super(WebPage.class);
	}

	@Override
	public WebPage findByUrl(String url) {
		TypedQuery<WebPage> query = em.createQuery("select e from WebPage e where e.url=:url", WebPage.class);
		query.setParameter("url", url);
		try {
			return query.getSingleResult();
		}
		catch (NoResultException e) {
			return null;
		}
	}

}
