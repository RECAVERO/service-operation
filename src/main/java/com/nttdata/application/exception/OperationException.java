package com.nttdata.application.exception;

public class OperationException extends Exception{
  private int status;
  public OperationException(){

  }

  public OperationException(int status, String msg){
    super(msg);
    this.status = status;

  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }
}
