package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.HashSet;
import java.util.Set;

public class LabyrinthBuilder {
	
	private int width;

	private int height;

	private Position exitPosition;

	private Set<Position> forbiddenCellsPositions;
	
	public LabyrinthBuilder(){
		this.forbiddenCellsPositions = new HashSet<Position>();
	}
	
	
	public void setWidth(int width) throws IllegalArgumentException
	{
		if (width <0) throw new IllegalArgumentException();
		
		this.width= width;		
	}
	
	public void setHeight(int heigth) throws IllegalArgumentException
	{
		if(height <0) throw new IllegalArgumentException();
		this.height=heigth;
	}
	
	public void setExitPosition(Position exitPosition) throws IllegalArgumentException
	{
		if(exitPosition.getX() <0 || exitPosition.getY() <0 ) throw new IllegalArgumentException();
		this.exitPosition=exitPosition;
	}
	
	public void addForbiddenCellPos(Position forbiddenCellPosition) throws IllegalArgumentException
	{
		if(forbiddenCellPosition.getX() <0 || forbiddenCellPosition.getY() <0 ) throw new IllegalArgumentException();
		this.forbiddenCellsPositions.add(forbiddenCellPosition);
	}
	
	public void addForbiddenCellPos(Set<Position> forbiddenCellPosition) throws IllegalArgumentException
	{
		for( Position forbiddenCell : forbiddenCellPosition){
			
			if(forbiddenCell.getX() <0 || forbiddenCell.getY() <0 ) throw new IllegalArgumentException();
			this.forbiddenCellsPositions.add(forbiddenCell);
		}
	}
	
	public Labyrinth getLabyrinth() throws IllegalArgumentException
	{
		if(this.exitPosition.getX() > this.width || this.exitPosition.getY() > this.height) throw new IllegalArgumentException();
		for(Position forbiddenCell : this.forbiddenCellsPositions){
			if(forbiddenCell.getX() > this.width || forbiddenCell.getY() > this.height)throw new IllegalArgumentException();
			if(forbiddenCell.getX() == this.exitPosition.getX() && forbiddenCell.getY() == this.exitPosition.getY())throw new IllegalArgumentException();
		}
		return new Labyrinth(this.width,this.height, this.forbiddenCellsPositions, this.exitPosition);
	}
}
