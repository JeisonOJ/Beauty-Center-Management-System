package com.jeison.beautycentermanagementsytem.utils.messages;

public class ErrorMessages {

    public static String idNotFound(String entity){
        final String message = "There are no records in %s with that Id";
        return String.format(entity, message);
    }

}
