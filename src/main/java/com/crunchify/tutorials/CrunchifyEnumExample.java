package com.crunchify.tutorials;
import com.crunchify.tutorials.CrunchifyEnumCompany;
 
/**
 * @author Crunchify.com
 */
 
public class CrunchifyEnumExample {
 
	public static void main(String[] args) {
		System.out.println("Get enum value for Comapny 'eBay': "
				+ CrunchifyEnumCompany.EBAY.getCompanyLetter());
		System.out.println("Get enum value for Comapny 'eBay': "
				+ CrunchifyEnumCompany.EBAY.name());
		
		if(/*CrunchifyEnumCompany.EBAY.name() "Ricky-Bobby"*/ isInstance(new Integer("1"), String.class)) {
			System.out.println("new Integer() IS String");
		} else {
			System.out.println("new Integer() NOT String");
		}
		
		if(isInstance(CrunchifyEnumCompany.EBAY, String.class)) {
			System.out.println("EBAY.name() IS String");
		} else {
			System.out.println("EBAY.name() NOT String");
		}
		
		System.out.println((isInstance(CrunchifyEnumCompany.EBAY, String.class) ? CrunchifyEnumCompany.EBAY+" IS String" : CrunchifyEnumCompany.EBAY+" NOT String"));
		
		if(CrunchifyEnumCompany.EBAY instanceof CrunchifyEnumCompany) {
			System.out.println("IS String");
		} else {
			System.out.println("NOT String");
		}
		System.out.println("CrunchifyEnumCompany.EBAY.toString() : "+CrunchifyEnumCompany.EBAY.toString());
		System.out.println("CrunchifyEnumCompany.EBAY : "+CrunchifyEnumCompany.EBAY);
		System.out.println("CrunchifyEnumCompany.EBAY.name() : "+CrunchifyEnumCompany.EBAY.name());

	}
	static boolean isInstance(Object object, Class<?> type) {
	    return type.isInstance(object);
	}
}