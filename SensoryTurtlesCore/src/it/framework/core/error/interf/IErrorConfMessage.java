package it.framework.core.error.interf;

public interface IErrorConfMessage {

	public long getErrorId();

	public String getApplicationId();


	public String getSourceCode();

	public String getSourceMessage();

	public String getUserCode();

	public String getUserMessage();

}