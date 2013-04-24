package org.drugis.common.hibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PluralizedNamingStrategyTest {

	@Test
	public void test() {
		final PluralizedNamingStrategy pns = new PluralizedNamingStrategy();
		assertEquals("users", pns.classToTableName("User"));
		assertEquals("ponies", pns.classToTableName("Pony"));
		assertEquals("pony_riders", pns.classToTableName("PonyRider"));
	}

	@Test
	public void testEpochPlural() {
		final PluralizedNamingStrategy pns = new PluralizedNamingStrategy();
		assertEquals("epochs", pns.classToTableName("Epoch"));
	}

}
