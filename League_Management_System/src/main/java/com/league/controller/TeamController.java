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

import com.league.model.Team;
import com.league.service.TeamService;

@RestController
@RequestMapping("/Team")
public class TeamController {
@Autowired
TeamService ts;

@PostMapping("/Operarion")
public String saveTeam(@RequestBody Team t) {
	return ts.addTeam(t);
}

@GetMapping("/Operarion/{id}")
public Team viewTeam(@PathVariable Integer id) {
	return ts.viewTeam(id);
}

@PutMapping("/Operarion/{id}")
public String editTeam(@RequestBody Team t, @PathVariable Integer id) {
	return ts.updateTeam(t, id);
}

@GetMapping("/Operation")
public List<Team> viewAllTeams(){
	return ts.viewAll();
}

@DeleteMapping("/Operarion/{id}")
public String deleteTeam(@PathVariable Integer id) {
	return ts.delTeam(id);
}
}
