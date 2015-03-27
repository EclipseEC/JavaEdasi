package ee.itcollege.bot.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class HibernateConfiguration {


    @Bean
    public DataSource dataSource() {
    	ComboPooledDataSource ds = new ComboPooledDataSource();
    	try {
			ds.setDriverClass("org.h2.Driver");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
    	ds.setJdbcUrl("jdbc:h2:~/db/web-bot");
    	ds.setMinPoolSize(3);
    	ds.setMaxPoolSize(10);
    	
    	return ds;    
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan(new String[]{"ee.itcollege.bot"});       
        HibernateJpaVendorAdapter hibernateAdapter = new HibernateJpaVendorAdapter();
        hibernateAdapter.setGenerateDdl(true);
        emf.setJpaVendorAdapter(hibernateAdapter);
        return emf;
    }
    
    @Bean
    public DataSourceTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
    
    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }    
    
}
