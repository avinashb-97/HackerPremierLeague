package com.codaglobal.HackerPremierLeague.exception;

public class InvalidTeamException extends IllegalArgumentException{

    public InvalidTeamException()
    {
        super();
    }

    public InvalidTeamException(String message)
    {
        super(message);
    }
}
