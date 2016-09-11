package Puzzle;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	JButton button_1;
	JButton button_2;
	JButton button_3;
	JButton button_4;
	JButton button_5;
	JButton button_6;
	JButton button_7;
	JButton button_8;
	JButton button_0;
	JButton btnShuffle;
	JPanel panel_1;
	JPanel panel_2;
	JPanel panel_3;
	JLabel lblMoves;
	int moves=0;
	String status;
	static MainFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MainFrame();
					//frame.shuffle();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	void check(String str){
		if(str.equals("123456780")){
			JOptionPane.showMessageDialog(null, "Goal has been reached!");
		}
		System.out.println(status);
	}
	void solution(){
		status = button_1.getText()+button_2.getText()+button_3.getText()
					+button_4.getText()+button_5.getText()+button_6.getText()
					+button_7.getText()+button_8.getText()+button_0.getText();
		EightPuzzle e = new EightPuzzle();
		e.add(status, null);
		while(!e.agenda.isEmpty()){
		        String currentState = e.agenda.remove();
		        e.up(currentState);
		        e.down(currentState);
		        e.left(currentState);
		        e.right(currentState);
		}
		SolutionFrame s = new SolutionFrame();
		s.textPane.setText(e.msg);
		if(s.textPane.getText().isEmpty()){
			s.textPane.setText("Solution does not exist");
		}
		s.setVisible(true);
	}
	String shuffle(){
		System.out.println("Start");
		Random r = new Random();
		String str="";
		str+=r.nextInt(9);
		int r2 = r.nextInt(9);
		int i=1;
		while(i<9){
			if(str.indexOf(String.valueOf(r2)) != -1){
				r2 = r.nextInt(9);
				continue;
			}
			str+=r2;
			i++;
			r2=r.nextInt(9);
		}
		button_1.setBackground(Color.BLACK);
		button_1.setForeground(Color.WHITE);
		button_2.setBackground(Color.BLACK);
		button_2.setForeground(Color.WHITE);
		button_3.setBackground(Color.BLACK);
		button_3.setForeground(Color.WHITE);
		button_4.setBackground(Color.BLACK);
		button_4.setForeground(Color.WHITE);
		button_5.setBackground(Color.BLACK);
		button_5.setForeground(Color.WHITE);
		button_6.setBackground(Color.BLACK);
		button_6.setForeground(Color.WHITE);
		button_7.setBackground(Color.BLACK);
		button_7.setForeground(Color.WHITE);
		button_8.setBackground(Color.BLACK);
		button_8.setForeground(Color.WHITE);
		button_0.setBackground(Color.BLACK);
		button_0.setForeground(Color.WHITE);
		switch (str.indexOf("0")) {
			case 0:
				button_1.setBackground(Color.WHITE);
				button_1.setForeground(Color.BLACK);
				break;
			case 1:
				button_2.setBackground(Color.WHITE);
				button_2.setForeground(Color.BLACK);
				break;
			case 2:
				button_3.setBackground(Color.WHITE);
				button_3.setForeground(Color.BLACK);
				break;
			case 3:
				button_4.setBackground(Color.WHITE);
				button_4.setForeground(Color.BLACK);
				break;
			case 4:
				button_5.setBackground(Color.WHITE);
				button_5.setForeground(Color.BLACK);
				break;
			case 5:
				button_6.setBackground(Color.WHITE);
				button_6.setForeground(Color.BLACK);
				break;
			case 6:
				button_7.setBackground(Color.WHITE);
				button_7.setForeground(Color.BLACK);
				break;
			case 7:
				button_8.setBackground(Color.WHITE);
				button_8.setForeground(Color.BLACK);
				break;
			case 8:
				button_0.setBackground(Color.WHITE);
				button_0.setForeground(Color.BLACK);
				break;
		}
		
		button_1.setText(String.valueOf(str.charAt(0)));
		button_2.setText(String.valueOf(str.charAt(1)));
		button_3.setText(String.valueOf(str.charAt(2)));
		button_4.setText(String.valueOf(str.charAt(3)));
		button_5.setText(String.valueOf(str.charAt(4)));
		button_6.setText(String.valueOf(str.charAt(5)));
		button_7.setText(String.valueOf(str.charAt(6)));
		button_8.setText(String.valueOf(str.charAt(7)));
		button_0.setText(String.valueOf(str.charAt(8)));
		
		System.out.println(str);
		System.out.println("End");
		return str;
	}
	
	/**
	 * Create the frame.
	 */
	
	public MainFrame() {
		setResizable(false);
		setLocation(0, 0);
		setTitle("8-Puzzle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMoves = new JLabel("Moves: 0");
		lblMoves.setForeground(Color.RED);
		lblMoves.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMoves.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoves.setBounds(111, 0, 125, 37);
		contentPane.add(lblMoves);
		
		JButton btnSolution = new JButton("Solution");
		btnSolution.setForeground(Color.DARK_GRAY);
		btnSolution.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				solution();	    
			}
		});
		
		btnSolution.setBounds(341, 7, 91, 23);
		contentPane.add(btnSolution);
		
		btnShuffle = new JButton("Shuffle");
		btnShuffle.setForeground(Color.DARK_GRAY);
		btnShuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				status=shuffle();
			}
		});
		btnShuffle.setBounds(10, 7, 91, 23);
		contentPane.add(btnShuffle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 41, 400, 95);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		button_1 = new JButton("1");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_1.setBackground(Color.BLACK);
		button_1.setForeground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button1performed();
			}
		});
		panel_1.add(button_1);
		
		button_2 = new JButton("2");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(Color.BLACK);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button2performed();
			}
		});
		panel_1.add(button_2);
		
		button_3 = new JButton("3");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_3.setForeground(Color.WHITE);
		button_3.setBackground(Color.BLACK);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button3performed();
			}
		});
		panel_1.add(button_3);
		
		panel_2 = new JPanel();
		panel_2.setBounds(20, 136, 400, 102);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		button_4 = new JButton("4");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_4.setBackground(Color.BLACK);
		button_4.setForeground(Color.WHITE);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button4performed();
			}
		});
		panel_2.add(button_4);
		
		button_5 = new JButton("5");
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_5.setForeground(Color.WHITE);
		button_5.setBackground(Color.BLACK);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button5performed();
			}
		});
		panel_2.add(button_5);
		
		button_6 = new JButton("6");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_6.setBackground(Color.BLACK);
		button_6.setForeground(Color.WHITE);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button6performed();
			}
		});
		panel_2.add(button_6);
		
		panel_3 = new JPanel();
		panel_3.setBounds(20, 235, 400, 95);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		button_7 = new JButton("7");
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_7.setForeground(Color.WHITE);
		button_7.setBackground(Color.BLACK);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button7performed();
			}
		});
		panel_3.add(button_7);
		
		button_8 = new JButton("8");
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_8.setBackground(Color.BLACK);
		button_8.setForeground(Color.WHITE);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button8performed();
			}
		});
		panel_3.add(button_8);
		
		button_0 = new JButton("0");
		button_0.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button_0.setForeground(Color.BLACK);
		button_0.setBackground(Color.WHITE);
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button0performed();
			}
		});
		panel_3.add(button_0);
		
		JButton btnStGame = new JButton("Start Game");
		btnStGame.setForeground(Color.RED);
		btnStGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				frame = new MainFrame();
				frame.setVisible(true);
			}
		});
		btnStGame.setBounds(233, 9, 98, 23);
		contentPane.add(btnStGame);
	}
	void button1performed(){
		if(button_2.getText()=="0" || button_4.getText()=="0"){
			if(button_2.getText()=="0"){
				button_2.setText(button_1.getText());
				button_1.setText("0");
				button_2.setBackground(Color.BLACK);
				button_2.setForeground(Color.WHITE);
				button_1.setBackground(Color.WHITE);
				button_1.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status= button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else {
				button_4.setText(button_1.getText());
				button_1.setText("0");
				button_4.setBackground(Color.BLACK);
				button_4.setForeground(Color.WHITE);
				button_1.setBackground(Color.WHITE);
				button_1.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			}
		}
	}
	void button2performed(){
		if(button_1.getText()=="0" || button_3.getText()=="0" || button_5.getText()=="0"){
			if (button_1.getText()=="0") {
				button_1.setText(button_2.getText());
				button_2.setText("0");
				button_1.setBackground(Color.BLACK);
				button_1.setForeground(Color.WHITE);
				button_2.setBackground(Color.WHITE);
				button_2.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else if(button_3.getText()=="0"){
				button_3.setText(button_2.getText());
				button_2.setText("0");
				button_3.setBackground(Color.BLACK);
				button_3.setForeground(Color.WHITE);
				button_2.setBackground(Color.WHITE);
				button_2.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else {
				button_5.setText(button_2.getText());
				button_2.setText("0");
				button_5.setBackground(Color.BLACK);
				button_5.setForeground(Color.WHITE);
				button_2.setBackground(Color.WHITE);
				button_2.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			}
		}
	}
	void button3performed(){
		if(button_2.getText()=="0" || button_6.getText()=="0"){
			if(button_2.getText()=="0"){
				button_2.setText(button_3.getText());
				button_3.setText("0");
				button_2.setBackground(Color.BLACK);
				button_2.setForeground(Color.WHITE);
				button_3.setBackground(Color.WHITE);
				button_3.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else {
				button_6.setText(button_3.getText());
				button_3.setText("0");
				button_6.setBackground(Color.BLACK);
				button_6.setForeground(Color.WHITE);
				button_3.setBackground(Color.WHITE);
				button_3.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			}
		}
	}
	void button4performed(){
		if(button_1.getText()=="0" || button_5.getText()=="0" || button_7.getText()=="0"){
			if(button_1.getText()=="0"){
				button_1.setText(button_4.getText());
				button_4.setText("0");
				button_1.setBackground(Color.BLACK);
				button_1.setForeground(Color.WHITE);
				button_4.setBackground(Color.WHITE);
				button_4.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else if (button_5.getText()=="0"){
				button_5.setText(button_4.getText());
				button_4.setText("0");
				button_5.setBackground(Color.BLACK);
				button_5.setForeground(Color.WHITE);
				button_4.setBackground(Color.WHITE);
				button_4.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else {
				button_7.setText(button_4.getText());
				button_4.setText("0");
				button_7.setBackground(Color.BLACK);
				button_7.setForeground(Color.WHITE);
				button_4.setBackground(Color.WHITE);
				button_4.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			}
		}
	}
	void button5performed(){
		if(button_2.getText()=="0" || button_4.getText()=="0" 
				|| button_6.getText()=="0" || button_8.getText()=="0"){
			if(button_2.getText()=="0"){
				button_2.setText(button_5.getText());
				button_5.setText("0");
				button_2.setBackground(Color.BLACK);
				button_2.setForeground(Color.WHITE);
				button_5.setBackground(Color.WHITE);
				button_5.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else if(button_4.getText()=="0"){
				button_4.setText(button_5.getText());
				button_5.setText("0");
				button_4.setBackground(Color.BLACK);
				button_4.setForeground(Color.WHITE);
				button_5.setBackground(Color.WHITE);
				button_5.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else if(button_6.getText()=="0"){
				button_6.setText(button_5.getText());
				button_5.setText("0");
				button_6.setBackground(Color.BLACK);
				button_6.setForeground(Color.WHITE);
				button_5.setBackground(Color.WHITE);
				button_5.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else{
				button_8.setText(button_5.getText());
				button_5.setText("0");
				button_8.setBackground(Color.BLACK);
				button_8.setForeground(Color.WHITE);
				button_5.setBackground(Color.WHITE);
				button_5.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			}
		}
	}
	void button6performed(){
		if(button_3.getText()=="0" || button_5.getText()=="0" || button_0.getText()=="0"){
			if(button_3.getText()=="0"){
				button_3.setText(button_6.getText());
				button_6.setText("0");
				button_3.setBackground(Color.BLACK);
				button_3.setForeground(Color.WHITE);
				button_6.setBackground(Color.WHITE);
				button_6.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else if(button_5.getText()=="0"){
				button_5.setText(button_6.getText());
				button_6.setText("0");
				button_5.setBackground(Color.BLACK);
				button_5.setForeground(Color.WHITE);
				button_6.setBackground(Color.WHITE);
				button_6.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else {
				button_0.setText(button_6.getText());
				button_6.setText("0");
				button_0.setBackground(Color.BLACK);
				button_0.setForeground(Color.WHITE);
				button_6.setBackground(Color.WHITE);
				button_6.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			}
		}
	}
	void button7performed(){
		if(button_4.getText()=="0" || button_8.getText()=="0"){
			if(button_4.getText()=="0"){
				button_4.setText(button_7.getText());
				button_7.setText("0");
				button_4.setBackground(Color.BLACK);
				button_4.setForeground(Color.WHITE);
				button_7.setBackground(Color.WHITE);
				button_7.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else {
				button_8.setText(button_7.getText());
				button_7.setText("0");
				button_8.setBackground(Color.BLACK);
				button_8.setForeground(Color.WHITE);
				button_7.setBackground(Color.WHITE);
				button_7.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			}
		}
	}
	void button8performed(){
		if(button_5.getText()=="0" || button_7.getText()=="0" || button_0.getText()=="0"){
			if(button_5.getText()=="0"){
				button_5.setText(button_8.getText());
				button_8.setText("0");
				button_5.setBackground(Color.BLACK);
				button_5.setForeground(Color.WHITE);
				button_8.setBackground(Color.WHITE);
				button_8.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else if(button_7.getText()=="0"){
				button_7.setText(button_8.getText());
				button_8.setText("0");
				button_7.setBackground(Color.BLACK);
				button_7.setForeground(Color.WHITE);
				button_8.setBackground(Color.WHITE);
				button_8.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else {
				button_0.setText(button_8.getText());
				button_8.setText("0");
				button_0.setBackground(Color.BLACK);
				button_0.setForeground(Color.WHITE);
				button_8.setBackground(Color.WHITE);
				button_8.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			}
		}
	}
	void button0performed(){
		if(button_6.getText()=="0" || button_8.getText()=="0"){
			if(button_6.getText()=="0"){
				button_6.setText(button_0.getText());
				button_0.setText("0");
				button_6.setBackground(Color.BLACK);
				button_6.setForeground(Color.WHITE);
				button_0.setBackground(Color.WHITE);
				button_0.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			} else {
				button_8.setText(button_0.getText());
				button_0.setText("0");
				button_8.setBackground(Color.BLACK);
				button_8.setForeground(Color.WHITE);
				button_0.setBackground(Color.WHITE);
				button_0.setForeground(Color.BLACK);
				lblMoves.setText("Moves:"+(++moves));
				status = button_1.getText()+button_2.getText()+button_3.getText()
						+button_4.getText()+button_5.getText()+button_6.getText()
						+button_7.getText()+button_8.getText()+button_0.getText();
				check(status);
			}
		}
	}
}