import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Drawable 
{
	int x1;
	int y1;
	int x2;
	int y2;
	String type;
	String text;
	
	public Drawable(int x1, int y1, int x2, int y2, String type, String text)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.type = type;
		this.text = text;
	}
		
	public void draw(Graphics g, Color color)
	{		
		g.setColor(color);
		
		if(type.equals("line"))
			g.drawLine(x1, y1, x2, y2);
		else if(type.equals("rect"))
			g.drawRect(x1, y1, x2, y2);
		else if(type.equals("oval"))
			g.drawOval(x1, y1, x2, y2);
		else if(type.equals("text"))
			g.drawString(text, x1, y1);
		else if(type.equals("image"))
			g.drawImage(new ImageIcon(text).getImage(), x1, y1, x2, y2, null);
	}
}
