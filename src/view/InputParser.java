package view;

import javafx.scene.control.TextField;
/***
 * 
 * @author Chris
 * InputParser - validates user input for integers and doubles values
 *
 */

public class InputParser {
	
	private final String OUT_OF_RANGE = "Value out of range: Using default value";
	private final String VALUE_NOT_VALID = "Value not valid: Using default value";
	private final int DEFAULT_VALUE_START_INDEX = 1;
	private final int DEFAULT_VALUE_END_INDEX = 4;
	private double defaultValue;
		
	public double parseDoubleValue(TextField userInput) {
		defaultValue = getDefaultValue(userInput);
		double tempUserValue = 0;
		if(userInput.getText() != null)	{
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
	
	public int parseIntValue(TextField userInput) {
		defaultValue = getDefaultValue(userInput);
		int tempUserValue = 0;
		if(userInput.getText() != null) {
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
	
	public double getDefaultValue(TextField userInput)	{
		return Double.parseDouble(userInput.getPromptText().substring(DEFAULT_VALUE_START_INDEX, DEFAULT_VALUE_END_INDEX));
	}
	
	public void checkValue(double userInput) {	
		if (userInput > 0 && userInput <= 1.0)	{
			defaultValue = userInput;
		}
		else	{
			System.out.println(OUT_OF_RANGE);
		}
	}
	
	public void checkValue(int userInput) {
		if(userInput > 0)	{
			defaultValue = userInput;
		}
		else	{
			System.out.println(OUT_OF_RANGE);
		}
	}
	
	
}