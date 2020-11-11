package view;

import javafx.scene.control.TextField;
/***
 * 
 * @author Chris
 * InputParser - validates user input for integers and doubles values
 *
 */

public class InputParser {
	
	public int parseIntegerValue(TextField userInput)	{
		int userValue = (int) Double.parseDouble(userInput.getPromptText().substring(1, 4));
		int tempUserValue = 0;
		if(userInput.getText() != null)	{
			try	{
				tempUserValue = Integer.parseInt(userInput.getText());
				if(tempUserValue > 0 )	{
					userValue = tempUserValue;
				}
				else	{
					System.out.println("Value out of range: Using default value");
				}
			}
			catch(Exception e)	{
				System.out.println("Value not valid: Using default value");
			}
		}
		return userValue;
	}
	
	public double parseDoubleValue(TextField userInput)	{
		double userValue = Double.parseDouble(userInput.getPromptText().substring(1, 4));
		double tempUserValue = 0;
		if(userInput.getText() != null)	{
			try	{
				tempUserValue = Double.parseDouble(userInput.getText());
				if(tempUserValue > 0 && tempUserValue <= 1.0) {
					userValue = tempUserValue;
				}
				else	{
					System.out.println("Value out of range: Using default value");
				}
			}
			catch(Exception e)	{
				System.out.println("Value not valid: Using default value");
			}
		}
		return userValue;
	}
}
