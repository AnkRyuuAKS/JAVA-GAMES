import javax.swing.*;
import java.awt.*;

public class prac1{
    public static class Mypannel extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("Hello",20,20);
    }
}
    private static void Running(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Mypannel customPannel = new Mypannel();

        frame.getContentPane().add(customPannel);
        frame.setSize(400,300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // width, height
                Running();
            }
        });
    }
}