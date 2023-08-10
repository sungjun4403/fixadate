package com.fixadate.fixadate.team.dto;

import com.fixadate.fixadate.team.entity.Team;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TeamResponse {
    private final String name;
    private final String groupColor;
    private final String description;

    public TeamResponse(Team team) {
        this.name = team.getName();
        this.groupColor = team.getGroupColor();
        this.description = team.getDescription();
    }

    @Builder
    public TeamResponse(String name, String groupColor, String description) {
        this.name = name;
        this.groupColor = groupColor;
        this.description = description;
    }
}
