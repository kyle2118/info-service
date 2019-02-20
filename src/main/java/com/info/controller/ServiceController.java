package com.info.controller;

import com.info.domain.Club;
import com.info.domain.Player;
import com.info.repository.ClubInfo;
import com.info.repository.ClubRepository;
import com.info.repository.LeagueRepository;
import com.info.request.InsertClubRequest;
import com.info.request.InsertPlayerRequest;
import com.info.request.InvalidClubException;
import com.info.request.InvalidPlayerException;
import com.info.request.Validator;
import com.info.response.ClubUi;
import com.info.response.CountryUi;
import com.info.response.DocumentNotFoundException;
import com.info.response.LeagueUi;
import com.info.service.LeagueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;

@RestController
public class ServiceController {
    private LeagueService leagueService;
    private LeagueRepository leagueRepo;
    private ClubRepository clubRepo;
    private Validator converter;

    public ServiceController(LeagueService leagueService, LeagueRepository leagueRepo, ClubRepository clubRepo, Validator converter) {
        this.leagueService = leagueService;
        this.leagueRepo = leagueRepo;
        this.clubRepo = clubRepo;
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
            System.err.println("Club created: " + club);
            ClubInfo clubInfo = leagueService.createClub(club);
            clubRepo.deleteAll();
            clubRepo.save(clubInfo);

            response = "Club created";
        } catch (IllegalArgumentException e) {
            System.err.println("Club not created!");
            throw new InvalidClubException(e.getMessage());
        }
        return response;
    }

    @GetMapping(value = "/club/{clubName}")
    public ClubUi getClub(@PathVariable String clubName)
            throws DocumentNotFoundException {
        checkArgument(clubName != null, "Club Name must not be empty!");
        Optional<ClubInfo> clubInfo = clubRepo.findByName(clubName);
        ClubUi clubResponse;
        if (!clubInfo.isPresent()) {
            throw new DocumentNotFoundException("Club not found!");
        }
        CountryUi countryUi = new CountryUi(clubInfo.get().getLeagueInfo().getCountry(), clubInfo.get().getLeagueInfo().getContinent());
        LeagueUi leagueUi = new LeagueUi(clubInfo.get().getLeagueInfo().getName(), countryUi);
        clubResponse = new ClubUi(clubInfo.get().getName(), leagueUi);
        return clubResponse;
    }

}
