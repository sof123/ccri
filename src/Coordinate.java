
public class Coordinate {

	private int row;
	private int column;
	
	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public String toString() {
		return "{"+ column + ", " + row + "}";
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		Coordinate c = (Coordinate) o;
		
		return this.row == c.row && this.column == c.column;
	}
	@Override
	public int hashCode() {
		return row+column;
	}
}
