package taylor;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TaylorTests {

	private TaylorCalculator calc;
	
	@Before
	public void initalize() {
		calc = new TaylorCalculator();
	}
	
	
	@Test
	public void factorialTest() {

		assertTrue(calc.factorial(0) == 1);
		assertTrue(calc.factorial(1) == 1);
		assertTrue(calc.factorial(2) == 2);
		assertTrue(calc.factorial(3) == 6);
		assertTrue(calc.factorial(4) == 24);
		assertTrue(calc.factorial(5) == 120);
		
	}
	
	@Test
	public void exponentialOfX() {
		
//		assertTrue(calc.calculate(5, 0, 2) == 18.5);
//		assertTrue(calc.calculate(0, 0, 2) == 1);
//		assertTrue(calc.calculate(1, 0, 2) == 2.5);
		System.out.println(calc.calculate(1, 0, 30));//2.718281828459045


	}

}
