
import resources.puttty_loginHelper;
import com.rational.test.ft.*;
import com.rational.test.ft.object.interfaces.*;
import com.rational.test.ft.object.interfaces.SAP.*;
import com.rational.test.ft.object.interfaces.WPF.*;
import com.rational.test.ft.object.interfaces.dojo.*;
import com.rational.test.ft.object.interfaces.siebel.*;
import com.rational.test.ft.object.interfaces.flex.*;
import com.rational.test.ft.object.interfaces.generichtmlsubdomain.*;
import com.rational.test.ft.script.*;
import com.rational.test.ft.value.*;
import com.rational.test.ft.vp.*;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.ibm.rational.test.ft.object.interfaces.sapwebportal.*;
/**
 * Description   : Functional Test Script
 * @author ruta_dharwadkar
 */
public class puttty_login extends puttty_loginHelper
{
	/**
	 * Script Name   : <b>puttty_login</b>
	 * Generated     : <b>Sep 21, 2017 9:20:14 AM</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 6.1  Build 7601 (S)
	 * 
	 * @since  2017/09/21
	 * @author ruta_dharwadkar
	 */
	
	public int numRecords, row_number;
	 public void datapool_tuple_selection(int rownum)
	 {
		   
		    row_number = rownum;
			// Number of rows in datapool
			numRecords = dpCurrent().getEquivalenceClass().getRecordCount();
			
			if (row_number >= 0 && row_number <= numRecords)
			{
			while (dpInt("rowNumber")!= row_number){
		   	dpNext();
			}
			}
			else {
			System.out.println("The specified row is not in datapool");
			}
		 
	 }
	 
	
	public void insert_value(String classname,String textname,String value)
	{
		Property putty_class = new Property(".class",classname);
		Property putty_value = new Property(".name",textname);
		Property[] p = {putty_class,putty_value};
		TestObject[] elements = find(atDescendant(p));
		((TextGuiTestObject) elements[0]).setText(value);
		
		
	}
	
	 
	public void take_screenshot(String file_name)
	{
       try 
       {
    	  ImageIO.write(getRootTestObject().getScreenSnapshot(), "png", new File("c:\\RFT_SCCD_screenshot\\"+file_name+".png"));
			      
   
       } catch (IOException e) {}
		       
    }
	
	
	
	
	
	public void testMain(Object[] args) 
	{
		
		
		// Window: putty.exe: PuTTY Configuration
		startApp("putty");
		sleep(3);
		logInfo("Start - Login to VM Steps 50 - 52");
		
		
		//Input the VM_IPaddress
		HostIPaddress().click();
		puTTYConfigurationwindow().inputKeys(dpString("VM_IPaddress"));
		sleep(2);
		openbutton().click();
		
		//putty security alert
		yesbutton().click();
		
			
		//Input the VM_username
		sleep(2);
		PuTTYwindow().inputKeys(dpString("VM_username"));
		//PuTTYwindow().inputKeys("{ENTER}");
		getScreen().inputKeys("{ENTER}");
		
		//Input the VM_password
		PuTTYwindow().inputKeys(dpString("VM_password"));
		//PuTTYwindow().inputKeys("{ENTER}");
		getScreen().inputKeys("{ENTER}");
		
		//capture screenshot of the putty window
		PuTTYwindow().maximize();
		sleep(5);
		take_screenshot("R18_VMscreen");
		
		logInfo("End - Login to VM Steps 50 - 52");
		
		
	}
}

