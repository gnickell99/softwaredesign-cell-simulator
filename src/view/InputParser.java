package view;

import javafx.scene.control.TextField;
/***
 * 
 * @author Chris
 * InputParser - validates user input for integers and doubles values
 *
 */

public class InputParser {
	
	// constants
	private final String OUT_OF_RANGE = "Value out of range: Using default value";
	private final String VALUE_NOT_VALID = "Value not valid: Using default value";
	private final int DEFAULT_VALUE_START_INDEX = 1;
	private final int DEFAULT_VALUE_END_INDEX_DOUBLE = 4;
	private double defaultValue;
		
	/**parseDoubleValue
	 * 
	 * Validates input from the user to make sure that the input is a valid double
	 */
	public double parseDoubleValue(TextField userInput) {
		defaultValue = getDefaultValue(userInput);
		double tempUserValue = 0;
		if(userInput != null)	{
			try	{
				tempUserValue = Double.parseDouble(userInput.getText());
				checkValue(tempUserValue);
			}
			catch(Exception e)	{
				System.out.println(VALUE_NOT_VALID);
			}
		}
		return defaultValue;
	}
	
	/**parseintValue
	 * 
	 * Validates input from the user to make sure that the input is a valid int
	 */
	public int parseIntValue(TextField userInput) {
		defaultValue = getDefaultValue(userInput);
		int tempUserValue = 0;
		if(userInput != null) {
			try	{
				tempUserValue = Integer.parseInt(userInput.getText());
				checkValue(tempUserValue);
			}
			catch(Exception e) {
				System.out.println(VALUE_NOT_VALID);
			}
		}
		return (int)defaultValue;
	}
	
	/**getDefaultValue
	 * 
	 * Returns user input if faulty to the default values
	 */
	public double getDefaultValue(TextField userInput)	{
		return Double.parseDouble(userInput.getPromptText().substring(DEFAULT_VALUE_START_INDEX, DEFAULT_VALUE_END_INDEX_DOUBLE));
	}
	
	/**checkValue
	 * 
	 * checks to make sure that the users input for a double value is in range
	 */
	public void checkValue(double userInput) {	
		if (userInput > 0 && userInput <= 1.0)	{
			defaultValue = userInput;
		}
		else	{
			System.out.println(OUT_OF_RANGE);
		}
	}
	
	/**checkValue
	 * 
	 * checks to make sure that the users input for a int value is in range
	 */
	public void checkValue(int userInput) {
		if(userInput > 0 && userInput <=50)	{
			defaultValue = userInput;
		}
		else	{
			System.out.println(OUT_OF_RANGE);
		}
	}
	
	
}