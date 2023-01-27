import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Pop implements MouseListener{
	
	JFrame frame = new JFrame("Pop-up");
	JPanel title = new JPanel();
	JPanel buttons = new JPanel();
	JLabel message = new JLabel();
	JButton b1 = new JButton("Yes,continue");
	
	Pop(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		message.setForeground(new Color(255,235,205));
		message.setBackground(new Color(217,179,130));
		message.setFont(new Font("Roboto",Font.BOLD,30));
		message.setHorizontalAlignment(JLabel.CENTER);
		message.setText("New Game?");
		message.setOpaque(true);
		
		title.setLayout(new BorderLayout());
		title.setBounds(0,0,300,70);
		
		buttons.setBackground(new Color(150,150,150));
		
		buttons.add(b1);
		
		title.add(message);
		frame.add(title,BorderLayout.NORTH);
		frame.add(buttons);
		b1.addMouseListener(this);
		
	}
	
	public static void main(String args[]) {
		new Pop();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
				new TicTacToe();
			
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	

}
