import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;			
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.*;

public class Draw extends JFrame implements ActionListener, KeyListener, MouseListener, MouseMotionListener 
{
	private static final long serialVersionUID = 1L;
	final int DELAY_IN_MILLISEC = 20;
	static Draw di = new Draw();
	public static int mouseX;
	public static int mouseY;
	public static int mousePressX;
	public static int mousePressY;

	private static int windowHeight;
	
	static ArrayList<Drawable> objs = new ArrayList<Drawable>();
	
	public Draw()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Timer clock= new Timer(DELAY_IN_MILLISEC, this);
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		clock.start();
	}
	
	public static void main(String[] args) 
	{
		
	}
	
	public static void window(int width, int height)
	{
		di.setSize(width, height);
		di.setVisible(true);
		
		windowHeight = height;
		System.out.println(windowHeight);
	}
	
	public static void line(int x1, int y1, int x2, int y2)
	{
		Drawable obj = new Drawable(x1, windowHeight - y1, x2, windowHeight - y2, "line");
		objs.add(obj);
	}
	
	public static void rect(int x, int y, int width, int height)
	{
		Drawable obj = new Drawable(x, windowHeight - y - height, width, height, "rect");
		objs.add(obj);
	}
	
	public static void oval(int x, int y, int width, int height)
	{
		Drawable obj = new Drawable(x - width/2, windowHeight - y - height + height/2, width, height, "oval");
		objs.add(obj);
	}
	
	public static void polygon()
	{
		
	}
	
	public static void text(String text, int x, int y)
	{
		Drawable obj = new Drawable(x, windowHeight - y, 0, 0, text);
		objs.add(obj);
	}
	
	public void paint(Graphics g)
	{
	    for(int i = 0; i < objs.size(); i++)
	    {
	    	Drawable obj = objs.get(i);
	    	obj.draw(g);
	    }
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		repaint();
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseMoved(MouseEvent e) 
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseClicked(MouseEvent e) 
	{
		mousePressX = e.getX();
		mousePressY = e.getY();
	}

	public void mousePressed(MouseEvent e) 
	{
		mousePressX = e.getX();
		mousePressY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
