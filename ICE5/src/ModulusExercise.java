public final class ModulusExercise
{
	public static void main(String[] args)
	{
		int a = -6;
		int b = 73;
		int c = 45;
		
		System.out.printf("%d^%d mod %d = %d", a, b, c, modPow(a,b,c));
	}
	
	/**
	 * Calculates modular exponentiation through the "square and multiply" method.
	 * @param a The base
	 * @param b The exponent
	 * @param p The modulus
	 * @return  The solution to the expression (a^b) mod p
	 */
	private static int modPow(int a, int b, int p) throws ArithmeticException
	{
		p = Math.abs(p);
		// HINT: Consider adding something here!
		if(b == 0)
		{
			if (p == 1) {
				return 0;
			} else {
				return 1;   // a^0 = 1 for all a
			}
		}
		else if(b == 1)
		{
			while(a < 0) {
				a += p;
			}
			return a%p; // a^1 = a for all a
		}
		else if(b%2 == 0)
		{
			while(a < 0) {
				a += p;
			}
			return modPow((a*a)%p, (b/2), p);
		}
		else if(b%2 == 1)
		{
			while(a < 0) {
				a += p;
			}
			return (a * modPow((a*a)%p, ((b-1)/2), p))%p;
		}
		else
		{
			throw new ArithmeticException("Exponent is an invalid value, for example less than 0.");
		}
	}
}
