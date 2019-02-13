package com.info.controller;

import com.info.domain.Player;
import com.info.request.Converter;
import com.info.request.InsertPlayerRequest;
import com.info.service.LeagueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    private LeagueService leagueService;
    private Converter converter;

    public ServiceController(LeagueService leagueService, Converter converter) {
        this.leagueService = leagueService;
        this.converter = converter;
    }

    @GetMapping(value = "player/{playerName}")
    public String getPlayer(@PathVariable String playerName) {
        return "This is " + playerName;
    }

    @PostMapping(value = "player")
    public boolean insertPlayer(@RequestBody InsertPlayerRequest request) {

        Player player = converter.convertToPlayer(request);

        System.err.println(player);

        return true;
    }
}
