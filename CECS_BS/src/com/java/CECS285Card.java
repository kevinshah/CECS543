package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CECS285Card extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.EatClub, Constants.JapaneseGarden));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.LearningChip, player, 6)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
			
			// display pop up with Learning Chip, Craft Chip and Integrity Chip to choose a chip and 
			// then call IncrementChipBasedonLabel() method
			
		} else {
			
			player.setQualityPoints(player.getQualityPoints() - 3);
			
		}
		return player;

	}

}
