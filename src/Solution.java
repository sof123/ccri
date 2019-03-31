import java.util.ArrayList;
import java.util.HashSet;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int height = 11;
		int width = 11;
		int n = 0;
		int [] [] test = new int[height][width];
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width; column++) {
				test[row][column] = -1;
			}
		}
		test[7][3] = 1;
		test[3][7] = 1;
		System.out.println(getNumElementsInManhattanNeighborhood(test, height, width, n));
		
		

	}
	
	static ArrayList<Coordinate> getPositiveElements(int [][] matrix, int h, int w) {
		ArrayList<Coordinate> coordinateList = new ArrayList();
		for (int row = 0; row < h; row++) {
			for (int column = 0; column < w; column++) {
				if (matrix[row][column] > 0) {
					coordinateList.add(new Coordinate(row, column));
				}
			}
		}
		return coordinateList;
	}
	
	static ArrayList<Coordinate> getAllElementsWithinDistanceNFromC(Coordinate c, int n, int h, int w, int [][] matrix){
		ArrayList<Coordinate> toReturn = new ArrayList();
		for (int row = 0; row < h; row++) {
			for (int column = 0; column < w; column++) {
					Coordinate comparedCoorddinate = new Coordinate(row, column);
					if (manhattanDistance(c, comparedCoorddinate) <=n) {
						toReturn.add(comparedCoorddinate);
					}
			}
		}
		return toReturn;
	}
	
	public static int getNumElementsInManhattanNeighborhood(int [][] matrix, int h, int w, int n) {
		ArrayList<Coordinate> positiveCoordinates = getPositiveElements(matrix, h, w);
		HashSet<Coordinate> manhattanNeighborhood = new HashSet();
		for (Coordinate c : positiveCoordinates) {
			//always add positive coordinate
			manhattanNeighborhood.add(c);
			ArrayList<Coordinate> elementsInNeighborhoodOfC = getAllElementsWithinDistanceNFromC(c, n, h, w, matrix);
			for (Coordinate neighborHoodCoordinate : elementsInNeighborhoodOfC) {
				manhattanNeighborhood.add(neighborHoodCoordinate);
			}
		}
		return manhattanNeighborhood.size();
	}
	
	public static int manhattanDistance(Coordinate a, Coordinate b) {
		return Math.abs(a.getRow()-b.getRow()) + Math.abs(a.getColumn() - b.getColumn());
	}

}
