package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoudBuzzingCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.EatClub));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.CraftChip, player, 3)) {
			
			// display pop up with Learning Chip, Craft Chip and Integrity Chip to choose a chip and 
						// then call IncrementChipBasedonLabel() method 
		} else {
			player.setQualityPoints(player.getQualityPoints() - 2);
			
		}
		return player;

	}

}
