package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PressTheRightFloorCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.Elevators));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.LearningChip, player, 4)) {
			player.setCraftChip(player.getCraftChip() + 2);
		} else {
			player.setQualityPoints(player.getQualityPoints() - 2);
			
			
		}
		return player;

	}

}
