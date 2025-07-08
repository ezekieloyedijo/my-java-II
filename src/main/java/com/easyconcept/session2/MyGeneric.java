package com.easyconcept.session2;

// MyGenerics - The generic class
// T - The generic type - e.g String, Class etc
// Java does not allow static fields to use generic type parameter

import java.util.ArrayList;
import java.util.List;

public class MyGeneric<T>{
    private T messageBox;
    private  List<T> messageList;

    public MyGeneric(T message){
        this.messageBox = message;
        this.messageList = new ArrayList<>();
    }

    public void printMessage(){
        System.out.println(this.messageBox);
        printMessageList();
    }

    public void setMessage(T message){
        this.messageBox = message;
        addMessage(this.messageBox);
    }

    public boolean addMessage(T messageBox){
        messageList.add(messageBox);
        return true;
    }

    public List<T> getMessageList(){
        return this.messageList;
    }

    public void printMessageList(){
        List<T> messages = getMessageList();
        System.out.println(messages);
//        messages.stream().forEach(System.out::println);
    }

    public boolean removeMessage(int index){
      if(index < 0) return false;
      this.messageList.remove(index);
        printMessageList();
      return true;
    }
}
