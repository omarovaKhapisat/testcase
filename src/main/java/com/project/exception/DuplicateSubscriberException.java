package com.project.exception;

public class DuplicateSubscriberException extends RuntimeException {
    private static final String MESSAGE = "Subscriber with name %s and phone number %s already exists";
    
    public DuplicateSubscriberException(String name, String phoneNumber) {
        super(MESSAGE);
    }
}
