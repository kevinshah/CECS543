package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FallInThePondCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.JapaneseGarden));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.LearningChip, player, 3)) {
			player.setCraftChip(player.getCraftChip() + 1);
			player.setIntegrityChip(player.getIntegrityChip() + 1);
		} else {
			
			moveToRoom(player, Constants.LactationLounge);
		}
		return player;

	}

}