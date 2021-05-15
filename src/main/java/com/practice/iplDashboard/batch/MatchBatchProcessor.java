package com.practice.iplDashboard.batch;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.batch.item.ItemProcessor;

import com.practice.iplDashboard.Model.Match;

public class MatchBatchProcessor implements ItemProcessor<MatchInput, Match> {

	@Override
	public Match process(final MatchInput matchInput) throws Exception {

		final Match match = new Match();
		match.setId(Long.parseLong(matchInput.getId()));
		match.setCity(matchInput.getCity());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		match.setDate(LocalDate.parse(matchInput.getDate(), formatter));
		match.setPlayerOfMatch(matchInput.getPlayer_of_match());
		match.setResult(matchInput.getResult());
		match.setResultMargin(matchInput.getResult_margin());
		match.setWinner(matchInput.getWinner());
		match.setTossDecision(matchInput.getToss_decision());
		match.setTossWinner(matchInput.getToss_winner());
		match.setUmpire1(matchInput.getUmpire1());
		match.setUmpire2(matchInput.getUmpire2());
		match.setVenue(matchInput.getVenue());
		String teamFirst = "";
		String teamSec = "";
		if (match.getTossDecision().equals("bat")) {
			teamFirst = match.getTossWinner();
			teamSec = matchInput.getTeam1().equals(matchInput.getToss_winner()) ? matchInput.getTeam2()
					: matchInput.getTeam1();
		} else {
			teamSec = match.getTossWinner();
			teamFirst = matchInput.getTeam1().equals(matchInput.getToss_winner()) ? matchInput.getTeam2()
					: matchInput.getTeam1();
		}
		match.setTeam1(teamFirst);
		match.setTeam2(teamSec);

		return match;
	}

}
