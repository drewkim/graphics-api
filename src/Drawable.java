import java.awt.Color;
import java.awt.Graphics;

public class Drawable 
{
	int x1;
	int y1;
	int x2;
	int y2;
	String name;
	
	public Drawable(int x1, int y1, int x2, int y2, String name)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.name = name;
	}
	
	public void draw(Graphics g)
	{	
		g.setColor(Color.black);
		
		if(name.equals("line"))
			g.drawLine(x1, y1, x2, y2);
		else if(name.equals("rect"))
			g.drawRect(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
		else if(name.equals("oval"))
			g.drawOval(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
		else
			g.drawString(name, x1, y1);
	}
}
