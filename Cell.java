public class Cell{
	private boolean alive;
	private Cell[] neighbors;
	
	private int neighborCount;
	
	private int xCoord;
	private int yCoord;
	
	
	public Cell(boolean initialStatus, int xCoord, int yCoord){
		this.alive = initialStatus;
		neighbors = new Cell[8];
		
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}
	
	public void findNeighbors(World zone){
		
		int xSubOne = this.xCoord - 1;
		int xPlusOne = this.xCoord + 1;
		int ySubOne = this.yCoord - 1;
		int yPlusOne = this.yCoord + 1;
		
		if(this.xCoord == 0){
			xSubOne = zone.getMaxX();
		}
		if(this.yCoord == 0){
			ySubOne = zone.getMaxY();
		}
		if(this.xCoord == zone.getMaxX()){
			xPlusOne = 0;
		}
		if(this.yCoord == zone.getMaxY()){
			yPlusOne = 0;
		}
		
		neighbors[0] = zone.getCell(xSubOne, ySubOne);
		neighbors[1] = zone.getCell(this.xCoord, ySubOne);
		neighbors[2] = zone.getCell(xPlusOne, ySubOne);
		
		neighbors[3] = zone.getCell(xPlusOne, this.yCoord);
		neighbors[4] = zone.getCell(xSubOne, this.yCoord);
		
		neighbors[5] = zone.getCell(xSubOne, yPlusOne);
		neighbors[6] = zone.getCell(this.xCoord, yPlusOne);
		neighbors[7] = zone.getCell(xPlusOne, xPlusOne);
	}
		
		
	
	private int neighborCount(){
		int count = 0;
		for(int i = 0; i < neighbors.length; ++i){
			if(neighbors[i].isAlive()){
				++count;
			}
		}
		
		return count;
	}
	
	private boolean isAlive(){ return alive; }
	
	public void processGeneration(){
		int neighborCount = neighborCount();
		if(this.alive){
			if(neighborCount < 2 || neighborCount > 3){
				this.alive = false;
				return;
			}
			else{
				return;
			}
		}
		else if(neighborCount == 3){
			this.alive = true;
		}
		
		return;
	}
}