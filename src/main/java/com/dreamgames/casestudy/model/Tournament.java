package com.dreamgames.casestudy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tournament")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tournamentid;
    private String tournamentname;
    private Date tournamentStartDate;
    private Boolean finished;

    public Tournament() {
    }

    public Tournament(String tournamentname, Date tournamentStartDate, Boolean finished) {
        this.tournamentname = tournamentname;
        this.tournamentStartDate = tournamentStartDate;
        this.finished = finished;
    }
    
    public Integer getTournamentid() {
        return tournamentid;
    }
    public void setTournamentid(Integer tournamentid) {
        this.tournamentid = tournamentid;
    }
    public String getTournamentname() {
        return tournamentname;
    }
    public void setTournamentname(String tournamentname) {
        this.tournamentname = tournamentname;
    }
    public Date getTournamentStartDate() {
        return tournamentStartDate;
    }
    public void setTournamentStartDate(Date tournamentStartDate) {
        this.tournamentStartDate = tournamentStartDate;
    }
    public Boolean getFinished() {
        return finished;
    }
    public void setFinished(Boolean finished) {
        this.finished = finished;
    }
}