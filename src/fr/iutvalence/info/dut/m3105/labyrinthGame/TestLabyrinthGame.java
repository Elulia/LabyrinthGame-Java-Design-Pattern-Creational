package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.HashSet;
import java.util.Set;

/**
 * Test application for labyrinth game
 * 
 */
public class TestLabyrinthGame
{
	/**
	 * Application's main
	 * 
	 * @param args
	 *            command-line arguments (none expected here)
	 */
	public static void main(String[] args)
	{
		
		LabyrinthBuilder laby = new LabyrinthBuilder();

		Set<Position> blockPositions = new HashSet<Position>();
		blockPositions.add(new Position(2,0));
		blockPositions.add(new Position(3,0));
		blockPositions.add(new Position(1,0));
		blockPositions.add(new Position(0,2));
		blockPositions.add(new Position(1,2));
		blockPositions.add(new Position(3,2));
		blockPositions.add(new Position(3,3));
		
		laby.addForbiddenCellPos(blockPositions);
		laby.setHeight(4);
		laby.setWidth(4);
		laby.setExitPosition(new Position(3,1));
	
		Labyrinth laby2 = laby.getLabyrinth();
		
		
		
								
		LabyrinthGame labitinth = new LabyrinthGame(laby2, RobotArtificialIntelligence.createRobot("NotDumb"));
		labitinth.play();

	}
}
