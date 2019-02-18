package com.info.controller;

import com.info.domain.Club;
import com.info.domain.League;
import com.info.domain.Player;
import com.info.repository.LeagueInfo;
import com.info.repository.LeagueRepository;
import com.info.request.InsertClubRequest;
import com.info.request.InsertLeagueRequest;
import com.info.request.InsertPlayerRequest;
import com.info.request.InvalidClubException;
import com.info.request.InvalidLeagueException;
import com.info.request.InvalidPlayerException;
import com.info.request.Validator;
import com.info.service.LeagueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    private LeagueService leagueService;
    private LeagueRepository leagueRepo;
    private Validator converter;

    public ServiceController(LeagueService leagueService, LeagueRepository leagueRepo, Validator converter) {
        this.leagueService = leagueService;
        this.leagueRepo = leagueRepo;
        this.converter = converter;
    }

    @GetMapping(value = "/player/{playerName}")
    public String getPlayer(@PathVariable String playerName) {
        return "This is " + playerName;
    }

    @PostMapping(value = "/player")
    public boolean insertPlayer(@RequestBody InsertPlayerRequest request) throws InvalidPlayerException {
        try {
            Player player = converter.convertToPlayer(request);
            System.err.println(player);
        } catch (Exception e) {
            System.err.println("Player not created");
            throw new InvalidPlayerException(e.getMessage());
        }
        return true;
    }

    @PostMapping(value = "/club")
    public String insertClub(@RequestBody InsertClubRequest request) throws InvalidClubException {
        String response;
        try {
            Club club = converter.convertToClub(request);
            response = "Club created";
            System.err.println("Club created: " + club);
        } catch (IllegalArgumentException e) {
            System.err.println("Club not created!");
            throw new InvalidClubException(e.getMessage());
        }
        return response;
    }

    @PostMapping(value = "/league")
    public String insertLeague(@RequestBody InsertLeagueRequest request) throws InvalidLeagueException {
        String response;
        try {
            League league = converter.convertToLeague(request);
            LeagueInfo leagueInfo = LeagueInfo.of(league.getName(), league.getCountry().getName());
            leagueRepo.save(leagueInfo);
            response = "Club created";
            System.err.println("League created: " + league);
        } catch (IllegalArgumentException e) {
            System.err.println("Club not created!");
            throw new InvalidLeagueException(e.getMessage(), e);
        }
        return response;
    }
}
