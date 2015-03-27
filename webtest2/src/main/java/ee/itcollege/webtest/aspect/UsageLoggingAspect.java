package ee.itcollege.webtest.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class UsageLoggingAspect {
	
	private static final Logger LOG
		= Logger.getLogger(UsageLoggingAspect.class);

	@Pointcut("@annotation(ee.itcollege.webtest.annotations.LogUsage)")
	public void logged() {}

	@Before("logged()")
	public void logUsage(JoinPoint jp) {
	    LOG.warn(String.format("LOG USAGE: %s();",
	    		jp.getSignature().getName()));
	}
	
}