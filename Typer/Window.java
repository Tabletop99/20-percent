import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window extends JFrame
{
	public static void main(String[] args) 
	{
		new Window();
	}

	public Window()
	{
		super("Typer"); //this is the title of the window
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e){
				super.windowClosing(e);
				Window.this.setVisible(false);
				Window.this.dispose();
			}
		});
		JButton btn = new JButton("Random"); //text is what appears on the button
		btn.setSize(200,100);
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int mode = 0;
				new Typer(0);
				setVisible(false);
				dispose();
			}
		});
		final JButton btn2 = new JButton("Text"); //text is what appears on the button
		btn2.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int mode = 0;
				new Typer(1);
				setVisible(false);
				dispose();
			}
		});
		setLayout(new FlowLayout());
		add(btn);
		add(btn2);
		pack();
		setSize(480,100);
		setVisible(true);
	}
	/**
     * checks if the string is an int
     * @param str the possible number to check
     * @return true if inputted string is a int.
     */
    public static boolean isNumber(String str)
    {
        boolean result = false;
        try
        {
            Integer.parseInt(str);
            result = true;
        }
        catch(Exception e)
        {
            result = false;
        }
        return result;
    }
}