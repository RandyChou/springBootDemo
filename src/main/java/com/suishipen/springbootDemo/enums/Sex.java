package com.suishipen.springbootDemo.enums;

public enum Sex {
	NONE(0), MALE(1), FEMALE(2);
	
	private final int code;

    private Sex(int code) {
        this.code = code;
    }

    public static Sex fromCode(int code) {
        if (code == 1) {
            return MALE;
        } else if (code == 2) {
            return FEMALE;
        } else {
        	return NONE;
        }
        
    }

    public int getCode() {
        return code;
    }
}
