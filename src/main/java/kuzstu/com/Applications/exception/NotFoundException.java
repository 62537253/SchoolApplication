package kuzstu.com.Applications.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
