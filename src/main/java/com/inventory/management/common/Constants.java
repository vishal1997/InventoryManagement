package com.inventory.management.common;

/**
 * 
 * @author Vishal
 *
 */
public class Constants {

	/**
	 * To connect using the mongo shell:
		mongo ds115752.mlab.com:15752/inventory -u <dbuser> -p <dbpassword>
		To connect using a driver via the standard MongoDB URI (what's this?):
		
		mongodb://<dbuser>:<dbpassword>@ds115752.mlab.com:15752/inventory

	 * @author Vishal Gupta
	 *
	 */
	public class Database {
		
		public static final String DATABASE = "inventory";
		public static final String ADDRESS = "ds115752.mlab.com";
		public static final int PORT = 15752;
		
		//Move this to properties file.
		public static final String USER = "admin1";
		public static final String PWD = "admin1";
	}
	
	public class StatusCode {
		public static final String SUCCESS = "Success";
		public static final String DUPLICATE = "Duplicate";
		public static final String ERROR = "Delete";
		public static final String INVALID = "Invalid";
		public static final String FAILED = "Failed";
	}
	
	public class MongoDbSignature {
		public static final String DUPLICATE_CODE = "error code 11000";
	}
	
	public class Opinion {
		public static final String AGREE = "Agree";
		public static final String DISAGREE = "Disagree";
	}
	
	public class Mailer {
		public static final String HOST = "smtp.gmail.com";
		public static final String SENDER = "anque.in@gmail.com";
		public static final String RESETSUBJECT = "Anque Reset Password";
		public static final String MAILSENT = " Mail sent";
		public static final String RESETPASSWORDBODY = "Your OTP for reset password : ";
		public static final String PA = "anquebyvishal";
	}
}
