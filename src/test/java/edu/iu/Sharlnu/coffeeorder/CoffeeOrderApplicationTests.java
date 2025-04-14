package edu.iu.Sharlnu.coffeeorder;

import edu.iu.Sharlnu.coffeeorder.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoffeeOrderApplicationTests {

	// Dark Roast
	@Test
	void DarkRoastTest() {
		Beverage beverage = new DarkRoast();
		assertEquals("Dark roast", beverage.getDescription());
		assertEquals(1.99, beverage.cost(), 0.01);
	}

	@Test
	void DarkRoastWithMilkAndMochaTest() {
		Beverage beverage = new DarkRoast();
		beverage = new Milk(beverage);
		beverage = new Mocha(beverage);
		assertEquals("Dark roast, Milk, Mocha", beverage.getDescription());
		assertEquals(1.99 + 0.4 + 0.3, beverage.cost(), 0.01);
	}

	@Test
	void DarkRoastWithWhipAndSoyTest() {
		Beverage beverage = new DarkRoast();
		beverage = new Whip(beverage);
		beverage = new Soy(beverage);
		assertEquals("Dark roast, Whip, Soy", beverage.getDescription());
		assertEquals(1.99 + 0.25 + 0.27, beverage.cost(), 0.01);
	}

	@Test
	void DarkRoastWithMochaAndWhipTest() {
		Beverage beverage = new DarkRoast();
		beverage = new Mocha(beverage);
		beverage = new Whip(beverage);
		assertEquals("Dark roast, Mocha, Whip", beverage.getDescription());
		assertEquals(1.99 + 0.3 + 0.25, beverage.cost(), 0.01);
	}

	// Decaf
	@Test
	void DecafTest() {
		Beverage beverage = new Decaf();
		assertEquals("Decaf", beverage.getDescription());
		assertEquals(1.28, beverage.cost(), 0.01);
	}

	@Test
	void DecafWithSoyAndWhipTest() {
		Beverage beverage = new Decaf();
		beverage = new Soy(beverage);
		beverage = new Whip(beverage);
		assertEquals("Decaf, Soy, Whip", beverage.getDescription());
		assertEquals(1.28 + 0.27 + 0.25, beverage.cost(), 0.01);
	}

	@Test
	void DecafWithMilkAndMochaTest() {
		Beverage beverage = new Decaf();
		beverage = new Milk(beverage);
		beverage = new Mocha(beverage);
		assertEquals("Decaf, Milk, Mocha", beverage.getDescription());
		assertEquals(1.28 + 0.4 + 0.3, beverage.cost(), 0.01);
	}

	@Test
	void DecafWithSoyAndMochaTest() {
		Beverage beverage = new Decaf();
		beverage = new Soy(beverage);
		beverage = new Mocha(beverage);
		assertEquals("Decaf, Soy, Mocha", beverage.getDescription());
		assertEquals(1.28 + 0.27 + 0.3, beverage.cost(), 0.01);
	}

	// Espresso
	@Test
	void EspressoTest() {
		Beverage beverage = new Espresso();
		assertEquals("Espresso", beverage.getDescription());
		assertEquals(1.34, beverage.cost(), 0.01);
	}

	@Test
	void EspressoWithMochaTest() {
		Beverage beverage = new Espresso();
		beverage = new Mocha(beverage);
		assertEquals("Espresso, Mocha", beverage.getDescription());
		assertEquals(1.34 + 0.3, beverage.cost(), 0.01);
	}

	@Test
	void EspressoWithMilkAndWhipTest() {
		Beverage beverage = new Espresso();
		beverage = new Milk(beverage);
		beverage = new Whip(beverage);
		assertEquals("Espresso, Milk, Whip", beverage.getDescription());
		assertEquals(1.34 + 0.4 + 0.25, beverage.cost(), 0.01);
	}

	@Test
	void EspressoWithMochaAndWhipTest() {
		Beverage beverage = new Espresso();
		beverage = new Mocha(beverage);
		beverage = new Whip(beverage);
		assertEquals("Espresso, Mocha, Whip", beverage.getDescription());
		assertEquals(1.34 + 0.3 + 0.25, beverage.cost(), 0.01);
	}

	// HouseBlend
	@Test
	void HouseBlendTest() {
		Beverage beverage = new HouseBlend();
		assertEquals("House Blend", beverage.getDescription());
		assertEquals(1.65, beverage.cost(), 0.01);
	}

	@Test
	void HouseBlendWithMilkAndWhipTest() {
		Beverage beverage = new HouseBlend();
		beverage = new Milk(beverage);
		beverage = new Whip(beverage);
		assertEquals("House Blend, Milk, Whip", beverage.getDescription());
		assertEquals(1.65 + 0.4 + 0.25, beverage.cost(), 0.01);
	}

	@Test
	void HouseBlendWithSoyAndMochaTest() {
		Beverage beverage = new HouseBlend();
		beverage = new Soy(beverage);
		beverage = new Mocha(beverage);
		assertEquals("House Blend, Soy, Mocha", beverage.getDescription());
		assertEquals(1.65 + 0.27 + 0.3, beverage.cost(), 0.01);
	}

	@Test
	void HouseBlendWithWhipAndMochaTest() {
		Beverage beverage = new HouseBlend();
		beverage = new Whip(beverage);
		beverage = new Mocha(beverage);
		assertEquals("House Blend, Whip, Mocha", beverage.getDescription());
		assertEquals(1.65 + 0.25 + 0.3, beverage.cost(), 0.01);
	}

}
