package com.company.Fail;

public class GenderFail extends Exception{
    @Override
    public String getMessage() {
        return "Giới tính không xác định - nhập lại";
    }
}
