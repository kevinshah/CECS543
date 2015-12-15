package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ResearchCompilersCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.Library));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations)) {
			player.setLearningChip(player.getLearningChip()+1);
		}
		return player;

	}
}

