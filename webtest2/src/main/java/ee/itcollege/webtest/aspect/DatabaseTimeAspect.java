package ee.itcollege.webtest.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import ee.itcollege.webtest.entity.Person;

@Aspect
@Service
public class DatabaseTimeAspect {
	public static final Logger LOG = Logger.getLogger("performance");

	@Around("execution(public * ee.itcollege.webtest.dao.*.*(..))")
	public Object queryTime(ProceedingJoinPoint jp) {

		long time = System.currentTimeMillis();
		try {
			return jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			long newTime = System.currentTimeMillis();
			if (newTime - time > 100)
			LOG.warn(String.format("%s(); // %dms\n", jp.getTarget().getClass()
					.getName(), newTime - time));
		}
		return null;
	}
}
