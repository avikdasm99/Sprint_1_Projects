package com.league.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.league.model.Player;
import com.league.repo.PlayerRepo;
import com.league.service.PlayerService;
@Service
public class PlayerServiceImpl implements PlayerService{

	private PlayerRepo pr;
	@Override
	public Player addPlayer(Player player) {
		return pr.save(player);
	}

	@Override
	public Player findByPlayerId(int pid) {
		return pr.findById(pid).get();
	}

	@Override
	public List<Player> getAllPlayers() {
		return pr.findAll();
	}

	@Override
	public String deletePlayer(int pid) {
		pr.deleteById(pid);
		return "----Player removed succsessfully----";
	}

	@Override
	public Player updatePlayer(Player player, int pid) {
		Player py = pr.findById(pid).get();
		py.setAge(player.getAge());
		py.setPname(player.getPname());
		py.setPos(player.getPos());
		return pr.save(py);
	}
}
