package com.dreamgames.casestudy;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaseStudyApplication {

	public static void main(String[] args)
	{
		Timer timer = new Timer();

		// Set the time at which the task should be executed (midnight UTC)
		Date timeToStartTournament = new Date();
		timeToStartTournament.setHours(0);
		timeToStartTournament.setMinutes(0);
		timeToStartTournament.setSeconds(0);

		Date timeToFinishTournament = new Date();
		timeToFinishTournament.setHours(20);
		timeToFinishTournament.setMinutes(0);
		timeToFinishTournament.setSeconds(0);

		// Create a new TimerTask to be executed at the specified time
		TimerTask startTournament = new TimerTask() {
			public void run() {
				// This code will be executed at midnight UTC
				Date currentDate = new Date();

				// Create a EntityManagerFactory object to create EntityManager objects
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

				// Create a new EntityManager to manage the JPA entities and interact with the database
				EntityManager em = emf.createEntityManager();

				// Use the EntityManager to create a new table with the name of the current date
				Tournament newTournament = new Tournament(currentDate);
				em.persist(newTournament);

				// Close the EntityManager and EntityManagerFactory
				em.close();
				emf.close();
			}
		};
		TimerTask finishTournament = new TimerTask() {
			public void run() {
				// This code will be executed at 20:00 UTC
				Date currentDate = new Date();

				// Calculate the date of the tournament that started 5 days ago
				Date oldTournamentDate = new Date(currentDate.getTime() - (5 * 24 * 60 * 60 * 1000));

				// Create a EntityManagerFactory object to create EntityManager objects
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

				// Create a new EntityManager to manage the JPA entities and interact with the database
				EntityManager em = emf.createEntityManager();

				// Use the EntityManager to drop the table with the name of the old tournament date
				Query sql = em.createQuery("DELETE FROM Tournament WHERE startDate = :startDate");
				em.createNativeQuery(sql).executeUpdate();

				// Close the EntityManager and EntityManagerFactory
				em.close();
				emf.close();
			}
		};

		// Schedule the task to be executed at the specified time
		timer.schedule(startTournament, timeToStartTournament);
		timer.schedule(finishTournament, timeToFinishTournament);

		SpringApplication.run(CaseStudyApplication.class, args);
	}

}
