package com.apitest.payloads.students;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Geo {

    @JsonProperty("lat")
    private String lat;
    @JsonProperty("lng")
    private String lng;
}
