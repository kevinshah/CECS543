package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingViolationCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.ForbiddenParking));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations)) {
			player.setLearningChip(player.getLearningChip() + 1);
			loseCards(player, 1);
			player.setLearningChip(player.getLearningChip() + 1);
						
		} 
	}
	
	

}