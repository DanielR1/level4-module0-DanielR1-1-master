package _04_Maze_Maker;
import java.awt.Color;
import java.awt.Graphics;

public class Maze {
	//1. Create a 2D array of cells. Don't initialize it.
 Cell[][]ca;
	private int width;
	private int height;

	public Maze(int w, int h) {
		this.width = w;
		this.height = h;

		//2. Initialize the cells using the width and height varibles
ca=new Cell[width][height];
		//3. Iterated through each cell and initialize it
		//   using i and j as the location
for (int i = 0; i < ca.length; i++) {
	for (int j = 0; j < ca[i].length; j++) {
		ca[i][j]=new Cell(i,j);
	}
}
		
	}

	//4. This method iterates through the cells and draws them
	public void draw(Graphics g) {
		g.setColor(Color.red);
		for (int i = 0; i < ca.length; i++) {
			for (int j = 0; j < ca[i].length; j++) {
				ca[i][j].draw(g);
			}
		}
	}
	
	//4b. This method returns the selected cell.
	public Cell getCell(int x, int y){
		Cell a=null;
		for (int i = 0; i < ca.length; i++) {
			for (int j = 0; j < ca[i].length; j++) {
				if(ca[x][y]==ca[i][j]) {
					a= ca[i][j]; 
					return  a;
					
				}
			}
		}
	return a;
		
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
