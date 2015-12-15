package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CECS100Card extends CardBase{
	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.ECS308Room));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations)) {
			player.setCraftChip(player.getCraftChip()+1);
		}
		return player;

	}

}