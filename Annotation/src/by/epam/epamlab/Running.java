package by.epam.epamlab;

import by.epam.epamlab.beans.AnyObject;

public class Running {
	public static void main(String[] args) throws Exception {
		int int1 = 12;
		int int2 = 342;
		String string1 = "abc";
		String string2 = "abcd";
		Integer integer1 = 2;
		Integer integer2 = 2;
				
		AnyObject o1 = new AnyObject(int2, string1, integer2);
		AnyObject o2 = new AnyObject(int1, string2, integer1);
		AnyObject o3 = new AnyObject(int1, string2, integer1);
				
		Analyzer.equalObjects(o1, o2);
		Analyzer.equalObjects(o1, o3);
		Analyzer.equalObjects(o2, o3);		
	}
}
