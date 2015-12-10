package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TheOutPostCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.GeorgeAllenField, Constants.JapaneseGarden, Constants.WalterPyramid, 
			Constants.StudentParking, Constants.RecCenter, Constants.WestWalkway, Constants.EastWalkway, Constants.Library, Constants.BratwrustHall, Constants.LA5));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations)) {
			
			// display pop up with Learning Chip, Craft Chip and Integrity Chip to choose a chip and 
						// then call IncrementChipBasedonLabel() method 
			
		} 
	}

}