package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CECS282Card extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.ECS302Room, Constants.ECS308Room, Constants.EatClub, 
			Constants.Elevators, Constants.NorthHall, Constants.SouthHall, Constants.LactationLounge,
			Constants.CECSConference, Constants.ComputerLab, Constants.RoomOfRetirement));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.IntegrityChip, player, 8)&& 
				checkPointsPrerequisite(Constants.LearningChip, player, 8)&& 
				checkPointsPrerequisite(Constants.CraftChip, player, 8)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
			
		} else {
			player.setQualityPoints(player.getQualityPoints() - 2);
			loseCards(player, 1);
			
		}
	}

}