package _03_Conways_Game_of_Life;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private static final long serialVersionUID = 1L;
	private int cellsPerRow;
	private int cellSize;
	
	private Timer timer;
	
	//1. Create a 2D array of Cells. Do not initialize it.
Cell[][] cellArray;
	
	
	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
		timer = new Timer(500, this);
		this.cellsPerRow = cpr;
	
		//2. Calculate the cell size.
		int cellSize=w/cpr;
		
		//3. Initialize the cell array to the appropriate size.
		cellArray=new Cell[cpr][cpr];
		//3. Iterate through the array and initialize each cell.
		//   Don't forget to consider the cell's dimensions when 
		//   passing in the location.
		for (int i = 0; i < cellArray.length; i++) {
			for (int j = 0; j < cellArray[i].length; j++) {
				cellArray[i][j]= new Cell(i*cellSize, j*cellSize, cellSize);
			}
		}
		
	}
	
	public void randomizeCells() {
		//4. Iterate through each cell and randomly set each
		//   cell's isAlive memeber to true of false
		for (int i = 0; i < cellArray.length; i++) {
			for (int j = 0; j < cellArray[i].length; j++) {
				int r = new Random().nextInt(2);
				if(r==1) {
				cellArray[i][j].isAlive=true;
				}
				else {
				cellArray[i][j].isAlive=false;
				}
			}
		}
		repaint();
	}
	
	public void clearCells() {
		//5. Iterated through the cells and set them all to dead.
		for (int i = 0; i < cellArray.length; i++) {
			for (int j = 0; j < cellArray[i].length; j++) {
				cellArray[i][j].isAlive=false;
			}
		}
		repaint();
	}
	
	public void startAnimation() {
		timer.start();
	}
	
	public void stopAnimation() {
		timer.stop();
	}
	
	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//6. Iterate through the cells and draw them all
		for (int i = 0; i < cellArray.length; i++) {
			for (int j = 0; j < cellArray[i].length; j++) {
				cellArray[i][j].draw(g);
			}
		}
		
		
		// draws grid
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}
	
	//advances world one step
	public void step() {
		//7. iterate through cells and get their neighbors
	
		
		//8. check if each cell should live or die
		for (int i = 0; i < cellArray.length; i++) {
			for (int j = 0; j < cellArray[i].length; j++) {
				int neighbors=0;
				if( i!=0 && j!=0) {
				if(cellArray[i-1][j-1].isAlive==true) {
					neighbors+=1;
				}
				}
				if(i!=0) {
				if(cellArray[i-1][j].isAlive==true) {
					neighbors+=1;
				}
				}
				if(i!=0 && j<cellArray[i].length-1) {
				if(cellArray[i-1][j+1].isAlive==true) {
					neighbors+=1;
				}
				}
				if(j!=0) {
				if(cellArray[i][j-1].isAlive==true) {
					neighbors+=1;
				}
				}
				if(j<cellArray[i].length-1) {
				if(cellArray[i][j+1].isAlive==true) {
					neighbors+=1;
				}
				}
				if(i<cellArray.length-1 && j!=0) {
				if(cellArray[i+1][j-1].isAlive==true) {
					neighbors+=1;
				}
				}
				if(i<cellArray.length-1) {
				if(cellArray[i+1][j].isAlive==true) {
					neighbors+=1;
				}
				}
				if(i<cellArray.length-1 && j<cellArray[i].length-1) {
				if(cellArray[i+1][j+1].isAlive==true) {
					neighbors+=1;
				}
				}
				cellArray[i][j].liveOrDie(neighbors);
			}
		}
		
		
		repaint();
	}
	
	//9. Complete the method.
	//   It returns an array list of the  8 or less neighbors of the 
	//   cell identified by x and y
	public int getLivingNeighbors(int x, int y){
		return 0;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//10. Use e.getX() and e.getY() to determine
		//    which cell is clicked. Then toggle
		//    the isAlive variable for that cell.
		for (int i = 0; i < cellArray.length; i++) {
			for (int j = 0; j < cellArray[i].length; j++) {
				if(cellArray[i][j].getX()<=e.getX() && e.getX()<cellArray[i][j].getX()+cellSize && cellArray[i][j].getY()<=e.getY() && e.getY()<cellArray[i][j].getY()+cellSize) {
					if(cellArray[i][j].isAlive==true) {
						cellArray[i][j].isAlive=false;
					}
					else {
						cellArray[i][j].isAlive=true;
					}
				}
			}
		}
		
		
		
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();		
	}
}
