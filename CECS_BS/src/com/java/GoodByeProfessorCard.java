package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GoodByeProfessorCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.RoomOfRetirement));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.LearningChip, player, 6) &&
				checkPointsPrerequisite(Constants.CraftChip, player, 6) &&
				checkPointsPrerequisite(Constants.IntegrityChip, player, 6)) {
			player.setQualityPoints(player.getQualityPoints() + 10);
		} else {
			loseCards(player, 1);
			// leave this card in RoR
			
		}
	}
	
	

}