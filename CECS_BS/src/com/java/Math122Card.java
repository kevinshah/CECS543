package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Math122Card extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.Library));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations)) {
			
			// display pop up with Learning Chip and Integrity Chip to choose a chip and 
			player.setChooseQuality(true);

			// then call IncrementChipBasedonLabel() method 
		}
		return player;

	}

}