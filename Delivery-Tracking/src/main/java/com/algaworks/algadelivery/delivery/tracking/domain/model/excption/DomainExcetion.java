package com.algaworks.algadelivery.delivery.tracking.domain.model.excption;

public class DomainExcetion extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public DomainExcetion() {
		
	}
	
	public DomainExcetion(String message) {
		super(message);
	}
	
	public DomainExcetion(String message, Throwable cuase) {
		super(message, cuase);
	}
}
