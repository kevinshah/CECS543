package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ENGL317Card extends CardBase{
	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.LA5));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.CraftChip, player, 6)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
		} else {
			moveToRoom(player, Constants.StudentParking);
			
		}
		return player;

	}

}