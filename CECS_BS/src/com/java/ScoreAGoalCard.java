package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreAGoalCard extends CardBase{


	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.GeorgeAllenField));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.CraftChip, player, 3)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
			player.setIntegrityChip(player.getIntegrityChip() + 1);
		} else {
			
			moveToRoom(player, Constants.StudentParking);
		}
		return player;

	}

}