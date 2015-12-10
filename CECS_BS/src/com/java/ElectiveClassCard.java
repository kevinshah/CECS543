package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ElectiveClassCard extends CardBase{


	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.Library));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.LearningChip, player, 2)) {
			player.setLearningChip(player.getLearningChip() + 1);
			
			gainCards(player, 1);//method to add card to player
		} else {
			player.setQualityPoints(player.getQualityPoints() - 2);
						
		}
	}

}