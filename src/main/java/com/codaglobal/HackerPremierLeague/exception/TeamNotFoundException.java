package com.codaglobal.HackerPremierLeague.exception;

public class TeamNotFoundException extends RuntimeException{

    public TeamNotFoundException()
    {
        super();
    }

    public TeamNotFoundException(String message)
    {
        super(message);
    }
}
