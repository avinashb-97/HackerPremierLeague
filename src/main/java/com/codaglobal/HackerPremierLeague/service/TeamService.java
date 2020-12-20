package com.codaglobal.HackerPremierLeague.service;

import com.codaglobal.HackerPremierLeague.repository.TeamRepository;
import com.codaglobal.HackerPremierLeague.exception.InvalidTeamException;
import com.codaglobal.HackerPremierLeague.exception.TeamNotFoundException;
import com.codaglobal.HackerPremierLeague.model.Status;
import com.codaglobal.HackerPremierLeague.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private CounterService counterService;


    public List<Team> getAllTeams()
    {
        return (List<Team>) teamRepository.findAll();
    }

    public Team addTeam(Team team)
    {
        team.setId(counterService.getNextSequence("counter"));
        return teamRepository.insert(team);
    }

    public void addTeams(List<Team> teams)
    {
        for(Team team : teams)
        {
            addTeam(team);
        }
    }

    public List<Team> updateScore(Integer teamOneId, Integer teamTwoId, Integer winnerId)
    {
        if(teamOneId == teamTwoId)
        {
            throw new InvalidTeamException("Same team selected for both team one and team two");
        }
        Team teamOne = teamRepository.findById(teamOneId).orElseThrow(TeamNotFoundException::new);
        Team teamTwo = teamRepository.findById(teamTwoId).orElseThrow(TeamNotFoundException::new);

        if(winnerId == -1)
        {
            teamOne.updateScore(Status.TIE);
            teamTwo.updateScore(Status.TIE);
        }
        else if(teamOneId == winnerId)
        {
            teamOne.updateScore(Status.WIN);
            teamTwo.updateScore(Status.LOSE);
        }
        else if(teamTwoId == winnerId)
        {
            teamOne.updateScore(Status.LOSE);
            teamTwo.updateScore(Status.WIN);
        }
        teamOne = teamRepository.save(teamOne);
        teamTwo = teamRepository.save(teamTwo);

        List<Team> list = new ArrayList<>();
        list.add(teamOne);
        list.add(teamTwo);

        return list;
    }

}
