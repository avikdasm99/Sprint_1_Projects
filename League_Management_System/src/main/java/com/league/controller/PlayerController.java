package com.league.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.league.model.Player;
import com.league.service.PlayerService;

@RestController
@RequestMapping("/Player")
public class PlayerController {
@Autowired
PlayerService ps;

@PostMapping("/Operation")
public Player savePlayer(@RequestBody Player p) {
	return ps.addPlayer(p);
}

@GetMapping("/Operarion/{id}")
public Player viewPlayer(@PathVariable Integer id) {
	return ps.findByPlayerId(id);
}

@PutMapping("/Operarion/{id}")
public Player editPlayer(@RequestBody Player p, @PathVariable Integer id) {
	return ps.updatePlayer(p, id);
}

@GetMapping("/Operation")
public List<Player> viewAllPlayers(){
	return ps.getAllPlayers();
}

@DeleteMapping("/Operarion/{id}")
public String deletePlayer(@PathVariable Integer id) {
	return ps.deletePlayer(id);
}
}
