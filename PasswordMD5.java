/*

Your task is to generate a password which is generated one character at a time by finding the MD5 hash of some given ID (your puzzle input found in input.txt) and an increasing integer index (starting with 0).

A hash indicates the next character in the password if its hexadecimal representation starts with five zeroes. If it does, the sixth character in the hash is the next character of the password.

For example, if the input ID is nth:

The first index which produces a hash that starts with 5 zeroes is 374147, which we get if we hash qth374147. The 6th character of this hash is 3 which is hence the first character of the password.
qth1076750 produces the next interesting hash, which starts with 0000086f..., so the second character of the password is 8.
The third time a hash starts with five zeroes is for qth4505103, making 4 the next character of our password.

In this example, after continuing this search a total of eight times, the password is 384e4e9f.

Given the actual input ID (see input.txt), what is the password?  

Your Input String = wtnhxymk;
My Output Password = 2414bc77



*/
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PasswordMD5 {

public static void main(String[] args) throws Exception {

    // String inputString = "shdi";
	 //String inputString = "wtnhxymk";
	// wtnhxymk
	 String inputString;
		Scanner s = new Scanner(System.in);
		inputString = s.nextLine();
	 
	 
	 
	int count = 0;
   // System.out.println("MD5 hex for '" + inputString + "' :");
    String password = "" ; 
    long i = 0;
    String inputString1= inputString;
    while (count <= 7) {
    	
    	String output = getMD5Hex(inputString1);
    //	System.out.println("inputString: "+ inputString);
    	
        
      String substr = output.substring(0, 5);
      String zero = "00000";
      
      
      if(substr.equals(zero)){
    	  System.out.println("inputString: "+ inputString1);
          System.out.println("output: "+ output);
    	  password = password + output.charAt(5);
    	  count++;
      }
      
      inputString1 = inputString + i;
      
        i++;
        
    }
    
    System.out.println("password : " + password); 
    
	
}

public static String getMD5Hex( String inputString) throws NoSuchAlgorithmException {

    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(inputString.getBytes());

    byte[] digest = md.digest();

    return convertByteToHex(digest);
}

private static String convertByteToHex(byte[] byteData) {

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < byteData.length; i++) {
        sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }

    return sb.toString();
}
}
