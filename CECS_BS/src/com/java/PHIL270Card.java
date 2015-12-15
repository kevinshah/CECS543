package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PHIL270Card extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.LA5, Constants.Library));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.IntegrityChip, player, 7)) {
				player.setQualityPoints(player.getQualityPoints() + 3);
				player.setLearningChip(player.getLearningChip() + 1); //need to add any chip of choice
			
		} else {
			player.setQualityPoints(player.getQualityPoints() - 3);
			
		}
		return player;

	}
		

}