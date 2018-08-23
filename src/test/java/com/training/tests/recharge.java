package com.training.tests;

import org.testng.annotations.Test;

import com.training.pages.DoxComLandingPage;

import AutoHackathon.Project.AutomationConstants;
import AutoHackathon.Project.DataDriver;
import AutoHackathon.Project.DataDriver.HashMapNew;
import AutoHackathon.Project.MyTestNGBaseClass;

public class recharge extends MyTestNGBaseClass {
	DataDriver oData = new DataDriver();
	HashMapNew dictionary;
	public void getData ()
	{
		
		dictionary=oData.fGetData(AutomationConstants.testDataPath + "Calendar.xlsx", "Recharge");
		
	}

	@Test
	public void verify () {
		getData ();
		oExtentTest = oExtentReport.startTest("Recharge with Cash");
		DoxComLandingPage obj= new DoxComLandingPage(oDriver, oExtentReport, oExtentTest, dictionary);
		obj.fCheckHomepage();
		obj.fSearchCustomer();
		obj.frecharge();
	}
}
