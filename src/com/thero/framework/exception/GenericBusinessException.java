package com.thero.framework.exception;
/**
 * Base Exception class that can be thrown by the business layer.
 * 
 * 业务异常基类。必须要捕获。
 * 
 * 能传递到 GWT 客户端  
 * 
 * @author  cpp
 * @version 1.0
 */
@SuppressWarnings("serial")
public class GenericBusinessException extends Exception {

	
	//错误Key，统一在资源文件 ErrorMessage.java 里编排
	private String errorCode ="0";                                  
	//错误基本描述，面向操作人员可理解，必须为中文 , 例子：箱号10018已锁定，无法开户
	private String errorDescription = ""; 
	//错误原因和详细信息，一般从具体的异常类中取出，如 jdbc execption , hibernate , spring 等框架的异常信息。可能为英文。
	//例子：drawer id=9 not found 
	private String errorDetail = "";     
	
	public GenericBusinessException(){		
	}
	
	/**
	 * 不要轻易使用
	 * @param cause
	 */
	public GenericBusinessException(Throwable cause){	
		super(cause);
	}
	
	public GenericBusinessException(String errorDescription, Throwable cause){	
		super(errorDescription, cause);
	}
	
    public GenericBusinessException(String errorDescription) {
        super(errorDescription);
        this.errorDescription = errorDescription;
    }
	
    public GenericBusinessException(String errorDescription , String errorDetail) {
        super(errorDescription);
        this.errorDescription = errorDescription;
        this.errorDetail = errorDetail;
    }
    public GenericBusinessException(String errorCode , String errorDescription, String errorDetail) 
    {
        super(errorDescription);
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.errorDetail = errorDetail;
    }
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}
    
}
