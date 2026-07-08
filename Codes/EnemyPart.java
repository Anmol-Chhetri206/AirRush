import javax.swing.ImageIcon;

public class EnemyPart
{
    public EnemyPart()
    {
        this.image = new ImageIcon(getClass().getResource("/image/rocket.png")).getImage();
    }
    public static final double ENEMY_SIZE = 50;
    private double xaxis;
    private double yaxis;
    private final float speedOfEnemy = 0.3f;
    private float angle = 0;
    private final Image image;

    public void changeLocation(double x , double y)
    {
        this.xaxis = x;
        this.yaxis = y;
    }

    public void update()
    {
        xaxis += Math.cos(Math.toRadians(angle)) * speedOfEnemy;
        yaxis += Math.sin(Math.toRadians(angle)) * speedOfEnemy;
    }

    public void changeAngle(float angle)
    {
        if(angle<0)
        {
            angle = 359;
        }
        else if(angle >359)
        {
            angle = 0;
        }
        this.angle = angle;
    }


    
    public double getXaxis()
    {
        return xaxis;
    }

    public double getYaxis()
    {
        return yaxis;
    }

    public float getAngle()
    {
        return angle;
    }
}