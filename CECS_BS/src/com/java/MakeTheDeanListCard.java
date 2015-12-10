package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeTheDeanListCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.NorthHall, Constants.SouthHall));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.LearningChip, player, 6)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
			
		} else {
			
			moveToRoom(player, Constants.StudentParking);
		}
	}

}