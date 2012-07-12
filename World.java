public class World{
	private Cell[][] cellZone;
	
	private final int width, height;
	
	public World(int width, int height){
		cellZone = new Cell[width][height];
		
		for(int i = 0; i < this.width; ++i){
			for(int j = 0; j < this.height; ++j){
				cellZone[i][j] = new Cell(false, i, j);
			}
		}
		
		for(int i = 0; i < this.width; ++i){
			for(int j = 0; j < this.height; ++j){
				cellZone[i][j].findNeighbors(this);
			}
		}
	}
	
	public void getMaxX(){ return width; }
	public void getMaxY(){ return height; }
}