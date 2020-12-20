package com.codaglobal.HackerPremierLeague.model;

import com.codaglobal.HackerPremierLeague.constants.ScoreConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "team")
public class Team {

    @Id
    private Integer id;
    private String team_name;
    private Integer wins = 0;
    private Integer losses = 0;
    private Integer ties = 0;
    private Integer score = 0;

    public Team() {
        super();
    }

    public Team(Integer id, String team_name, Integer wins, Integer losses, Integer ties, Integer score) {
        super();
        this.id = id;
        this.team_name = team_name;
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public Integer getTies() {
        return ties;
    }

    public void setTies(Integer ties) {
        this.ties = ties;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer updateScore(Status status)
    {
        if(status == Status.WIN)
        {
            this.score += ScoreConstants.WIN_SCORE;
            this.wins += 1;
        }
        else if(status == Status.LOSE)
        {
            this.score += ScoreConstants.LOSE_SCORE;
            this.losses += 1;
        }
        else if(status == Status.TIE)
        {
            this.score += ScoreConstants.TIE_SCORE;
            this.ties += 1;
        }
        return this.score;
    }
}
