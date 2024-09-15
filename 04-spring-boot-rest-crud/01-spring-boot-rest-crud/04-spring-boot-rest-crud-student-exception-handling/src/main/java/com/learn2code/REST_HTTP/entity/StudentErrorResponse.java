package com.learn2code.REST_HTTP.entity;

public class StudentErrorResponse {
    private int status;
    private String message;
    private long timestamp;

    public StudentErrorResponse(){}
    public StudentErrorResponse(int status,String message,long timestamp){
        this.status=status;
        this.message=message;
        this.timestamp=timestamp;
    }

    public void setStatus(int status){
        this.status=status;
    }
    public int getStatus(){
        return status;
    }

    public void setMessage(String message){
        this.message=message;
    }
    public String getMessage(){
        return message;
    }

    public void setTimestamp(long timestamp){
        this.timestamp=timestamp;
    }
    public long getTimestamp(){
        return timestamp;
    }

}
