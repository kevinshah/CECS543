package com.java;

import java.util.ArrayList;
import com.java.*;
import java.util.Arrays;
import java.util.List;

public class ProfessorHoffmanCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.ECS302Room, Constants.ECS308Room, Constants.EatClub, 
			Constants.Elevators, Constants.NorthHall, Constants.SouthHall, Constants.RoomOfRetirement,
			Constants.CECSConference, Constants.ComputerLab));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.LearningChip, player, 3)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
			gainCards(player, 2);
			// method to add game cards
		} else {
			player.setQualityPoints(player.getQualityPoints() - 5);
			moveToRoom(player, Constants.LactationLounge);
		}
		return player;
	}

}
