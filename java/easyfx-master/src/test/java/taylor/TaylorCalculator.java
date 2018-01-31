package taylor;

public class TaylorCalculator {

	public double calculate(int exponent, int begin, int end) {
		double result = 0;
		double calc =1;
		for(int limit = 0; calc >=10E-8; limit++) {
			calc = ((Math.pow(exponent, limit)) / this.factorial(limit));
			result += calc;	
		}
		return result;
	}

	public double factorial(int number) {
		double result = 1;		
		for(int i = 1; i <= number; i++) {
			result *= i;
		}
		return result;
	}
		
}
