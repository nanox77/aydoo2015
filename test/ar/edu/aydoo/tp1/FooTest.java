package ar.edu.aydoo.tp1;

import org.junit.Assert;
import org.junit.Test;

public class FooTest {

	@Test
	public void doFooShouldReturnFoo() {
		Foo foo = new Foo();
		String result = foo.doFoo();
		Assert.assertEquals("Foo", result);
	}

}
