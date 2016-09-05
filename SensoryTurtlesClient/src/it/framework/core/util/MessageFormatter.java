package it.framework.core.util;

import java.util.Map;

import org.apache.commons.lang3.text.StrSubstitutor;

public class MessageFormatter {
	public static String format(String template, Map<String, Object> parameters) {
		StrSubstitutor substitutor = new StrSubstitutor(parameters);
		return substitutor.replace(template);
	}
}
