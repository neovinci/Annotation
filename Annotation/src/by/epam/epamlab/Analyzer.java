package by.epam.epamlab;

import java.lang.reflect.Field;

public class Analyzer {
	 
	public static boolean equalObjects(Object object1, Object object2) throws IllegalArgumentException, IllegalAccessException {
		boolean isEqual = true;
		boolean isObjectEquals = true;
		if(object1.getClass() == object2.getClass()) {
			Field[] fieldsObject1 = object1.getClass().getDeclaredFields();
			Field[] fieldsObject2 = object2.getClass().getDeclaredFields();
			
			for(int i = 0; i < fieldsObject1.length; i++) {
				Field currentFieldObject1 = fieldsObject1[i];
				Field currentFieldObject2 = fieldsObject2[i];
				currentFieldObject1.setAccessible(true);
				currentFieldObject2.setAccessible(true);
				CompareMethod currentMethod = currentFieldObject1.getAnnotation(Equal.class).compareBy();
				System.out.printf("The fields [%s %s] of objects [%s] class equality by %s: ", currentFieldObject1.getType().getSimpleName(), currentFieldObject1.getName(), object1.getClass().getSimpleName()
						,currentMethod.toString());
				
				switch(currentMethod) {
					case VALUE:
						isEqual = (currentFieldObject1.get(object1).equals(currentFieldObject2.get(object2)));
						break;
					case REFERENCE:
						isEqual = (currentFieldObject1.get(object1) == currentFieldObject2.get(object2));
						break;
					default:
						throw new EnumConstantNotPresentException(CompareMethod.class, currentMethod.name());
				}
				isObjectEquals = ((isEqual == false) ? false : isObjectEquals); 
				System.out.println(isEqual);				
			}
			System.out.printf("The objects are%s equals!\n\n", ((isObjectEquals == false) ? " not" : ""));
		} else {
			isObjectEquals = false;
			System.out.println("The objects belong to different classes\n");
		}
		return isObjectEquals;
	}
	
	
}
