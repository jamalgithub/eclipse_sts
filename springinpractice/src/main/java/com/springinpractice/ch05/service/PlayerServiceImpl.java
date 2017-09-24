package com.springinpractice.ch05.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springinpractice.ch05.domain.Guardian;
import com.springinpractice.ch05.domain.Player;
import com.springinpractice.ch05.domain.search.PlayerSearchCriteria;
import com.springinpractice.ch05.form.AccountForm;

/**
 * @author Joshua White
 */
@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

	protected List<Player> players = new ArrayList<Player>();
	
	{
		//Names generated using http://www.fakenamegenerator.com		
		Guardian robinBryce = new Guardian("Robin", "Bryce", "4149984442", "826 Larry Street", null, "Milwaukee", "WI", "53210", "RobinJBryce@example.com", "password");					
		robinBryce.addPlayer(new Player(robinBryce, "Anne", "Bryce", (new GregorianCalendar(2002, 2, 11)).getTime()));
		robinBryce.addPlayer(new Player(robinBryce, "Jack", "Bryce", (new GregorianCalendar(2000, 9, 19)).getTime()));
		
		players.addAll(robinBryce.getPlayers());
	}	
	
	@Override
	public Player findExistingPlayer(PlayerSearchCriteria criteria) {
		Player player = null;				
		//Stub Implementation
		player = players.get(0);		
		return player;
	}

	@Override
	public String createNewAccount(AccountForm newAccountForm) {			
		String userName = "";		
		if (newAccountForm != null && newAccountForm.getGuardian() != null) {
			userName = newAccountForm.getGuardian().getUsername();
		}		
		return userName;
	}

}