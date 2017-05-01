package com.telstra.commons.utility;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class Environment {
	public static final String INTERNET_OFF = "INTERNET_OFF";
	public static final String INVALID_USER = "INVALID_USER";
	private ConcurrentHashMap<String,String> prop = new ConcurrentHashMap<String,String>() ;
	
	private static Environment singleton = null;

    /* A private Constructor prevents any other
    * class from instantiating.
    */
    private Environment() { }

    /* Static 'instance' method */
    public static Environment getInstance( ) {
    	if(singleton != null){
    		return singleton;
    	}
    	else{
    		singleton = new Environment( );
    		return singleton;
    	}
    }
	
	public ConcurrentHashMap<String,String> getServerProp(){
		return this.prop;
	}
	
	public boolean isInternetOff() {
	    if (prop != null && prop.containsKey(Environment.INTERNET_OFF)
	        && prop.get(Environment.INTERNET_OFF).compareToIgnoreCase("true") == 0) {
	      return true;
	    }
	    return false;
	}
	public boolean isInvalidUser() {
	    if (prop != null && prop.containsKey(Environment.INVALID_USER)
	        && prop.get(Environment.INVALID_USER).compareToIgnoreCase("true") == 0) {
	      return true;
	    }
	    return false;
	}
}
