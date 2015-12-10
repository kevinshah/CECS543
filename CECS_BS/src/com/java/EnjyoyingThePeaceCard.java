package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnjyoyingThePeaceCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.JapaneseGarden));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations)) {
			
			// display pop up with Learning Chip and Integrity Chip to choose a chip and 
						// then call IncrementChipBasedonLabel() method 
			
		}
	}

}
