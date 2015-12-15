package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuddyUpCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.GeorgeAllenField, Constants.EatClub));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations)) {
			
			// display pop up with Learning Chip and Craft Chip to choose a chip and 
			// then call IncrementChipBasedonLabel() method 
		}
		return player;
	}

}