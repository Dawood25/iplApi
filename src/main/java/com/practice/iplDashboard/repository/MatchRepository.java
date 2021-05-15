package com.practice.iplDashboard.repository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.practice.iplDashboard.Model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {
	List<Match> findByTeam1OrTeam2OrderByDateDesc(String name1,String name2,Pageable pageable);
	List<Match> findByDateBetweenOrderByDate(LocalDate start,LocalDate end);
	
	@Query("select m from Match m where (m.team1 = :teamName or m.team2 = :teamName) and m.date between :start and :end order by date desc")
    List<Match> matchesByTeamBetweenYear(
        @Param("teamName") String teamName, 
        @Param("start") LocalDate dateStart, 
        @Param("end") LocalDate dateEnd
    );
	default List<Match> findLatestMatchByTeamName(String teamName,int count) {
		Pageable pagebale=PageRequest.of(0, count);
		List<Match> matches=findByTeam1OrTeam2OrderByDateDesc(teamName, teamName,pagebale);		
		return matches;
	}
	default List<Match> findMatchesByYear(String teamName,String year){
		DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		List<Match> matchesByDate=findByDateBetweenOrderByDate(LocalDate.parse("01/01/"+year, df), LocalDate.parse("30/12/"+year,df));
            
            
		return matchesByDate.stream().filter(e->e.getTeam1().equalsIgnoreCase(teamName) || e.getTeam2().equalsIgnoreCase(teamName)).collect(Collectors.toList());
	}
}
