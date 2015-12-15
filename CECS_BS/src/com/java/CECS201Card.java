package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CECS201Card extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.ECS302Room, Constants.ECS308Room, Constants.ComputerLab));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.CraftChip, player, 8)) {
			player.setLearningChip(player.getLearningChip() + 1);
			player.setCraftChip(player.getCraftChip() + 1);
			player.setIntegrityChip(player.getIntegrityChip() + 1);
		} else {
			player.setQualityPoints(player.getQualityPoints() - 3);
			loseCards(player, 1);
			
		}
		return player;

	}
	
	
}