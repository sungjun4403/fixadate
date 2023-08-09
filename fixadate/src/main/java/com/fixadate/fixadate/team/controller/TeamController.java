package com.fixadate.fixadate.team.controller;


import com.fixadate.fixadate.team.dto.TeamCreate;
import com.fixadate.fixadate.team.dto.TeamResponse;
import com.fixadate.fixadate.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TeamController {
    private final TeamService teamService;

    //VIEW ONE BY GROUP ID
//    @GetMapping("/group/{teamId}")
//    public TeamResponse getById(@PathVariable Long teamId) {
//        return teamService.getById(teamId);
//    }

    //VIEW ALL BY MEMBER

    //CREATE
    @PostMapping("/group")
    public void create(@RequestBody TeamCreate teamCreate) {
        teamService.create(teamCreate);
    }

    //EDIT

    //DELETE
    @DeleteMapping("/group/{teamId}")
    public void delete(@PathVariable Long teamId) {
        teamService.delete(teamId);
    }
}
