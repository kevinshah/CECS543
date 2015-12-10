package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarPoolCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.StudentParking, Constants.ForbiddenParking));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.IntegrityChip, player, 5)) {
			player.setQualityPoints(player.getQualityPoints() + 3);
			gainCards(player, 1);
		} else {
			player.setQualityPoints(player.getQualityPoints() - 2);
			
		}
	}

}