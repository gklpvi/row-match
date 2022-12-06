package com.dreamgames.casestudy.repository;

import com.dreamgames.casestudy.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Integer>{
}
