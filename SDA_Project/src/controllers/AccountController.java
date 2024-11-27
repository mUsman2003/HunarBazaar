package controllers;

import handlers.AccountHandler;
import models.User;

public class AccountController {
	public void signup () {
		
	}
	public static User login(String user, String pass) {
		
		User signinuser = null;
		// TODO Auto-generated method stub
		try {
			signinuser = handlers.AccountHandler.validateUser(user, pass);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return signinuser;
	}
	
	public static boolean BuyerSignUpVaidation(String user, String phone) {
		
		boolean successed = false;
		// TODO Auto-generated method stub
		try {
			boolean success = handlers.AccountHandler.isUsernameAndPhoneUnique(user, phone);
			successed=success;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return successed;
	}
	
	public static boolean BuyerSignup(String Fname, String Lname,String Uname,String phone,String Location,String Password) {

		
		boolean successed = false;
		// TODO Auto-generated method stub
		try {
			boolean success = handlers.AccountHandler.addNewBuyer( Fname,  Lname, Uname, phone, Location, Password);
			successed=success;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return successed;
	}
	
	public static boolean SellerSignUp(String CNIC, int Category) {
		
		boolean successed = false;
		// TODO Auto-generated method stub
		try {
			boolean success = handlers.AccountHandler.addNewSeller(CNIC, Category);
			successed=success;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return successed;
	}
	public static String getBuyerName(int buyerId) {
		// TODO Auto-generated method stub
        return AccountHandler.fetchBuyerName(buyerId);

	}
	public static String getBuyerLocation(int senderid) {
		// TODO Auto-generated method stub
		return AccountHandler.fetchBuyerLocation(senderid);
	}
	public static String getBuyerPhone(int senderid) {
		// TODO Auto-generated method stub
		return AccountHandler.fetchBuyerphone(senderid);
	}
	
}
