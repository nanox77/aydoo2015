package fiuba.algo3.ejemplo1;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class CharCounterTest {

	@Test
	public void howManyShouldReturnZeroWhenCharIsNotPresent() {

		CharCounter counter = new CharCounter("hello world");

		Assert.assertEquals(0, counter.howMany('y'));

	}

	@Test
	public void howManyShouldReturnNegativeWhenCharIsSymbolMoney() {

		CharCounter counter = new CharCounter("hello world");

		Assert.assertEquals(-1, counter.howMany('$'));

	}

	@Test
	public void howManyShouldReturnNegativeWhenCharIsSymbolAt() {

		CharCounter counter = new CharCounter("hello world");

		Assert.assertEquals(-2, counter.howMany('@'));

	}

	@Test
	public void countAllShouldReturnAnArrayWithAllCharsCount() {

		CharCounter counter = new CharCounter("hello world");
		HashMap<Character, Integer> result = counter.countAll();

		Assert.assertTrue(result.get('h').equals(1));
		Assert.assertTrue(result.get('z').equals(0));
		Assert.assertTrue(result.get('l').equals(3));
	}

}