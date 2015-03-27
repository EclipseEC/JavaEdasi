package ee.itcollege.bot.service;

import ee.itcollege.bot.entity.EmailAddress;

public interface EmailAddressService {

	public boolean isEmailKnown(String address);

	public void save(EmailAddress address);	
	
}
