package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LearningLinuxCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.JapaneseGarden));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.CraftChip, player, 2) &&
				checkPointsPrerequisite(Constants.IntegrityChip, player, 3)) {
			player.setQualityPoints(player.getQualityPoints() + 3);
			
			// display pop up with Learning Chip, Craft Chip and Integrity Chip to choose a chip and 
			player.setChooseQuality(true);

			// then call IncrementChipBasedonLabel() method
			
		} else {
			
			player.setQualityPoints(player.getQualityPoints() - 1);
		}
		return player;

	}

}