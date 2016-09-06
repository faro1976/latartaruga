package it.framework.core.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;

public class ListUtil {
	private ListUtil() {
	}

	public static <S, T extends S> List<S> toSuperType(List<T> list) {
		return Lists.transform(list, i -> i);
	}

	@SuppressWarnings("unchecked")
	public static <S, T extends S> List<T> castToSubType(List<S> list) {
		return Lists.transform(list, i -> (T) i);
	}

	public static boolean unorderedEquals(List<?> one, List<?> two) {
		if (one == two) {
			return true;
		}

		Set<Object> set1 = one != null ? new HashSet<>(one) : new HashSet<>(one);
		Set<Object> set2 = two != null ? new HashSet<>(two) : new HashSet<>(two);
		return set1.equals(set2);
	}
}
