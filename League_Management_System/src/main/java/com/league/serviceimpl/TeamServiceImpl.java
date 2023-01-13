package com.league.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.league.exception.TeamNotFoundException;
import com.league.model.Player;
import com.league.model.Team;
import com.league.repo.TeamRepo;
import com.league.service.TeamService;
@Service
public class TeamServiceImpl implements TeamService{
	@Autowired
	TeamRepo tr;
	@Override
	public String addTeam(Team a) {
		Player p = new Player();
		List<Player> pl = new ArrayList<>();
		p.setAge(20);
		p.setPname("Sankalpa");
		p.setPos("WF");
		p.setTm(a);
		pl.add(p);
		a.setPlayerList(pl);
		for(Player pr : a.getPlayerList()) {
			pr.setTm(a);
		}
		tr.save(a);
		return "----Team Registered Successfully----";
	}

	@Override
	public String updateTeam(Team b, Integer id) {
		Team tm = tr.findById(id).orElseThrow(()->new TeamNotFoundException("--No Such Team Exists In Table--"));
		tm.setLoc(b.getLoc());
	//	tm.setDiv(b.getDiv());
		tm.setTname(b.getTname());
		tm.setYoe(b.getYoe());
		tr.save(tm);
		return "----Updated Succsessfully----";
	}

	@Override
	public String delTeam(Integer id) {
		tr.deleteById(id);
		return "----Registration Cancelled Succsessfully With Team Id = "+id + "----";
	}

	@Override
	public Team viewTeam(Integer id) {
		Optional<Team> pllist = tr.findById(id);
		return pllist.get();
	}

	@Override
	public List<Team> viewAll() {
		return tr.findAll();
	}
 
}
