package ee.itcollege.bot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ee.itcollege.bot.dao.EmailAddressDao;
import ee.itcollege.bot.entity.EmailAddress;
import ee.itcollege.bot.service.EmailAddressService;

public class EmailAddressServiceImpl implements EmailAddressService {
	
	@Autowired
	private EmailAddressDao emailAddressDao;

	@Override
	public boolean isEmailKnown(String address) {
		EmailAddress email = emailAddressDao.findByEmail(address);
		return null != email;
	}
}
