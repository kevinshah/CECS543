package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnjoyingNatureCard extends CardBase{

	List<String> validLocations = new ArrayList<String>(Arrays.asList(Constants.GeorgeAllenField, Constants.JapaneseGarden, Constants.WalterPyramid, 
			Constants.StudentParking, Constants.RecCenter, Constants.WestWalkway, Constants.EastWalkway, Constants.Library, Constants.BratwrustHall, 
			Constants.LA5, Constants.ForbiddenParking));
	@Override
	public Player play(Player player) {
		// TODO Auto-generated method stub
		if(isValidLocation(player, validLocations)) {
			player.setCraftChip(player.getCraftChip() + 1);
			moveToRoom(player, Constants.LactationLounge);
			
		} 
		return player;

	}

}
