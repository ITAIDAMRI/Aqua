package gui;

import java.awt.EventQueue;
import java.awt.Graphics;

import q3.Swimmable;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Window;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class AquaFrame extends JFrame implements ActionListener  {
	public static AddAnimalDialog animaldialog=new AddAnimalDialog();
	public InfoFrame infoframe=new InfoFrame();
	private boolean table = false;
	private JFrame frmMyaquariun;
	private JScrollPane scrollPane =new JScrollPane();
	private Graphics graphics;
	private Image image;
	static public AquaPanel panel_2 = new AquaPanel();
	protected Window frame;
	public JLabel lblNewLabel = null;
	public boolean food=false;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
	}

	/**
	 * Create the application.
	 */
	public void work() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AquaFrame window = new AquaFrame();
					window.frmMyaquariun.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AquaFrame() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMyaquariun = new JFrame();
		frmMyaquariun.setTitle("MyAquarium");
		frmMyaquariun.setBounds(100, 100, 1200, 700);
		frmMyaquariun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(0, 0, 1200, 630);
		frmMyaquariun.getContentPane().add(scrollPane , BorderLayout.SOUTH);
		

		JPanel panel = new JPanel();
		//panel.setBackground(Color.gray);
		frmMyaquariun.getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(0, 7, 0, 0));
		
		
		JButton AddAnimal = new JButton("Add Animal");
		AddAnimal.setBackground(Color.LIGHT_GRAY);
		AddAnimal.setForeground(new Color(0, 0, 0));
		AddAnimal.addActionListener(this);
		panel.add(AddAnimal);
		
		JButton Sleep = new JButton("Sleep");
		Sleep.setBackground(Color.LIGHT_GRAY);
		Sleep.addActionListener(this);
		panel.add(Sleep);
		
		JButton WakeUp = new JButton("Wake Up");
		WakeUp.setBackground(Color.LIGHT_GRAY);
		WakeUp.addActionListener(this);
		panel.add(WakeUp);
		
		JButton Reset = new JButton("Reset");
		Reset.setBackground(Color.LIGHT_GRAY);
		Reset.addActionListener(this);
		panel.add(Reset);
		
		JButton Food = new JButton("Food");
		Food.setBackground(Color.LIGHT_GRAY);
		Food.addActionListener(this);
		panel.add(Food);
		
		JButton Info = new JButton("Info");
		Info.setBackground(Color.LIGHT_GRAY);
		Info.addActionListener(this);
		panel.add(Info);
		
		JButton Exit = new JButton("Exit");
		Exit.setBackground(Color.LIGHT_GRAY);
		Exit.addActionListener(this);
		panel.add(Exit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		frmMyaquariun.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		this.panel_2.setBackground(Color.WHITE);
		frmMyaquariun.getContentPane().add(this.panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		frmMyaquariun.setJMenuBar(menuBar);
		
		JMenu File = new JMenu("File");
		menuBar.add(File);
		
		JMenuItem menBarIteamExit = new JMenuItem("Exit");
		menBarIteamExit.addActionListener(this);
		File.add(menBarIteamExit);
		
		JMenu BackGround = new JMenu("BackGround");
		
		menuBar.add(BackGround);
		
		JMenuItem Image = new JMenuItem("lmage");
		Image.addActionListener(this);
		BackGround.add(Image);
		
		JMenuItem Blue = new JMenuItem("Blue");
		Blue.addActionListener(this);
		BackGround.add(Blue);
		
		JMenuItem None = new JMenuItem("None");
		None.addActionListener(this);
		BackGround.add(None);
		
		JMenu MenuBarHELP = new JMenu("Help");
		menuBar.add(MenuBarHELP);
		
		JMenuItem HelpItem = new JMenuItem("Help");
		HelpItem.addActionListener(this);
		MenuBarHELP.add(HelpItem);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Add Animal"://case call animaldialog and paint it
			animaldialog.setVisible(true);
			this.panel_2.repaint();
			panel_2.setVisible(true);
			
			break;
		case "Sleep"://case who call for fun stoprunning which calls setsuspend and stop painting the repainting of the swimmable objects
			Game.isRunning=false;
			panel_2.stopRunning();

			break;
		case "Wake Up"://case who call for fun resumerunning which calls setresume and repainting the swimmable objects
			Game.isRunning=true;
			panel_2.resumeRunning();

			break;
		case "Reset"://case which reset list of threads and repaint the screen
			panel_2.animals=new HashSet();
			panel_2.repaint();
			break;
		case "Food"://case which inc food and call func food and repaint the sreen with the food
			AquaPanel.food++;
			food();
			break;
		case "Info"://case who which calls func info and calls frame info
			info();
			break;
		case "Blue"://change back screen to blue
			if(this.lblNewLabel!=null) {
				panel_2.remove(lblNewLabel);
				this.lblNewLabel=null;
			}
			panel_2.setBackground(Color.blue);
			panel_2.setVisible(true);
			break;
		case "lmage"://change back screen to aquarium pic
			this.lblNewLabel=new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\\u05D0\u05D9\u05EA\u05D9\\Desktop\\318375714\\src\\aquaimg.png"));
			lblNewLabel.setBounds(0, 0, 1200, 606);
			panel_2.add(lblNewLabel);
			break;
		case "None"://change back screen to white
			if(this.lblNewLabel!=null) {
				panel_2.remove(lblNewLabel);
				this.lblNewLabel=null;
			}
			panel_2.setBackground(Color.white);
			panel_2.setVisible(true);
			break;
		case "Help"://call windows message
			System.out.print(111111);
			JOptionPane.showMessageDialog(null,
			        "Home work 3"+"\n"+"GUI @ Threads" ,
			        "Message",
			        JOptionPane.INFORMATION_MESSAGE);
		    break;
		case "Exit"://when click on exit its calls te game
			frmMyaquariun.dispose();
			frmMyaquariun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmMyaquariun.setVisible(false);
			break;
		}
		
	}
	public void food() {
		//when worm was added
		panel_2.isFood=true;
		panel_2.repaint();

	}
	public void info() {//add the stat of the swimmble objects to info frame
		   if(table == true) {
			   infoframe.setVisible(false);
			   table = false;
		   }
		   else{
			   	infoframe=new InfoFrame();
	 			 int i=0;
	 			 String[] columnNames = {"Animal", "Color", "Size", "Hor.speed", "Ver.speed","Eat counter"};
	 			 String [][] data = new String[panel_2.animals.size()][columnNames.length];
	 			 //System.out.print(columnNames.length);
	 			 for(Swimmable s : panel_2.animals) {
	 				 
	 		    	 data[i][0] = ""+s.getAnimalName();
	 		    	 data[i][1] = ""+s.getColor();
	 		    	 data[i][2] = ""+s.getSize();
	 		    	 data[i][3] = ""+s.getHorSpeed();
	 		    	 data[i][4] = ""+s.getVerSpeed();
	 		    	 data[i][5] = ""+s.getEatCount();
	 		    	  i++;
	 			 }
	 			 
	 			 JTable tableData= new JTable(data, columnNames);
	 		     scrollPane = new JScrollPane(tableData);
	 		     scrollPane.setViewportView(tableData);
	 		     scrollPane.setVisible(true);
	 		     scrollPane.setBounds(0, 0, 600, 100);
	 		     infoframe.getContentPane().add(scrollPane);
	 		     infoframe.setVisible(true);
	 		     table = true;
	 	   }
		   
	}
}

