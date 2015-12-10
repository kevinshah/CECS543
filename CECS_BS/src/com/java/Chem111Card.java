package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chem111Card extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.GeorgeAllenField, Constants.JapaneseGarden, Constants.WalterPyramid, 
			Constants.StudentParking, Constants.RecCenter, Constants.WestWalkway, Constants.EastWalkway, Constants.Library, Constants.BratwrustHall, 
			Constants.LA5, Constants.ForbiddenParking));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.CraftChip, player, 6)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
			// method to add game cards
		} else {
			
			moveToRoom(player, Constants.StudentParking);
		}
	}

}