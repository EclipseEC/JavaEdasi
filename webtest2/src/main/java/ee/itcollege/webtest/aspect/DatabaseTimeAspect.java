package ee.itcollege.webtest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class DatabaseTimeAspect {
	@Before("execution(public * ee.itcollege.webtest.dao.*.*(..))")
	public void queryTime(JoinPoint jp) {
		System.out.format("käivitus %s.%s()\n", 
				jp.getTarget().getClass().getName(), 
				jp.getSignature().getName());
	}
}
