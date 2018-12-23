import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest
{
	@Test
	public void parseNum()
	{
		assertEquals("1", FizzBuzz.parseNum(1));
		assertEquals("2", FizzBuzz.parseNum(2));
		assertEquals("Fizz", FizzBuzz.parseNum(3));
		assertEquals("4", FizzBuzz.parseNum(4));
		assertEquals("Buzz", FizzBuzz.parseNum(5));
		assertEquals("FizzBuzz", FizzBuzz.parseNum(15));
	}

	@Test
	public void playGame()
	{
		assertEquals("1.", FizzBuzz.playGame(1).toString());
		assertEquals("1, 2.", FizzBuzz.playGame(2).toString());
		assertEquals("1, 2, Fizz.", FizzBuzz.playGame(3).toString());
		assertEquals("1, 2, Fizz, 4.", FizzBuzz.playGame(4).toString());
		assertEquals("1, 2, Fizz, 4, Buzz.", FizzBuzz.playGame(5).toString());
		assertEquals("1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz.", FizzBuzz.playGame(15).toString());
	}

	@Test
	public void checkNum()
	{
		assertFalse(FizzBuzz.checkNum(-1));
		assertFalse(FizzBuzz.checkNum(0));
		assertTrue(FizzBuzz.checkNum(1));
		assertTrue(FizzBuzz.checkNum(50));
		assertTrue(FizzBuzz.checkNum(99));
		assertTrue(FizzBuzz.checkNum(100));
		assertFalse(FizzBuzz.checkNum(101));
	}
}