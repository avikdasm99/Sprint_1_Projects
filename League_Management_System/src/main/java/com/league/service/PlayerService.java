package com.league.service;

import java.util.List;

import com.league.model.Player;

public interface PlayerService {
	
	public Player addPlayer(Player player);

	public Player findByPlayerId(int pid);

	List<Player> getAllPlayers();

	String deletePlayer(int id);

	Player updatePlayer(Player player, int id);
}
