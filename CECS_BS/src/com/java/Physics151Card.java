package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Physics151Card extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.ECS308Room));
	@Override
	public void play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations) && 
				checkPointsPrerequisite(Constants.CraftChip, player, 3)) {
			player.setQualityPoints(player.getQualityPoints() + 5);
		} else {
			player.setQualityPoints(player.getQualityPoints() - 3);
			
		}
	}

}