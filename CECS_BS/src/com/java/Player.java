package com.java;

import java.util.List;

public class Player {
	private String currentLocation;
	private int learningChip;
	private int craftChip;
	private int integrityChip;
	private int qualityPoints;
	private String chosenLabel;
    private String desLoc;
    private boolean discardCard=false;
    private boolean chooseQuality=false;
	
	private List<GameCard> playerCards;
	
	public String getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}
	public int getLearningChip() {
		return learningChip;
	}
	public void setLearningChip(int learningChip) {
		this.learningChip = learningChip;
	}
	public int getCraftChip() {
		return craftChip;
	}
	public void setCraftChip(int craftChip) {
		this.craftChip = craftChip;
	}
	public int getIntegrityChip() {
		return integrityChip;
	}
	public void setIntegrityChip(int integrityChip) {
		this.integrityChip = integrityChip;
	}
	public int getQualityPoints() {
		return qualityPoints;
	}
	public void setQualityPoints(int qualityPoints) {
		this.qualityPoints = qualityPoints;
	}
	public List<GameCard> getPlayerCards() {
		return playerCards;
	}
	public void setPlayerCards(List<GameCard> playerCards) {
		this.playerCards = playerCards;
	}
	public String getChosenLabel() {
		return chosenLabel;
	}
	public void setChosenLabel(String chosenLabel) {
		this.chosenLabel = chosenLabel;
	}
	public boolean isChooseQuality() {
		 return chooseQuality;
	}
	public void setChooseQuality(boolean chooseQuality) {
		 this.chooseQuality = chooseQuality;
	}
	public boolean isDiscardCard() {
		return discardCard;
	}
	public void setDiscardCard(boolean discardCard) {
		 this.discardCard = discardCard;
	}
}
