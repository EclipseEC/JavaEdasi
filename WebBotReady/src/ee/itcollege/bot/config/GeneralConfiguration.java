package ee.itcollege.bot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ee.itcollege.bot.StartBot;
import ee.itcollege.bot.dao.EmailAddressDao;
import ee.itcollege.bot.dao.WebPageDao;
import ee.itcollege.bot.dao.impl.EmailAddressDaoImpl;
import ee.itcollege.bot.dao.impl.WebPageDaoImpl;
import ee.itcollege.bot.service.EmailAddressService;
import ee.itcollege.bot.service.WebPageService;
import ee.itcollege.bot.service.impl.EmailAddressServiceImpl;
import ee.itcollege.bot.service.impl.WebPageServiceImpl;

@Configuration
public class GeneralConfiguration {
	
	@Bean
	public StartBot startBot() {
		return new StartBot();
	}

	@Bean
	EmailAddressDao emailAddressDao() {
		return new EmailAddressDaoImpl();
	}
	
	@Bean
	WebPageDao webPageDao() {
		return new WebPageDaoImpl();
	}
	
	@Bean
	EmailAddressService emailAddressService() {
		return new EmailAddressServiceImpl();
	}
	
	@Bean
	WebPageService webPageService() {
		return new WebPageServiceImpl();
	}
	
}
