import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * Write a description of class Typer here.
 * 
 * @author (Drew McMains) 
 * @version (a version number or a date)
 */
public class Typer extends JPanel implements KeyListener
{
    private String input = "";
    private String target = "The quick brown fox jumped over the lazy dog.";
    private String[] targetWords = target.split(" ");
    private JFrame frame;
    private static final int CURSOR_WIDTH = 1;
    private static final int TYPER_WIDTH = 1000;
    private static final int TYPER_HEIGHT = 100;
    public void keyPressed(KeyEvent e) 
    {

    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e) 
    {
        int keycode = e.getKeyCode();
        if (e.getKeyChar() != e.CHAR_UNDEFINED && e.getKeyChar() != '\b') 
        {
            input += ("" + e.getKeyChar());
        }
        else if (e.getKeyChar() == '\b')
        {
            input = input.substring(0, input.length() - 1);
        }
        //e.getKeyChar() != 'uO01b' (with backslash before "u") -- escape keyChar
        this.repaint();
    }

    public Typer()
    { 
        this("", "");
    }

    public Typer(String input, String target) 
    {
        frame = new JFrame("My Typer");
        frame.getContentPane().add(this,BorderLayout.CENTER);
        frame.pack();
        frame.setSize(TYPER_WIDTH, TYPER_HEIGHT);
        frame.addKeyListener(this);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        String[] inputWords = input.split(" ");
        if (inputWords.length <= targetWords.length && input.length() <= target.length())
        {
            super.paintComponent(g);
            g.setColor(Color.white);
            int w = this.getWidth();
            int h = this.getHeight();
            g.fillRect(0,0,w,h);
            FontMetrics fm = g.getFontMetrics();
            int fh = fm.getAscent();
            int middle = h/2+fh/2;
            g.setColor(Color.black);
            g.drawString(target,0,10);
            if (target.length() >= input.length())
            {
                int widthTracker = 0;
                for (int i = 0; i < inputWords.length; i++)
                {
                    if (targetWords[i].equalsIgnoreCase(inputWords[i]))
                    {
                        g.setColor(Color.blue);
                    }
                    else
                    {
                        g.setColor(Color.red);
                    }
                    if (input != null)
                    {
                        g.drawString(inputWords[i],widthTracker,middle);
                    }
                    widthTracker += fm.stringWidth(inputWords[i] + " ");
                }
            }
            int cursorTracker = fm.stringWidth(input);
            g.setColor(Color.black);
            g.fillRect(cursorTracker,middle-fh,CURSOR_WIDTH,fh);
        }
    }
}
