package it.framework.core.service.impl;

import it.framework.client.service.inferf.IOffset;

public class Offset implements IOffset {

	private int start;
	private int maxResults;
	
		
	public Offset(int start, int maxResults) {
		super();
		this.start = start;
		this.maxResults = maxResults;
	}

	@Override
	public int getStart() {
		return start;
	}

	@Override
	public int getMaxResults() {
		return maxResults;
	}

}
