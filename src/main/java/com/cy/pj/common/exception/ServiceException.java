package com.cy.pj.common.exception;

public class ServiceException extends RuntimeException {

	/**
	 * 在当前方法中需要的ServiceException是一个自己定义的异常, 通过自定义异常可更好的实现对业务问题的描述，同时可以更好的提高用户体验。
	 */
	private static final long serialVersionUID = -5598865415547474216L;

	public ServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
