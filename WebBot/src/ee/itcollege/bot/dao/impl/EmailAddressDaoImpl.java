package ee.itcollege.bot.dao.impl;

import javax.persistence.TypedQuery;

import ee.itcollege.bot.dao.EmailAddressDao;
import ee.itcollege.bot.entity.EmailAddress;

public class EmailAddressDaoImpl extends AbstractDaoImpl<EmailAddress>
		implements EmailAddressDao {

	public EmailAddressDaoImpl() {
		super(EmailAddress.class);
	}

	@Override
	public EmailAddress findByEmail(String address) {
		TypedQuery<EmailAddress> query = em.createQuery("select e from EmailAddress e where e.address=:address", EmailAddress.class);
		query.setParameter("address", address);
		return query.getSingleResult();
	}

}
