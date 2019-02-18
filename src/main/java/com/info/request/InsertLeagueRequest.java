package com.info.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class InsertLeagueRequest {
    private String name;
    private String country;
    private String continent;
}
