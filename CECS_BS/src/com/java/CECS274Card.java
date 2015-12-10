package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CECS274Card extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.ECS302Room, Constants.ECS308Room, Constants.ComputerLab));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.LearningChip, player, 7)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
			gainCards(player, 1);
		} else {
			player.setQualityPoints(player.getQualityPoints() - 3);
			
		}
	}

}