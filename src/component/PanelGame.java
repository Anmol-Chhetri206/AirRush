
package src.component;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
public class PanelGame extends JComponent {

    private Graphics2D g2d;
    private BufferedImage image;
    private int width;
    private int height;
    private Thread thread;
    private boolean start = true ;
    // Game FPS and time
    public final int FPS = 60;
    private final int TARGET_TIME = 1000000000 / FPS;
    public void start() {
        	width = getWidth();
        	height = getHeight();
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            g2d = image.createGraphics();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            thread = new Thread (new Runnable() {
                @Override
        		public void run() {
        			while (start) {
                        long startTime = System.nanoTime();
                        drawBackground();
                        drawGame();
                        Render();
                        long time = System.nanoTime() - startTime;
                        if (time < TARGET_TIME) {
                            long sleep = (TARGET_TIME - time) / 1000000;
                            sleep(sleep);
                            System.out.println(" Sleep ");
                        }
        				
        				}
        			}
        	}     );
        	thread.start();

    }
    private void drawBackground() {
        g2d.setColor(new Color(30, 30, 30));
        g2d.fillRect(0, 0, width, height);
    }
    private void drawGame() {
        // Implementation for drawing the game elements
    }
    private void Render (){
        Graphics g = getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

    }
    private void sleep(long speed){
        try {
            Thread.sleep(speed);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }
}
