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
    private String target;
    private String[] targetWords;
    private JFrame frame;
    private final int CURSOR_WIDTH = 1;
    private final int TYPER_WIDTH = 1000;
    private final int TYPER_HEIGHT = 179;
    private int cursorTracker;
    private int correctWords;
    private int correctChars;
    private int timePassed;
    private int wpm;
    private int cpm;
    private boolean started = false;
    private boolean fin;
    private int mode = 0;
    private int untyped = 0;
    private int lastSpace0 = 0;
    private int last0 = 0;
    private int lastSpace1 = 0;
    private int last1 = 0;
    public static void main(String[] args)
    {
        new Typer(1);
    }

    public void keyPressed(KeyEvent e) 
    {

    }

    public void keyReleased(KeyEvent e)
    {

    }

    public void keyTyped(KeyEvent e) 
    {
        if (e.getKeyChar() == '\b')
        {
            if (!input.equals(""))
            {
                input = input.substring(0, input.length() - 1);
                fin = false;
            }
        }
        else if (e.getKeyChar() == '\u001b')
        {
            System.exit(0);
        }
        if(fin) return;
        if (!started)
        {
            timer.start();
            started = true;
        }
        if (e.getKeyChar() != e.CHAR_UNDEFINED && e.getKeyChar() != '\b' && e.getKeyChar() != '\u001b') 
        {
            input += ("" + e.getKeyChar());
        }       
        this.repaint();
    }

    Timer timer = new Timer(100, new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    timePassed += 1;
                    if (timePassed >= 10)
                    {
                        wpm = correctWords*60/(timePassed/10);
                        cpm = correctChars*60/(timePassed/10);
                    }
                    else
                    {
                        wpm = correctWords * 60;
                        cpm = correctChars * 60;
                    }
                }
            });

    public Typer(int mode)
    { 
        if (mode == 0)
        {
            targetWords = new RandomChooser().chooseLines(60);
            target = combine(targetWords);
        }
        else if (mode == 1)
        {
            //target = "the quick brown fox jumped over the lazy dog";
            target = new TextChooser().chooseText();
            targetWords = target.split(" ");
        }  
        fin = false;
        frame = new JFrame("My Typer");
        frame.getContentPane().add(this,BorderLayout.CENTER);
        frame.pack();
        frame.setSize(TYPER_WIDTH, TYPER_HEIGHT);
        frame.addKeyListener(this);
        frame.setVisible(true);
    }

    private Typer(String input, String target) 
    {

    }

    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.setColor(Color.white);
        int width = this.getWidth();
        int height = this.getHeight();
        g.fillRect(0,0,width,height);
        g.setFont(new Font("Arial Hebrew", Font.PLAIN, 16)); 
        FontMetrics fm = g.getFontMetrics();
        int fh = fm.getAscent();
        int middle = height/2+fh/2;
        g.setColor(Color.black);
        String[] inputWords = input.split(" ");
        correctWords = 0;
        correctChars = 0;
        if (fm.stringWidth(target) > 2955)
        {
            System.exit(0);
        }
        for (int i = 0; i < inputWords.length; i++)
        {
            if (targetWords.length >= inputWords.length)
            {
                if (inputWords[i].equalsIgnoreCase(targetWords[i]))
                {
                    correctWords++;
                }
            }
        }
        if (target.length() >= input.length())
        {
            int targetTracker = 0;
            int targetTracker2 = 0;
            int targetTracker3 = 0;
            int inputTracker = 0;
            int inputTracker2 = 0;
            int inputTracker3 = 0;
            int progressTracker = 0;
            int progressTracker2 = 0;
            int progressTracker3 = 0;
            for (int i = untyped; i < target.length(); i++)
            {
                if (fm.stringWidth(target.substring(0,i+1)) <= 985)
                {
                    g.drawString(target.substring(i,i+1),targetTracker,fh);
                    targetTracker += fm.stringWidth(target.substring(i,i+1));
                }
                else if (fm.stringWidth(target.substring(0,i+1)) <= 1970)
                {
                    g.drawString(target.substring(i,i+1),targetTracker2,fh*2);
                    targetTracker2 += fm.stringWidth(target.substring(i,i+1));
                }
                else if (fm.stringWidth(target.substring(0,i+1)) <= 2955)
                {
                    g.drawString(target.substring(i,i+1),targetTracker3,fh*3);
                    targetTracker3 += fm.stringWidth(target.substring(i,i+1));
                }
            }
            for (int i = 0; i < input.length(); i++)
            {
                if (target.substring(i,i+1).equalsIgnoreCase(input.substring(i,i+1)))
                {
                    g.setColor(Color.blue);
                    correctChars++;
                }
                else
                {
                    g.setColor(Color.red);             
                }
                if (input != null)
                {
                    if (fm.stringWidth(input.substring(0,i+1)) <= 985)
                    {
                        g.drawString(input.substring(i,i+1),inputTracker,68);
                        inputTracker += fm.stringWidth(input.substring(i,i+1));
                    }
                    else if (fm.stringWidth(input.substring(0,i+1)) <= 1970)
                    {
                        g.drawString(input.substring(i,i+1),inputTracker2,85);
                        inputTracker2 += fm.stringWidth(input.substring(i,i+1));
                    }
                    else if (fm.stringWidth(input.substring(0,i+1)) <= 2955)
                    {
                        g.drawString(input.substring(i,i+1),inputTracker2,102);
                        inputTracker3 += fm.stringWidth(input.substring(i,i+1));
                    }
                }
                if (fm.stringWidth(target.substring(0,i+1)) <= 985)
                {
                    g.drawString(target.substring(i,i+1),progressTracker,fh);
                    progressTracker += fm.stringWidth(target.substring(i,i+1));
                }
                else if (fm.stringWidth(target.substring(0,i+1)) <= 1970)
                {
                    g.drawString(target.substring(i,i+1),progressTracker2,fh*2);
                    progressTracker2 += fm.stringWidth(target.substring(i,i+1));
                }
                else if (fm.stringWidth(target.substring(0,i+1)) <= 2955)
                {
                    g.drawString(target.substring(i,i+1),progressTracker3,fh*3);
                    progressTracker3 += fm.stringWidth(target.substring(i,i+1));
                }
                untyped++;
            }
        }
        g.setColor(Color.black);
        if (fm.stringWidth(input) <= 985)
        {
            cursorTracker = fm.stringWidth(input);
            g.fillRect(cursorTracker,51,CURSOR_WIDTH,fh);
        }
        else if (fm.stringWidth(input) <= 1970)
        {
            cursorTracker = fm.stringWidth(input.substring(lastSpace0,input.length()));
            g.fillRect(cursorTracker,68,CURSOR_WIDTH,fh);
        }
        g.drawString("Words per minute: " + wpm,0,119);
        g.drawString("Characters per minute: " + cpm,0,136);
        untyped = 0;
        if(target.length() == input.length()) 
        {
            fin = true;
        }
    }

    public String combine(String[] str)
    {
        String a = "";
        for(String s : str) a += s + " ";
        return a.trim();
    }
}

