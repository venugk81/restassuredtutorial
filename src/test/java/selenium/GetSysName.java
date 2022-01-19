package selenium;

import java.net.InetAddress;

public class GetSysName {
	 public static void main(String[] args)
	    {
	        try {
	 
	            // get system name
	            String SystemName
	                = InetAddress.getLocalHost().getHostName();
	 
	            // SystemName stores the name of the system
	            System.out.println("System Name : "
	                               + SystemName);
	            
	         // get system name
	            SystemName
	                = InetAddress.getLocalHost().getCanonicalHostName();
	 
	            // SystemName stores the name of the system
	            System.out.println("getCanonicalHostName Name : "
	                               + SystemName);
	            
	            SystemName
                = InetAddress.getLocalHost().getHostAddress();
	            
	            System.out.println("getHostAddress Name : "
                        + SystemName);
     
	        }
	        catch (Exception E) {
	            System.err.println(E.getMessage());
	        }
	    }

}
