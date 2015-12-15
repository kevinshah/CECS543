package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PHYS152Card extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.LA5, Constants.Library));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.IntegrityChip, player, 7)) {
				player.setQualityPoints(player.getQualityPoints() + 5);
				
				// display pop up with Learning Chip, Craft Chip and Integrity Chip to choose a chip and 
				player.setChooseQuality(true);

				// then call IncrementChipBasedonLabel() method
			
		} else {
			
			loseCards(player, 1);
			
		}
		return player;

	}
		

}