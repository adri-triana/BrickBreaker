import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BrickGame extends JPanel {

        
        Ball ball = new Ball(this);

	private void move() {
		ball.move();
	}
        
        
    
        public BrickGame()
        {
            setBackground(Color.BLACK);
        }
        
        
	@Override
	public void paint(Graphics g) {
            super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.WHITE);
                ball.paint(g2d);
		g2d.fillRect(0, 0, 30, 100);

		//g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
	}
	
	public static void main(String[] args)throws InterruptedException  {
		JFrame frame = new JFrame("Brick Breaker");
                BrickGame game = new BrickGame();
		frame.add(game);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                
                
                while(true){
                    game.move();
                    game.repaint();
                    Thread.sleep(10);
                }
	}
}