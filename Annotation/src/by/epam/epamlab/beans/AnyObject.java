package by.epam.epamlab.beans;

import by.epam.epamlab.CompareMethod;
import by.epam.epamlab.Equal;

public class AnyObject {
	@Equal//(compareBy = CompareMethod.REFERENCE)
	private int oneArgument;
	@Equal(compareBy = CompareMethod.REFERENCE)
	private String secondArgument;
	@Equal//(compareBy = CompareMethod.REFERENCE)
	private Integer threeArgument;
	
	public AnyObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnyObject(int oneArgument, String secondArgument, Integer threeArgument) {
		super();
		this.oneArgument = oneArgument;
		this.secondArgument = secondArgument;
		this.threeArgument = threeArgument;
	}	
}
