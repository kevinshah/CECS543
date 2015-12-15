package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearningNetbeansCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.LactationLounge));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.LearningChip, player, 3)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
		} else {
			player.setQualityPoints(player.getQualityPoints() - 3);
						
		}
		return player;

	}

}
