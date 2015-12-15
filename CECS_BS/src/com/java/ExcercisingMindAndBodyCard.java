package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcercisingMindAndBodyCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.RecCenter));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations)) {
			player.setIntegrityChip(player.getIntegrityChip()+1);
		}
		return player;

	}

}
