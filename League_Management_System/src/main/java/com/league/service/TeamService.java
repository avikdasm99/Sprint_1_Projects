package com.league.service;

import java.util.List;

import com.league.model.Team;

public interface TeamService {
	public String addTeam(Team a);
	public String updateTeam(Team b, Integer id);
	public String delTeam(Integer id);
	public Team viewTeam(Integer id);
	public List<Team> viewAll();
}
