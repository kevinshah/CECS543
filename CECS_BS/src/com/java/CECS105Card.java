package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CECS105Card extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.ECS302Room, Constants.ECS308Room));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations)) {
			player.setLearningChip(player.getLearningChip()+1);
		}
	}

}
