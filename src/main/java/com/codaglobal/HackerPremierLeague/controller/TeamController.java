package com.codaglobal.HackerPremierLeague.controller;

import com.codaglobal.HackerPremierLeague.service.TeamService;
import com.codaglobal.HackerPremierLeague.model.Team;
import com.codaglobal.HackerPremierLeague.requests.CreateTeamRequest;
import com.codaglobal.HackerPremierLeague.requests.UpdateScoreRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getAllTeams()
    {
        return teamService.getAllTeams();
    }

    @PostMapping
    public Team addTeam(@RequestBody Team team)
    {
        return teamService.addTeam(team);
    }


    @PostMapping("/bulkimport")
    public void addTeam(@RequestBody List<Team> teams)
    {
        teamService.addTeams(teams);
    }

    @PostMapping("/result")
    public List<Team> updateScores(@RequestBody UpdateScoreRequest updateScoreRequest)
    {
        return teamService.updateScore(updateScoreRequest.getTeam_one(), updateScoreRequest.getTeam_two(), updateScoreRequest.getWinner_id());
    }

}
