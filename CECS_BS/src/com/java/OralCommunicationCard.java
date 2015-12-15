package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OralCommunicationCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.GeorgeAllenField, Constants.JapaneseGarden, Constants.WalterPyramid, 
			Constants.StudentParking, Constants.RecCenter, Constants.WestWalkway, Constants.EastWalkway, Constants.Library, Constants.BratwrustHall, 
			Constants.LA5, Constants.ForbiddenParking));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.IntegrityChip, player, 4)) {
			player.setQualityPoints(player.getQualityPoints() + 4);
			
			// display pop up with Learning Chip, Craft Chip and Integrity Chip to choose a chip and 
			player.setChooseQuality(true);

						// then call IncrementChipBasedonLabel() method 
			
		} else {
			loseCards(player, 1);
			
		}
		return player;

	}

}