package org.drugis.common.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.jvnet.inflector.Rule;
import org.jvnet.inflector.lang.en.NounPluralizer;

public class PluralizedNamingStrategy extends ImprovedNamingStrategy {
	private static final long serialVersionUID = -6835213456671477403L;

	private final NounPluralizer d_pluralizer = new NounPluralizer();

	public PluralizedNamingStrategy() {
		final List<Rule> rules = new ArrayList<Rule>(d_pluralizer.getRules());
		rules.add(0, new EpochRule());
		d_pluralizer.setRules(rules);
	}

	@Override
	public String classToTableName(final String className) {
		final String tableName = super.classToTableName(className);
		final int idx = tableName.lastIndexOf('_');
		return tableName.substring(0, idx + 1) + d_pluralizer.pluralize(tableName.substring(idx + 1));
	}

	private static class EpochRule implements Rule {
		@Override
		public boolean applies(final String word) {
			return word.equalsIgnoreCase("epoch");
		}

		@Override
		public String apply(final String word) {
			return word + "s";
		}
	}
}