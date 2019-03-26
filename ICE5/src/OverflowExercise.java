import java.util.Scanner;

public final class OverflowExercise
{
	public static void main(String[] args)
	{
		short acctBal = Short.MAX_VALUE - 3000; // Take note of the data type for acctBal!
		
		String input = "0";
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("You currently have an account balance of $" + acctBal + ".");
			//System.out.println("Account cannot go negative or over $32767.");
			System.out.print("Deposit how much? ");
			
			input = scanner.nextLine().trim();
			
			try
			{
				int depAmt = Integer.parseInt(input);
				/*if (tryDeposit(depAmt, acctBal)) {
					acctBal += depAmt;
				}*/
				if (Math.addExact(acctBal, depAmt) <= Short.MAX_VALUE && (Math.addExact(acctBal, depAmt)) >= 0) {
					acctBal = (short)Math.addExact(acctBal, depAmt);
				} else {
					throw new ArithmeticException("Cannot deposit that amount. Account cannot go negative or over $32767.");
				}
			}
			catch(NumberFormatException nfe)
			{
				if(input.toLowerCase().equals("quit"))
				{
					break;
				}
				else
				{
					System.out.println("Sorry, I don't recognize that number.");
				}
			}
		}
		
		System.out.println("Thank you, and goodbye.");
		scanner.close();
	}
	
	public static boolean tryDeposit(int depAmt, short acctBal) {
		if ((depAmt + acctBal) <= Short.MAX_VALUE && (depAmt + acctBal) >= 0) {
			return true;
		} else {
			throw new ArithmeticException("Cannot deposit that amount. Account cannot go negative or over $32767.");
			//return false;
		}
	}
}
