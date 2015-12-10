package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KIN253LearningRulesSoccerCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.GeorgeAllenField));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.IntegrityChip, player, 4)) {
			player.setCraftChip(player.getCraftChip() + 2);
		} else {
			moveToRoom(player, Constants.RoomOfRetirement);
			// call move method here
			
		}
	}

}