package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoccerGoalieCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.GeorgeAllenField));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.LearningChip, player, 3) &&
				checkPointsPrerequisite(Constants.CraftChip, player, 3)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
			
			gainCards(player, 1);//method to add card to player
		} else {
			moveToRoom(player, Constants.StudentParking);			
		}
		return player;

	}

}
