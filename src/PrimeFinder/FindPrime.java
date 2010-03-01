package PrimeFinder;

import java.util.ArrayList;

/**
 * @author student
 *
 */
public class FindPrime {
	
//	Public Function IsSafePrime(ByVal Number As Long) As Boolean
//	  If IsPrime(Number) Then IsSafePrime = IsPrime(Number \ 2)
//	End Function
//	
//	
//	Public Function IsPrime(ByVal Number As Long) As Boolean
//	  If Initiated = False Then Init
//	    If (Number And 1) Then
//	      IsPrime = (Composite(Number \ 16) And Bit8((Number \ 2) Mod 8)) = 0
//	    Else
//	      IsPrime = Number = 2
//	    End If
//	End Function 
	
	

	boolean isPrime(double n) {
		boolean prime = true;
		for (long i = 3; i <= Math.sqrt(n); i += 2)
			if (n % i == 0) {
				prime = false;
				break;
			}
		if (( n%2 !=0 && prime && n > 2) || n == 2) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean isSafePrime(double n) {
		return isPrime((n)/2);
	}

	public static void main(String[] args) {
		Pi pi = new Pi();
		String valueString = pi.getPi();
		System.out.println(valueString.length());
		int number = 0;
		int counter = 0;
		FindPrime findPrime = new FindPrime();
		boolean isReady = false;
		String numberString = "";
		while (counter+6 < valueString.length()) {
			numberString = "";
			isReady = false;
			while (!isReady) {
				isReady = true;
				
				if (Character.isDigit(valueString.charAt(counter))) {
					if (numberString == null) {
						numberString = Character.toString(valueString.charAt(counter));
					}
					else {
						numberString = numberString + valueString.charAt(counter);
					}
				}
				
				
				if (numberString.length() == 8) {
					number = Integer.parseInt(numberString); 
					counter = counter - 6;
					if (findPrime.isSafePrime(number)) {
						System.out.println("Safe Prime found!: "+number);
					}
					
				}
				else {
					isReady = false;
				}
				counter++;
				
				 
			}
		}
	}
}
