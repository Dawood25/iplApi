package com.practice.iplDashboard.controller;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.practice.iplDashboard.Model.Match;
import com.practice.iplDashboard.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MatchController {
    private MatchRepository matchRepo;
	
		@Autowired
		public  MatchController(MatchRepository matchRepository) {
			this.matchRepo=matchRepository;
			
		}
        @GetMapping(value = "/teams/{teamName}/matches")
        public List<Match> getAllMatches(HttpServletRequest request,
        @PathVariable String teamName,
        @RequestParam int year){
            System.out.println(year);
            System.out.println(teamName);
            System.out.println(matchRepo.matchesByTeamBetweenYear(teamName,
            LocalDate.of(year,01,01), 
            LocalDate.of(year+1, 1,1)));
            return matchRepo.findMatchesByYear(teamName, String.valueOf(year));
        }

     
}
