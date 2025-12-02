package com.ui.listners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyListners implements IRetryAnalyzer {
	private static final int MAX_RETRY = 1;
	private static int current_try = 1;

	@Override
	public boolean retry(ITestResult result) {
		if (current_try <= MAX_RETRY) {
			current_try++;
			return true;

		}
		return false;
	}

}
