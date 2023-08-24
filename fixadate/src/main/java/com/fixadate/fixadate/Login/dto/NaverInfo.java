package com.fixadate.fixadate.Login.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NaverInfo {  //is an element of NaverInfoResponse
    private String id;
    private String profile_image;
    private String gender;
    private String name;
    private String birthday;
    private String birthyear;
}
