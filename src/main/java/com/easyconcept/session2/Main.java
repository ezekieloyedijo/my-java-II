package com.easyconcept.session2;

public class Main {
    public static void main(String[] args) {
        MyGeneric<String> genericObj = new MyGeneric<>("Welcome text");
        genericObj.printMessage();
        genericObj.setMessage("Another message");
        genericObj.setMessage("Another message");
        genericObj.setMessage("Another message");
        genericObj.printMessage();
    }
}
