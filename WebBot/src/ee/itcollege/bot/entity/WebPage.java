package ee.itcollege.bot.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Index;

@Entity
public class WebPage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Index(name="url_index")
    @Column(nullable = false)
    private String url;
    
    @Column(nullable = false)
    private Date lastVisited;
    
    @OneToMany
    private Set<EmailAddress> emailAdresses;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getLastVisited() {
		return lastVisited;
	}

	public void setLastVisited(Date lastVisited) {
		this.lastVisited = lastVisited;
	}

	public Set<EmailAddress> getEmailAdresses() {
		return emailAdresses;
	}

	public void setEmailAdresses(Set<EmailAddress> emailAdresses) {
		this.emailAdresses = emailAdresses;
	}
}
