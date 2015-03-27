package ee.itcollege.bot.dao;

import ee.itcollege.bot.entity.EmailAddress;

public interface EmailAddressDao extends AbstractDao<EmailAddress> {

	public EmailAddress findByEmail(String address);
}
