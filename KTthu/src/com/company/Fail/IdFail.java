package com.company.Fail;

public class IdFail extends Exception{
    @Override
    public String getMessage() {
        return "Id bị trùng";
    }
}
