import javax.swing.JFrame;

public class moveImage
{
    public static void main(String args [])
    {
        JFrame f = new JFrame();
        moveImageDemo s = new moveImageDemo();
        f.add(s);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
    }
}
