import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class TicTacToe implements ActionListener{
	
	Random random = new Random();
	JFrame frame = new JFrame("Tic Tac Toe");
	JPanel title = new JPanel();
	JPanel buttons = new JPanel();
	JLabel message = new JLabel();
	JButton[] button = new JButton[9];
	boolean p1;
	
	public TicTacToe(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(217,179,130));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		message.setForeground(new Color(255,235,205));
		message.setBackground(new Color(217,179,130));
		message.setFont(new Font("Roboto",Font.BOLD,75));
		message.setHorizontalAlignment(JLabel.CENTER);
		message.setText("TIC TAC TOE");
		message.setOpaque(true);
		
		title.setLayout(new BorderLayout());
		title.setBounds(0,0,800,70);
		
		buttons.setLayout(new GridLayout(3,3));
		buttons.setBackground(new Color(150,150,150));
		
		for(int i=0; i<9; i++) {
			button[i] = new JButton();
			buttons.add(button[i]);
			button[i].setFont(new Font("Roboto",Font.BOLD,100));
			button[i].setFocusable(false);
			button[i].addActionListener(this);
		}
		
		title.add(message);
		frame.add(title,BorderLayout.NORTH);
		frame.add(buttons);
		
		fTurn();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<9; i++) {
			if(e.getSource()==button[i]) {
				if(p1) {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(255,0,0));
						button[i].setText("X");
						p1 = false;
						message.setText("0 turn");
						check();
					}
				}
				else {
					if(button[i].getText()=="") {
						button[i].setForeground(new Color(0,0,255));
						button[i].setText("0");
						p1 = true;
						message.setText("X turn");
						check();
					}
				}
			}
		}
		
	}
	
	public void fTurn() {
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {}
		
		if(random.nextInt(2)==0) {
			p1 = true;
			message.setText("X turn");
		}
		else {
			p1 = false;
			message.setText("0 turn");
		}
	}
	
	public void check() {
		//x wins
		if((button[0].getText()=="X")&&
			(button[1].getText()=="X")&&
			(button[2].getText()=="X")) {
			xWin(0,1,2);
		}
		if((button[3].getText()=="X")&&
				(button[4].getText()=="X")&&
				(button[5].getText()=="X")) {
				xWin(3,4,5);
			}
		if((button[6].getText()=="X")&&
				(button[7].getText()=="X")&&
				(button[8].getText()=="X")) {
				xWin(6,7,8);
			}
		if((button[0].getText()=="X")&&
				(button[4].getText()=="X")&&
				(button[8].getText()=="X")) {
				xWin(0,4,8);
			}
		if((button[4].getText()=="X")&&
				(button[6].getText()=="X")&&
				(button[2].getText()=="X")) {
				xWin(4,6,2);
			}
		if((button[0].getText()=="X")&&
				(button[3].getText()=="X")&&
				(button[6].getText()=="X")) {
				xWin(0,3,6);
			}
		if((button[1].getText()=="X")&&
				(button[4].getText()=="X")&&
				(button[7].getText()=="X")) {
				xWin(1,4,7);
			}
		if((button[2].getText()=="X")&&
				(button[5].getText()=="X")&&
				(button[8].getText()=="X")) {
				xWin(2,5,8);
			}
		
		//0 wins
		if((button[0].getText()=="0")&&
				(button[1].getText()=="0")&&
				(button[2].getText()=="0")) {
				oWin(0,1,2);
			}
			if((button[3].getText()=="0")&&
					(button[4].getText()=="0")&&
					(button[5].getText()=="0")) {
					oWin(3,4,5);
				}
			if((button[6].getText()=="0")&&
					(button[7].getText()=="0")&&
					(button[8].getText()=="0")) {
					oWin(6,7,8);
				}
			if((button[0].getText()=="0")&&
					(button[4].getText()=="0")&&
					(button[8].getText()=="0")) {
					oWin(0,4,8);
				}
			if((button[4].getText()=="0")&&
					(button[6].getText()=="0")&&
					(button[2].getText()=="0")) {
					oWin(4,6,2);
				}
			if((button[0].getText()=="0")&&
					(button[3].getText()=="0")&&
					(button[6].getText()=="0")) {
					oWin(0,3,6);
				}
			if((button[1].getText()=="0")&&
					(button[4].getText()=="0")&&
					(button[7].getText()=="0")) {
					oWin(1,4,7);
				}
			if((button[2].getText()=="0")&&
					(button[5].getText()=="0")&&
					(button[8].getText()=="0")) {
					oWin(2,5,8);
				}
			
			//draw
			else if (button[0].getText()!="" && 
					button[1].getText()!="" &&
					button[2].getText()!="" &&
					button[3].getText()!="" &&
					button[4].getText()!="" &&
					button[5].getText()!="" &&
					button[6].getText()!="" &&
					button[7].getText()!=""){
				noWin();
			}
	}
	
	public void xWin(int a, int b, int c) {
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9; i++) {
			button[i].setEnabled(false);
		}
		
		message.setText("X wins!");
		message.setForeground(new Color(0,0,0));
		new Pop();
		}
		
	
	public void oWin(int a, int b, int c) {
		button[a].setBackground(Color.GREEN);
		button[b].setBackground(Color.GREEN);
		button[c].setBackground(Color.GREEN);
		
		for(int i=0; i<9; i++) {
			button[i].setEnabled(false);
		}
		
		message.setText("0 wins!");
		message.setForeground(new Color(0,0,0));
		new Pop();
		
	}
	
	public void noWin() {
		message.setText("DRAW");
		message.setForeground(new Color(0,0,0));
		new Pop();
	}
	
	public void endGame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
