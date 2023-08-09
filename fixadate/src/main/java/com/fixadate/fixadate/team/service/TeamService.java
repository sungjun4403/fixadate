package com.fixadate.fixadate.team.service;


import com.fixadate.fixadate.team.dto.TeamCreate;
import com.fixadate.fixadate.team.dto.TeamResponse;
import com.fixadate.fixadate.team.entity.Team;
import com.fixadate.fixadate.team.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public void create(TeamCreate teamCreate) {
        Team team = Team.builder()
                .name(teamCreate.getName())
                .groupColor(teamCreate.getGroupColor())
                .description(teamCreate.getDescription())
                .build();

        teamRepository.save(team);
    }

    public void delete(Long teamId) {
        teamRepository.deleteById(teamId);
    }

//    public TeamResponse getById(Long teamId) {
//
//    }
}
