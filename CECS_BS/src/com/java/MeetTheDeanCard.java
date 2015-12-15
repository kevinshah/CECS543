package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MeetTheDeanCard extends CardBase{
	
	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.NorthHall, Constants.SouthHall));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.LearningChip, player, 3) &&
				checkPointsPrerequisite(Constants.CraftChip, player, 3) &&
				checkPointsPrerequisite(Constants.IntegrityChip, player, 3)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
			gainCards(player, 1); //method to add card to player
			
			
			} else {
			
				loseCards(player, 1);
		}
		return player;

	}

}