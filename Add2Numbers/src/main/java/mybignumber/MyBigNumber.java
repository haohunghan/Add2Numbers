/**
*
* @author Hao Nguyen
* A function that add 2 very big number
*/

package mybignumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
	

public class MyBigNumber {
	

	private IReceiver ireceiver;
   
   //Ham de goi tung buoc
	public MyBigNumber(final IReceiver ireceiver) {
       this.ireceiver = ireceiver;
   }
    
   
	/**
	 * Function that add 2 very big numbers
    * To perform two sequences, we have two variable:
    * and two variable include character from '0' - '9'.
    * <br/>
    *
    * @param s1 the first string.
    * @param s2 the second string.
    * @return string which is sum of str1 and str2.
    * @throw Print a warning line to users
    */
   public String sum(String s1, String s2){
       
       int posError;	//Position of error
       
       Pattern p = Pattern.compile("\\D"); // String contains [0-9]
       final Matcher m1 = p.matcher(s1);
       final Matcher m2 = p.matcher(s2);
       
       //check two number is empty or not
       // if it is null make it = "0"
       if ((s1 == null) || (s1.trim().isEmpty())) {
           s1 = "0";
       }
       if ((s2 == null) || (s2.trim().isEmpty())) {
           s2 = "0";
       }
       
     //Check whether the number is negative
       if (s1.charAt(0) == '-' && s2.charAt(0) != '-') {
           posError = 1;
           this.ireceiver.sendMessage("First number must be a positive number: " + s1);
           throw new NumberFormatException("Error location at: " + posError 
                   + " of string " + s1 + " is not a positive number");
       }
       if (s2.charAt(0) == '-' && s1.charAt(0) != '-') {
           posError = 1;
           this.ireceiver.sendMessage("Second number must be a positive number: " + s2);
           throw new NumberFormatException("Error location at: " + posError 
                   + " of string " + s2 + " is not a positive number");
       }
       if (s2.charAt(0) == '-' && s1.charAt(0) == '-') {
           posError = 1;
           this.ireceiver.sendMessage("Both of 2 number must be a positive number : " + s1 + " and " + s2);
           throw new NumberFormatException("Error location at: " + posError 
                   + " of string " + s1 + " and " + s2 + " is not a number");
       }
      
       
       // Checking special character
       if (m1.find()) {
           this.ireceiver.sendMessage("Please does not contain any character in first number : " + s1);
           throw new NumberFormatException(m1.start() + 1 + "");   
       }
       if (m2.find()) {
           this.ireceiver.sendMessage("Please does not contain any character in second number : " + s2);
           throw new NumberFormatException(m2.start() + 1 + "");
       }
       
       
       String result = "";	//final result
       //Step 1: get the length of 2 string
       int length1 = s1.length();
       int length2 = s2.length();
       
       //Get the bigger length between length1 and length2 
       int maxLength = (length1 > length2) ? length1 : length2;
       
       //Temp value
       //When result > 9 then temp will be 1
       int temp = 0;
       
       int position1 = 0;//Location of character in first string
       int position2 = 0;//Location of character in second string
       
       //Character at the location
       char c1;
       char c2;
       
       //sum of 2 character
       int sum = 0;
       
       //return step
       String direction = "";
       
       // Loop from 0 to maxLength
       for (int i = 0; i < maxLength; i++) {
           
           //Update location of each character
           position1 = length1 - i - 1;
           position2 = length2 - i - 1;
           
           //Step1 ... 
           //Step2 ...
           //....
           direction += "Step " + (i + 1) + ":\n";
           
           // Check whether the location is > 0
           // If > 0, then take the character at the location 
           c1 = (position1 >=0) ? s1.charAt(position1) : '0';
           c2 = (position2 >=0) ? s2.charAt(position2) : '0';
           
           //Convert character into number
           sum = (c1 - '0') + (c2 - '0');
           
           //When first running, temp = 0
           //So will not contains  + temp 
           if (i == 0){
               direction += c1 + " + " + c2 + " = " + sum + 
                       ". Write " + (sum%10) + " remember " + sum/10;
                      
           } else {
               direction += c1 + " + " + c2 + " = " + sum + " + " + temp + " = " + (sum + temp) +
                       ". Write " + (sum%10 + temp) + " remember " + sum/10;
                      
           }
           
           sum+= temp;
           result = (sum % 10) + result;
           temp = sum / 10;
           
           direction += ". current result: " + (result) + ".\n"; //(sum+=temp) + result = current result
          
   }

       if (temp >= 1) {
	    direction += "1" + " + 0 = 1. Write 1." ;
           result = 1 + result;//If when end loop, temp = 1, then add 1 to first String
       }
       
       this.ireceiver.sendMessage(direction);
       
       return result.trim();//Return the final result
   }
	
}
