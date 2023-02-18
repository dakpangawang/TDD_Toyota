package toyota.tdd.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer{

	int limit = 2;
	int alreadyTired = 0;
	
	@Override
	public boolean retry(ITestResult result) {
		if (alreadyTired < limit) {
			alreadyTired++;
			return true;
		}
		return false;
	}

}
