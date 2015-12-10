package com.java;

import java.util.ArrayList;
import java.util.List;


public abstract class CardBase {
	public abstract void play(Player player);
	
	/**
	 * check if current location is valid or not.
	 * @param player
	 * @param validLocations
	 * @return
	 */
	public static boolean isValidLocation(Player player, List<String> validLocations) {
		
		boolean isValid = false;
		
		if(validLocations != null && validLocations.size() > 0) {
			for(String s: validLocations ){
				if(player.getCurrentLocation().toUpperCase().equals(s.toUpperCase())) {
					isValid = true;
					break;
				}
			}

		}
		
		return isValid;
	}
	
	/**
	 * check if the points prerequisite is satisfied or not.
	 * @param type
	 * @param player
	 * @param typeCount
	 * @return
	 */
	public static boolean checkPointsPrerequisite(String type, Player player, int typeCount){
		boolean isValid = false;
		
		if(type != null ) {
			if(type.equalsIgnoreCase(Constants.IntegrityChip)) {
				if(player.getIntegrityChip() >= typeCount) {
					isValid = true;
				}
			} else if(type.equalsIgnoreCase(Constants.CraftChip)) {
				if(player.getCraftChip() >= typeCount) {
					isValid = true;
				}
			} else if(type.equalsIgnoreCase(Constants.LearningChip)) {
				if(player.getLearningChip() >= typeCount) {
					isValid = true;
				}
			}else if(type.equalsIgnoreCase(Constants.QualityPoints)) {
				if(player.getQualityPoints() >= typeCount) {
					isValid = true;
				}
			}
		
		
		} 
		
		
		return isValid;
		
	}
	
	/** 
	 * choose chip of your choice
	 */
	
	public static void IncrementChipBasedonLabel(Player player)
	{
		if(player.getChosenLabel() != null ) {
			if(player.getChosenLabel().equalsIgnoreCase(Constants.IntegrityChip)) {
				player.setIntegrityChip(player.getIntegrityChip() + 1);
			}
			 else if(player.getChosenLabel().equalsIgnoreCase(Constants.CraftChip)) {
				 player.setCraftChip(player.getCraftChip() + 1);
			 }
				
			else if(player.getChosenLabel().equalsIgnoreCase(Constants.LearningChip)) {
				 player.setLearningChip(player.getLearningChip() + 1);
			 }
			
		}
	player.setChosenLabel(null);
		
	}
	
	/**
	 * move the player to new location.
	 * @param player
	 * @param newLocation
	 */
	public static void moveToRoom(Player player, String newLocation) {
	
		//TODO implement this.
		player.setCurrentLocation(newLocation);
	}
	
	public static void loseCards(Player player, int numCardsToLose) {
		if(player.getPlayerCards() != null && player.getPlayerCards().size() >= numCardsToLose) {
			for(int i=0; i <numCardsToLose; i++) {
				player.getPlayerCards().remove(0);
			}
			
		}
		
	}
	
	public static void gainCards(Player player, int numCardsToAdd) {
		if(player.getPlayerCards() == null) {
			player.setPlayerCards(new ArrayList<GameCard>());
		}
		
		for(int i=0; i <numCardsToAdd; i++) {
			GameCard gc = new GameCard();
			player.getPlayerCards().add(gc);
		}
		
	}
	
	
	
}
