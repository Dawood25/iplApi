package com.practice.iplDashboard.batch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.practice.iplDashboard.Model.Team;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

	private final JdbcTemplate jdbcTemplate;
	private EntityManager em;

	@Autowired
	public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate, EntityManager em) {
		this.jdbcTemplate = jdbcTemplate;
		this.em = em;
	}

	@Override
	@Transactional
	public void afterJob(JobExecution jobExecution) {
		Map<String, Team> map = new HashMap<>();
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {

			jdbcTemplate
					.query("SELECT team1,team2,date FROM match",
							(rs, row) -> "Team1 " + rs.getString(1) + " team2 " + rs.getString(2) + " date "
									+ rs.getString(3))
					.forEach(str -> System.out.println("Found <" + str + "> in the database."));
			List<Object[]> list = em
					.createQuery("select distinct m.team1,count(*) from Match m group by team1", Object[].class)
					.getResultList();
			list.stream().map(e -> new Team((String) e[0], (long) e[1])).forEach(e -> map.put(e.getName(), e));

			em.createQuery("select distinct m.team2,count(*) from Match m group by team2", Object[].class)
					.getResultList();
			list.stream().forEach(e -> {
				Team team = map.get((String) e[0]);
				team.setTotalMatches(team.getTotalMatches() + (long) e[1]);
			});

			em.createQuery("select distinct m.winner,count(*) from Match m group by winner", Object[].class)
					.getResultList().stream().filter(e -> map.get((String) (e[0])) != null).forEach(e -> {
						Team team = map.get((String) e[0]);

						team.setMatchWon((long) e[1]);
					});
			map.values().forEach(e -> System.out.println(e));
			map.values().forEach(e -> em.persist(e));
		}
	}
}