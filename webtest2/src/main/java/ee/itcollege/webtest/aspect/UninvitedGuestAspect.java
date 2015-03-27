package ee.itcollege.webtest.aspect;

import java.util.ArrayList;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import ee.itcollege.webtest.entity.Person;

@Aspect
@Service
public class UninvitedGuestAspect {
	@Pointcut("execution(public List getAll()")
	public void getAll() {
		
	}
	
	@Pointcut("within(ee.itcollege.webtest.dao)")
	public void dao() {
		
	}
	
	@Around("execution(public * ee.itcollege.webtest.dao.AbstractDaoImpl.getAll())")
	public Object uninvite(ProceedingJoinPoint jp) throws Throwable {
		
		System.out.println("dao getAll pointcut käivitus");
		ArrayList<Person> persons = (ArrayList<Person>) jp.proceed();
		
		if (Math.random() > .7) {
			Person mati = new Person();
			mati.setName("Mati");
			persons.add(mati);
		}
		
		return persons;
		//		return jp.proceed();
	}
}
