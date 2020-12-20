package com.codaglobal.HackerPremierLeague.requests;

public class UpdateScoreRequest {

    private Integer team_one;
    private Integer team_two;
    private Integer winner_id;

    public Integer getTeam_one() {
        return team_one;
    }

    public void setTeam_one(Integer team_one) {
        this.team_one = team_one;
    }

    public Integer getTeam_two() {
        return team_two;
    }

    public void setTeam_two(Integer team_two) {
        this.team_two = team_two;
    }

    public Integer getWinner_id() {
        return winner_id;
    }

    public void setWinner_id(Integer winner_id) {
        this.winner_id = winner_id;
    }
}
