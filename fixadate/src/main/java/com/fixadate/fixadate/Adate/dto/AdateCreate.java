package com.fixadate.fixadate.Adate.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdateCreate {
    private String title;
    private String notes;
    private String location;
    private Boolean ifAllDay;
    private String calColor;
    private Boolean ifMovable;
//    private
}
