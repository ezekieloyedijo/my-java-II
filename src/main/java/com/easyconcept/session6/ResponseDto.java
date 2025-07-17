package com.easyconcept.session6;

public class ResponseDto {
    private boolean isSuccessful;
    private String message;
    private Object data;

    public ResponseDto(boolean isSuccessful, String message, Object data){
        this.isSuccessful = isSuccessful;
        this.message = message;
        this.data = data;
    }
}
