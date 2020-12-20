package com.codaglobal.HackerPremierLeague.controller;

import com.codaglobal.HackerPremierLeague.model.Team;
import com.codaglobal.HackerPremierLeague.requests.CreateTeamRequest;
import com.codaglobal.HackerPremierLeague.requests.UpdateScoreRequest;
import com.codaglobal.HackerPremierLeague.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/home")
    public String getAllTeams(@RequestParam(name = "success",required = false) Boolean success, Model model)
    {

        System.out.println(success);
        if(success!=null && success)
        {
            model.addAttribute("success", true);
        }
        else if(success!=null && !success)
        {
            model.addAttribute("fail", true);
        }
        model.addAttribute("teams",teamService.getAllTeams());
        return "home";
    }

    @PostMapping("/createteam")
    public String addTeam(CreateTeamRequest createTeamRequest, Model model)
    {
        Team team = new Team();
        team.setTeam_name(createTeamRequest.getTeam_name());
        teamService.addTeam(team);
        model.addAttribute("teams", teamService.getAllTeams());
        return "redirect:home";
    }

    @GetMapping("/result")
    public String getAllTeams(@RequestParam(name = "success") Boolean success, RedirectAttributes redirectAttributes)
    {
        redirectAttributes.addFlashAttribute("success", success);
        return "redirect:home";
    }

}
