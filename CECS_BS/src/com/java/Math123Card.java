package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Math123Card extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.ECS302Room, Constants.ECS308Room));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.LearningChip, player, 5)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
		} else {
			player.setQualityPoints(player.getQualityPoints() - 3);
			loseCards(player, 1);
			
		}
	}

}
