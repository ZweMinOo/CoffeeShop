import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CoffeeShop extends JFrame implements ItemListener, ActionListener{

	//Declaration
	private static String version ="3.0";
	private JCheckBox [] cb = {new JCheckBox("Ice-cream - 500Ks"),new JCheckBox("Cola - 300Ks"),new JCheckBox("Sprite - 300Ks"),
			new JCheckBox("Orange - 300Ks"),new JCheckBox("Coffee - 500Ks"),new JCheckBox("Burger - 1000Ks"),
			new JCheckBox("Sandwich - 800Ks"),new JCheckBox("Fride Potato - 800Ks")};
	private JRadioButton [] rb = 	{new JRadioButton("Chicken - 100Ks"),new JRadioButton("Pork - 50Ks"),new JRadioButton("Beef - 200Ks")};
	private JRadioButton [] rb1 = 	{new JRadioButton("Chicken - 100Ks      "),new JRadioButton("Pork - 50Ks"),new JRadioButton("Beef - 200Ks")};
	private JRadioButton [] rb2 = 	{new JRadioButton("Hot - 500Ks"),new JRadioButton("Cold - 800Ks")};
	private int [] price = {500,300,300,300,0,1000,800,800};
	private int [] pickPrice = {100,50,200};
	private int [] coffeePrice={500,800};
	
	private JTextField showPrice = new JTextField(10);
	private JLabel lb = new JLabel();
	private JLabel shopName = new JLabel("CoffeeShop");
	private JLabel place = new JLabel();
	private JLabel titleLb = new JLabel();
	private JLabel pickBurger1= new JLabel(" Pick");
	private JLabel pickBurger2= new JLabel(" up");
	private JLabel pickBurger3= new JLabel(" for");
	private JLabel pickBurger4= new JLabel(" Burger");
	private JPanel burgerTit = new JPanel();
	
	private JLabel pickSandwich1= new JLabel(" Pick");
	private JLabel pickSandwich2= new JLabel(" up");
	private JLabel pickSandwich3= new JLabel(" for");
	private JLabel pickSandwich4= new JLabel(" Sandwich");
	private JPanel sandwichTit = new JPanel();
	
	private JLabel pickCoffee1= new JLabel(" Pick");
	private JLabel pickCoffee2= new JLabel(" up");
	private JLabel pickCoffee3= new JLabel(" for");
	private JLabel pickCoffee4= new JLabel(" Coffee");
	private JPanel coffeeTit = new JPanel();
	
	
	private JLabel sign = new JLabel("Created by Z.M.O");
	private JLabel sp = new JLabel("************************");
	private JLabel sp1 = new JLabel("*****************************************");
	ImageIcon bg = new ImageIcon("C:\\Users\\James James\\desktop\\cf\\bg.png");
	private JPanel panel = new JPanel(new BorderLayout());
	private static JPanel mainP = new JPanel();
	private JPanel sTitle = new JPanel(new FlowLayout());
	private JPanel title = new JPanel();

	private Color c =new Color (153,255,51);
	private Color Light_Blue = new Color(17,214,236);

	private JButton btn = new JButton("BUY");
	private Container con = getContentPane();
	
	private Font myFont = new Font("Comic Sans MS", Font.BOLD, 18);
	private Font bigFont = new Font("Myriad Pro", Font.BOLD,20);
	private Font myFont1 = new Font("Myarid Pro", Font.BOLD+Font.ITALIC,14);
	private ButtonGroup g1=new ButtonGroup();
	private ButtonGroup g2=new ButtonGroup();
	private ButtonGroup g3=new ButtonGroup();
	
	private JPanel p123 = new JPanel(new GridLayout(1,3,2,2));
	private JPanel p1 = new JPanel(new GridLayout(4,1,2,2));
	private JPanel p2 = new JPanel(new GridLayout(4,1,2,2));
	private JPanel p3 = new JPanel(new GridLayout(2,2,2,2));
	private JPanel p4 = new JPanel(new GridLayout(4,1,2,2));
	private JPanel p5 = new JPanel(new GridLayout(4,1,2,2));
	private JPanel p6 = new JPanel(new GridLayout(4,1,2,2));
	
	private JPanel box1 = new JPanel(new FlowLayout());
	private JPanel box2 = new JPanel();
	
	private ImageIcon [] ico = {new ImageIcon("C:\\Users\\James James\\desktop\\cf\\ice.png"),
			new ImageIcon("C:\\Users\\James James\\desktop\\cf\\cola.png"),
			new ImageIcon("C:\\Users\\James James\\desktop\\cf\\sprite.png"),
			new ImageIcon("C:\\Users\\James James\\desktop\\cf\\orange.png"),
			new ImageIcon("C:\\Users\\James James\\desktop\\cf\\coffee.png"),
			new ImageIcon("C:\\Users\\James James\\desktop\\cf\\burger.png"),
			new ImageIcon("C:\\Users\\James James\\desktop\\cf\\sandwish.png"),
			new ImageIcon("C:\\Users\\James James\\desktop\\cf\\fride potato.png")};
	
	private String [] name = {"Ice-cream","Cola","Sprite","Orange","Coffee","Burger","Sandwich","Fride Potato"};
	private String [] pickName = {"Chicken","Pork","Beef"};	
	private String [] pickCoffeeName = {"Hot", "Cold"};
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Date date = new Date();
	private JTextField timeField; 
	private JTextField checkTime; 
	
	private String nameStr;
	//MenuBar
	JMenuBar mainBar = new JMenuBar();
	
	JMenu menu = new JMenu("File");
	JMenuItem exit =new JMenuItem("Exit");
	JMenuItem change = new JMenuItem("Change Shop's Name");;
	
	JMenu menu1 = new JMenu("Edit");
	JMenuItem record = new JMenuItem("View Record");
	
	JMenu menu2 = new JMenu("Help");
	JMenuItem viewHelp = new JMenuItem("View Help");
	JMenu about = new JMenu("About");
	JTextArea about1 = new JTextArea(5,3);
	JPanel aboutPanel = new JPanel(new FlowLayout());
	JMenu design = new JMenu("Change Design");
	JMenuItem design1 = new JMenuItem("Design-1");
	JMenuItem design2 = new JMenuItem("Design-2");
	//JMenuItem design3 = new JMenuItem("Design-3");
	boolean isKey=true;

	//Constructor
	public CoffeeShop(){
		super("Coffee Shop - " + version);
		con.setLayout(new FlowLayout(FlowLayout.LEFT));
		//Menu Bar
		setJMenuBar(mainBar);
		mainBar.setBackground(Color.WHITE);
		
		mainBar.add(menu); menu.setFont(myFont1);

		menu.add(change); change.setFont(myFont1);
		change.setIcon(new ImageIcon("C:\\Users\\James James\\Desktop\\cf\\cName.png"));
		menu.add(exit);  exit.setFont(myFont1);
		exit.setIcon(new ImageIcon("C:\\Users\\James James\\Desktop\\cf\\exitIcon.png"));
		
		mainBar.add(menu1); menu1.setFont(myFont1);
		menu1.add(record); record.setFont(myFont1);  
		record.setIcon(new ImageIcon("C:\\Users\\James James\\Desktop\\cf\\recordIcon.png"));
		menu1.add(design);
		design.add(design1);  design.setFont(myFont1); design1.setFont(myFont1);// design.add(design3);
		design.add(design2);  design2.setFont(myFont1);
		mainBar.add(menu2); menu2.setFont(myFont1);
		menu2.add(viewHelp);  viewHelp.setFont(myFont1); 
		viewHelp.setIcon(new ImageIcon("C:\\Users\\James James\\Desktop\\cf\\viewHelpIcon.png"));
		menu2.add(about); about.setFont(myFont1); 
		about.setIcon(new ImageIcon("C:\\Users\\James James\\Desktop\\cf\\aboutIcon.png"));
		about.add(aboutPanel); 
		aboutPanel.add(about1); aboutPanel.setBackground(Color.BLACK);
		about1.setFont(new Font("Time News Roman", Font.BOLD, 17));
		about1.setBackground(Color.DARK_GRAY); 
		about1.setForeground(Color.GREEN); about1.setEditable(false);
		about1.setText("About: \n Name \t-  OrderApk \nCreater \t-  Zwe Min Oo\nVersion \t-  "+  version+
				"\nDate \t-  7/24/2016 \nHND - 8");
		
		//ActiorListener for Menu Bar
		change.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				 nameStr = JOptionPane.showInputDialog(null, "ENTER","Changing Name",JOptionPane.INFORMATION_MESSAGE);
				 shopName.setText(nameStr);
				 if(nameStr.equals(""))
					 shopName.setText("CoffeeShop");
			}
		});
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String ObjButtons[] = {"Yes","No"};
				int dialogResult =JOptionPane.showOptionDialog(null,"Are your sure want to exit?","Confirm",  JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
				if(dialogResult==JOptionPane.OK_OPTION)
				{
					System.exit(0);
				}
			}
		});
		record.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				security();
				isKey=true;
			}
		});
		viewHelp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				helpText("Purpose - Coffee Shop\n Tools \n- Changing Shop'sName\n- Keeping Data \n- Deleting Data \n- Showing Data \n- Changing color on showing data","View Help");
			}
		});
		design1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				con.setBackground(Color.WHITE);
				p123.setBackground(Color.WHITE);
				p1.setBackground(Color.WHITE);
				p2.setBackground(Color.WHITE);
				p3.setBackground(Color.WHITE);
				p4.setBackground(Color.WHITE);
				p5.setBackground(Color.WHITE);
				p6.setBackground(Color.WHITE);
				mainP.setBackground(Color.WHITE);
				for(int x=0;x<cb.length;x++) {
					cb[x].setBackground(Color.BLACK);
					cb[x].setForeground(Color.WHITE);
				}
				for(int x=0;x<rb.length;x++)
				{
					rb[x].setBackground(Color.BLACK);
					rb[x].setForeground(Color.WHITE);
				}
				for(int x=0;x<rb1.length;x++)
				{
					rb1[x].setBackground(Color.BLACK);
					rb1[x].setForeground(Color.WHITE);
				}
				for(int x=0;x<rb2.length;x++)
				{
					rb2[x].setBackground(Color.BLACK);
					rb2[x].setForeground(Color.WHITE);
				}
				sTitle.setBackground(Color.DARK_GRAY);
				title.setBackground(Color.GRAY);
				box2.setBackground(Color.GRAY);
				sp.setForeground(Color.GRAY);
				coffeeTit.setBackground(Color.BLACK);
				burgerTit.setBackground(Color.BLACK);
				sandwichTit.setBackground(Color.BLACK);
			}
		});
		
		design2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				con.setBackground(Color.BLACK);
				p123.setBackground(Color.BLACK);
				p1.setBackground(Color.BLACK);
				p2.setBackground(Color.BLACK);
				p3.setBackground(Color.BLACK);
				p4.setBackground(Color.BLACK);
				p5.setBackground(Color.BLACK);
				p6.setBackground(Color.BLACK);
				box2.setBackground(Color.YELLOW);
				mainP.setBackground(Color.BLACK);
				for(int x=0;x<cb.length;x++) {
					cb[x].setBackground(Color.WHITE);
					cb[x].setForeground(Color.BLACK);
				}
				for(int x=0;x<rb.length;x++)
				{
					rb[x].setBackground(Color.WHITE);
					rb[x].setForeground(Color.BLACK);
				}
				for(int x=0;x<rb1.length;x++)
				{
					rb1[x].setBackground(Color.WHITE);
					rb1[x].setForeground(Color.BLACK);
				}
				for(int x=0;x<rb2.length;x++)
				{
					rb2[x].setBackground(Color.WHITE);
					rb2[x].setForeground(Color.BLACK);
				}
				sTitle.setBackground(Color.BLACK);
				title.setBackground(Color.BLACK);
				sp.setForeground(Color.BLACK);
				coffeeTit.setBackground(Color.BLACK);
				burgerTit.setBackground(Color.BLACK);
				sandwichTit.setBackground(Color.BLACK);
			}
		});
		//END Menu Bar
		//setting background
		con.setBackground(Color.BLACK);
		p123.setBackground(Color.BLACK);
		p1.setBackground(Color.BLACK);
		p2.setBackground(Color.BLACK);
		p3.setBackground(Color.BLACK);
		p4.setBackground(Color.BLACK);
		p5.setBackground(Color.BLACK);
		p6.setBackground(Color.BLACK);
		
		//setClock
	       timeField = new JTextField(8);
	       checkTime = new JTextField(2);
	       timeField.setEditable(false);
	       checkTime.setEditable(false);
	       timeField.setFont(new Font("Myriad Pro", Font.BOLD, 28));
	       checkTime.setFont(new Font("Myriad Pro", Font.BOLD, 28));
	        // Create a 1-second timer and action listener for it.
	        javax.swing.Timer t = new javax.swing.Timer(1000,
	              new ActionListener() {
	                  public void actionPerformed(ActionEvent e) {
	                      Calendar now = Calendar.getInstance();
	                      int h = now.get(Calendar.HOUR_OF_DAY);
	                      int m = now.get(Calendar.MINUTE);
	                      int s = now.get(Calendar.SECOND);
	                      if(h>12){
	                    	  timeField.setText("" + (h-12) + ":" + m + ":" + s );
	                    	  checkTime.setText("P.M");
	                      }
	                      else{
	                    	  timeField.setText("" + h + ":" + m + ":" + s );
	                    	  checkTime.setText("A.M");
	                      }
				timeField.setForeground(Color.BLACK);
				//timeField.setBackground(Color.GRAY);
	                  }
	              });
	        t.start();  // Start the timer
	    //endSetClock
	    //Make icon
	    ImageIcon icon = new ImageIcon("C:\\Users\\James James\\desktop\\img.png");
	 
	    //Title
	    
	    title.setLayout(new FlowLayout());
	    JLabel a = new JLabel();
	    a.setIcon(icon);
	    title.add(a);
	    sTitle.setBackground(Color.BLACK);
		titleLb.setText("Welcome From ");
		titleLb.setFont(new Font("Juice ITC", Font.BOLD, 43));
		titleLb.setForeground(Light_Blue);
		shopName.setFont(new Font("Juice ITC", Font.BOLD, 43));
		shopName.setForeground(Light_Blue);
		title.setBackground(Color.BLACK);
		sTitle.add(a, FlowLayout.LEFT);
		sTitle.add(titleLb, FlowLayout.CENTER);
		sTitle.add(shopName,FlowLayout.RIGHT);
		title.add(sTitle, FlowLayout.LEFT);
		sp.setForeground(Color.BLACK);
		sp.setFont(bigFont);
		title.add(sp);
		title.add(timeField);
		title.add(checkTime);
		mainP.setLayout(new BoxLayout(mainP, 1));
		mainP.add(title);
		mainP.add(panel);
		mainP.setBackground(Color.BLACK);
		
		// Menu Declaration
		//add to box1
		box1.setLayout(new FlowLayout());
		p123.add(p1);
		p123.add(p2);
		p123.add(p3);
		box1.add(p123);
		box1.setBackground(Color.BLACK);
		panel.add(box1, BorderLayout.NORTH);
		
		for(int x=0;x<=3;x++) {
			p1.add(cb[x]);
		}
		for(int x=4;x<=7;x++) {
			p2.add(cb[x]);
		}
		
		pickBurger1.setFont(myFont); pickBurger2.setFont(myFont); pickBurger3.setFont(myFont); pickBurger4.setFont(myFont);
		pickBurger1.setForeground(Light_Blue); pickBurger2.setForeground(Light_Blue); pickBurger3.setForeground(Light_Blue); pickBurger4.setForeground(c);
		pickSandwich1.setFont(myFont); pickSandwich2.setFont(myFont); pickSandwich3.setFont(myFont); pickSandwich4.setFont(myFont);
		pickSandwich1.setForeground(Light_Blue); pickSandwich2.setForeground(Light_Blue); pickSandwich3.setForeground(Light_Blue); pickSandwich4.setForeground(c);
		pickCoffee1.setFont(myFont); pickCoffee2.setFont(myFont); pickCoffee3.setFont(myFont); pickCoffee4.setFont(myFont);
		pickCoffee1.setForeground(Light_Blue); pickCoffee2.setForeground(Light_Blue); pickCoffee3.setForeground(Light_Blue); pickCoffee4.setForeground(c);
		burgerTit.setLayout(new BoxLayout(burgerTit, 0));
		burgerTit.add(pickBurger1);
		burgerTit.add(pickBurger2);
		burgerTit.add(pickBurger3);
		burgerTit.add(pickBurger4);
		burgerTit.setBackground(Color.BLACK);
		
		sandwichTit.setLayout(new BoxLayout(sandwichTit, 0));
		sandwichTit.add(pickSandwich1);
		sandwichTit.add(pickSandwich2);
		sandwichTit.add(pickSandwich3);
		sandwichTit.add(pickSandwich4);
		sandwichTit.setBackground(Color.BLACK);
		
		
		coffeeTit.setLayout(new BoxLayout(coffeeTit, 0));
		coffeeTit.add(pickCoffee1);
		coffeeTit.add(pickCoffee2);
		coffeeTit.add(pickCoffee3);
		coffeeTit.add(pickCoffee4);
		coffeeTit.setBackground(Color.BLACK);
		
		//Adding to panel
		p4.add(burgerTit);
		p5.add(sandwichTit);
		p6.add(coffeeTit);
		
		for(int x=0;x<3;x++) {
			p4.add(rb[x]);
		}
		for(int x=0;x<3;x++) {
			p5.add(rb1[x]);
		}
		for(int x=0;x<2;x++) {
			p6.add(rb2[x]);
		}
		p3.add(p4);
		p3.add(p5);
		p3.add(p6);
		p3.add(place);
		//Showing Price

		box2.setBackground(Color.YELLOW);
		lb.setFont(myFont);
		lb.setText("Total Price ");
		showPrice.setText(total+" Ks");
		box2.setLayout(new FlowLayout());
		box2.add(lb);
		box2.add(showPrice);
		box2.add(btn);
		showPrice.setFont(myFont);
		showPrice.setBackground(Color.WHITE);
		showPrice.setEditable(false);
		panel.add(box2, BorderLayout.CENTER);
		
		//Adding ItemListener
		for(int x=0;x<cb.length;x++) {
			cb[x].addItemListener(this);
			cb[x].setBackground(Color.WHITE);
			cb[x].setFont(myFont);
			cb[x].setIcon(ico[x]);
			cb[x].setToolTipText("Click to Select Item");
		}
		for(int x=0;x<rb.length;x++)
		{
			rb[x].addItemListener(this);
			rb[x].setBackground(Color.WHITE);
			rb[x].setFont(myFont);
			rb[x].setEnabled(false);
			g1.add(rb[x]);
		}
		for(int x=0;x<rb1.length;x++)
		{
			rb1[x].addItemListener(this);
			rb1[x].setBackground(Color.WHITE);
			rb1[x].setFont(myFont);
			rb1[x].setEnabled(false);
			g2.add(rb1[x]);
		}
		for(int x=0;x<rb2.length;x++)
		{
			rb2[x].addItemListener(this);
			rb2[x].setBackground(Color.WHITE);
			rb2[x].setFont(myFont);
			rb2[x].setEnabled(false);
			g3.add(rb2[x]);
		}
		//Button
		JPanel lest = new JPanel(new FlowLayout());
		JLabel myImg = new JLabel();
		
		sign.setFont(myFont);
		JTextField date1 = new JTextField(10);
		date1.setBackground(Color.WHITE);
		date1.setFont(myFont);
		date1.setEditable(false);
		
		sp1.setForeground(Color.BLACK);
		sign.setForeground(c);
		date1.setText(dateFormat.format(date));
		date1.setBackground(Color.BLACK);
		date1.setForeground(Color.WHITE);
		lest.add(sign);
		ImageIcon zmo = new ImageIcon("C:\\Users\\James James\\Desktop\\cf\\zmo.png");
		myImg.setIcon(zmo);
		lest.add(myImg);
		myImg.setToolTipText("Click To View");
		sp1.setFont(bigFont);

		lest.add(sp1);
		lest.add(date1);
		lest.setBackground(Color.BLACK);
		mainP.add(lest);
		con.add(mainP);
		btn.setEnabled(false);
		btn.setFont(bigFont);
		btn.setToolTipText("Click To Buy");
		btn.setForeground(Color.BLACK);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try {
					setList();
				} catch (IOException e1) { }
				for(int i=0;i<cb.length;i++)
				{
					cb[i].setSelected(false);
					
				}
				JOptionPane.showMessageDialog(null, "Thank You for Buying form our shop","Thank",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		validate();
		
		addMouseListener(new myMListener());
		myImg.addMouseListener(new myMListener());
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\James James\\Desktop\\Icon.png"));
		//setIconImage(new ImageIcon(getClass().getClassLoader().getResource("C:\\Users\\James James\\Desktop\\Icon.png")));
	}
	public void showMyImg(){
		JFrame myPhoto = new JFrame("Z.M.O");
		JPanel s = new JPanel();
		myPhoto.setLayout(new BorderLayout());
		s.setBackground(Color.BLACK);
		myPhoto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon myPt = new ImageIcon("D:\\Desktop\\ZMO\\zmo.jpg");
		JLabel showPt = new JLabel();
		showPt.setIcon(myPt);
		s.add(showPt);
		myPhoto.add(s, BorderLayout.CENTER);
		myPhoto.setSize(myPt.getIconWidth()+20,myPt.getIconHeight()+40);
		myPhoto.setVisible(true);
		
		
	}
	   int count=0;
	    javax.swing.Timer t1 = new javax.swing.Timer(400,
	            new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	           
	                	if(count==0){
	                	pickCoffee1.setVisible(false);
	                	pickCoffee2.setVisible(false);
	                	pickCoffee3.setVisible(false);
	                	pickCoffee4.setVisible(false);
	                	}
	                count++;
	                	
	                	if(count>1&&count<6)
	                		pickCoffee1.setVisible(true);
	                	if(count>2&&count<6)
	                		pickCoffee2.setVisible(true);
	                	if(count>3&&count<6)
	                		pickCoffee3.setVisible(true);
	                	if(count>4&&count<6)
	                		pickCoffee4.setVisible(true);
	                	if(count==12)count=0;
	                		
	              	  	if(count==6) a=false;
	              	  	
	              	  	if(count==7) a=true;
	              	  		
	              	  	if(count==8) a=false;
	              	  		
	                  	if(count==9) a=true;
	                  		
	              	  	if(count==10) a=false;
	          	  			
	          	  		if(count==11) a=true;
	          	  			
	              	  	if(count>6){
	                    	pickCoffee1.setVisible(a);
	                    	pickCoffee2.setVisible(a);
	                    	pickCoffee3.setVisible(a);
	                    	pickCoffee4.setVisible(a);
	              	  	}
	                }
	            });
    int count1=0;
    javax.swing.Timer t2 = new javax.swing.Timer(400,
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
           
                	if(count1==0){
                	pickBurger1.setVisible(false);
                	pickBurger2.setVisible(false);
                	pickBurger3.setVisible(false);
                	pickBurger4.setVisible(false);
                	}
                count1++;
                	
                	if(count1>1&&count1<6)
                		pickBurger1.setVisible(true);
                	if(count1>2&&count1<6)
                		pickBurger2.setVisible(true);
                	if(count1>3&&count1<6)
                		pickBurger3.setVisible(true);
                	if(count1>4&&count1<6)
                		pickBurger4.setVisible(true);
                	if(count1==12)count1=0;
                		
              	  	if(count1==6)b=false;
              	  		
              	  	if(count1==7)	b=true;
              	  	
              	  	if(count1==8)b=false;
              	  		
                  	if(count1==9)b=true;
                  		
              	  	if(count1==10)b=false;
          	  			
          	  		if(count1==11)b=true;
          	  			
              	  	if(count1>6){
                    	pickBurger1.setVisible(b);
                    	pickBurger2.setVisible(b);
                    	pickBurger3.setVisible(b);
                    	pickBurger4.setVisible(b);
              	  	}
                }
            });
    int count2=0;
    javax.swing.Timer t3 = new javax.swing.Timer(400,
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
           
                	if(count2==0){
                	pickSandwich1.setVisible(false);
                	pickSandwich2.setVisible(false);
                	pickSandwich3.setVisible(false);
                	pickSandwich4.setVisible(false);
                	}
                count2++;
                	
                	if(count2>1&&count2<6)
                		pickSandwich1.setVisible(true);
                	if(count2>2&&count2<6)
                		pickSandwich2.setVisible(true);
                	if(count2>3&&count2<6)
                		pickSandwich3.setVisible(true);
                	if(count2>4&&count2<6)
                		pickSandwich4.setVisible(true);
                	if(count2==12) count2=0;
                	
                	if(count2==6) d=false;
              	  		
              	  	if(count2==7)d=true;
              	  		
              	  	if(count2==8)d=false;
              	  		
                  	if(count2==9)d=true;
                  		
              	  	if(count2==10)d=false;
          	  			
          	  		if(count2==11)d=true;
          	  			
              	  	if(count2>6){
                    	pickSandwich1.setVisible(d);
                    	pickSandwich2.setVisible(d);
                    	pickSandwich3.setVisible(d);
                    	pickSandwich4.setVisible(d);
              	  	}
                }
            });

	boolean a = false;
	boolean b = false;
	boolean d = false;
	private int total;
	public void itemStateChanged(ItemEvent e)
	{
		Object source = e.getSource();
		int select=  e.getStateChange();
		if(source==cb[0]) {
			if(select==ItemEvent.SELECTED) {
				total += price[0];
				cb[0].setBackground(Color.RED);
				
			}
			else {
				total -= price[0];
				cb[0].setBackground(Color.WHITE);
			}
		}
		else if(source==cb[1]) {
			if(select==ItemEvent.SELECTED) {
				total += price[1];
				cb[1].setBackground(Color.RED);
			}
			else {
				total -= price[1];
				cb[1].setBackground(Color.WHITE);
			}
		}
		else if(source==cb[2])
		{
			if(select==ItemEvent.SELECTED) {
				total += price[2];
				cb[2].setBackground(Color.RED);
			}
			else {
				total -= price[2];
				cb[2].setBackground(Color.WHITE);
			}
		}
		else if(source==cb[3])
		{
			if(select==ItemEvent.SELECTED) {
				total += price[3];
				cb[3].setBackground(Color.RED);
			}
			else {
				total -= price[3];
				cb[3].setBackground(Color.WHITE);
			}
		}
		else if(source==cb[4])
		{
			
			if(select==ItemEvent.SELECTED) {
				for(int x=0;x<2;x++) {
					rb2[x].setEnabled(true);
				}
				rb2[0].setSelected(true);
				cb[4].setBackground(Color.RED);

			        t1.start(); 
			        
			}
			else {
				total -= price[4];
				for(int x=0;x<2;x++) {
						rb2[x].setEnabled(false);
						g3.clearSelection();
					}
				pickCoffee1.setVisible(true);
				pickCoffee2.setVisible(true);
				pickCoffee3.setVisible(true);
				pickCoffee4.setVisible(true);
				t1.stop();
				cb[4].setBackground(Color.WHITE);
			}
		}
		else if(source==cb[5]) {
			if(select==ItemEvent.SELECTED) {
				total += price[5];
				for(int x=0;x<=2;x++) {
						rb[x].setEnabled(true);
				}
				t2.start();
				cb[5].setBackground(Color.RED);
			}
			else {
				total -= price[5];
				for(int x=0;x<=2;x++) {
				{	
					rb[x].setEnabled(false);
					g1.clearSelection();
				}
				pickBurger1.setVisible(true);
				pickBurger2.setVisible(true);
				pickBurger3.setVisible(true);
				pickBurger4.setVisible(true);
				t2.stop();
				cb[5].setBackground(Color.WHITE);
			}
		}
		}
		else if(source==cb[6]) {
			if(select==ItemEvent.SELECTED) {
				total += price[6];
				//s.setVisible(true);
				for(int x=0;x<=2;x++) {
						rb1[x].setEnabled(true);
				}
				t3.start();
				cb[6].setBackground(Color.RED);
			}
			else {
				total -= price[6];
				//s.setVisible(false);
				for(int x=0;x<=2;x++) 
					{	
						rb1[x].setEnabled(false);
						g2.clearSelection();
					}
					pickSandwich1.setVisible(true);
					pickSandwich2.setVisible(true);
					pickSandwich3.setVisible(true);
					pickSandwich4.setVisible(true);
				t3.stop();
				cb[6].setBackground(Color.WHITE);
			}
		}
		else if(source==cb[7]) {
			if(select==ItemEvent.SELECTED)	{
				total += price[7];
				cb[7].setBackground(Color.RED);
			}
			else {
				total -= price[7];
				cb[7].setBackground(Color.WHITE);
			}
		}
		else if(source==rb[0]) {
			if(select==ItemEvent.SELECTED) {
				total += pickPrice[0];
			}
			else {
				total -= pickPrice[0];
			}
		}
		else if(source==rb[1]) {
			if(select==ItemEvent.SELECTED)	{
				total += pickPrice[1];
			}
			else{
				total -= pickPrice[1];
			}
		}
		else if(source==rb[2]) {
			if(select==ItemEvent.SELECTED) {
				total += pickPrice[2];
			}
			else {
				total -= pickPrice[2];
			}
		}	
		else if(source==rb1[0]) {
			if(select==ItemEvent.SELECTED) {
				total += pickPrice[0];
			}
			else {
				total -= pickPrice[0];
			}
		}
		else if(source==rb1[1]) {
			if(select==ItemEvent.SELECTED)	{
				total += pickPrice[1];
			}
			else{
				total -= pickPrice[1];
			}
		}
		else if(source==rb1[2]) {
			if(select==ItemEvent.SELECTED) {
				total +=pickPrice[2];
			}
			else {
				total -= pickPrice[2];
			}
		}

		else if(source==rb2[0]) {
			if(select==ItemEvent.SELECTED) {
				total += coffeePrice[0];
			}
			else {
				total -= coffeePrice[0];
			}
		}
		else if(source==rb2[1]) {
			if(select==ItemEvent.SELECTED) {
				total += coffeePrice[1];
			}
			else {
				total -= coffeePrice[1];
			}
		}
		else 
			System.out.println();
		showPrice.setText(total+" Ks");
		for(int i=0;i<cb.length;i++)
		{
			if(cb[i].isSelected()==true){
				btn.setEnabled(true);
				btn.setBackground(Color.GREEN);
				i=9;
			}
			else{
				btn.setEnabled(false);
				btn.setBackground(Color.WHITE);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}	

	private void setList() throws IOException
	{
		final int line = 250;
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\User\\Desktop\\jv\\Data.txt", true));
		for(int i=0;i<line;i++)
		bw.write("-");
		bw.newLine();
		bw.write("Date - "+ dateFormat.format(date));
		bw.newLine();
		for(int i=0;i<line;i++)
			bw.write("-");
		bw.newLine();
		bw.write("\tItem Name\t\tPrice\t\tPick up");
		bw.newLine();
		for(int i=0;i<line;i++)
			bw.write("-");
		bw.newLine();
		for(int i=0;i<cb.length;i++){
			if(cb[i].isSelected()==true){
				if(i!=7&&i!=4)
				{
				bw.write("\t" + name[i]+ "\t\t"+ price[i]+"Ks"+"\t");
				}
				if(i==7){
				bw.write("\t" + name[i]+ "\t\t"+ price[i]+"Ks");
				
				}
				if(i==4){
					bw.write("\t" + name[i]+ "\t");
					for(int c=0;c<rb2.length;c++) {
						if(rb2[c].isSelected()==true)
							bw.write("\t"+ coffeePrice[c]+"Ks" + "\t\t" + pickCoffeeName[c] );
					}
					
				}
				if(i==5||i==6)
				{
					for(int c=0;c<rb.length;c++) {
						if(rb[c].isSelected()==true&&i==5){
							bw.write("\t" + pickName[c] + "\t(price +" + pickPrice[c] +"Ks)");
							}

						if(rb1[c].isSelected()==true&&i==6){
							bw.write("\t" + pickName[c] + "\t(price +" + pickPrice[c] +"Ks)"); }
						}

					}
				bw.newLine();
				}
				
			}
		
		for(int i=0;i<line;i++)
			bw.write("-");
		bw.newLine();
		bw.write("Total Amount - " + total+"");
		bw.newLine();
		for(int i=0;i<line;i++)
			bw.write("-");
		bw.newLine();bw.newLine();
		bw.flush();
		bw.close();
	}
	
	public void cleanData()throws Exception
	{
		FileWriter f = new FileWriter("C:\\Users\\User\\Desktop\\jv\\Data.txt");
	}
	
	JMenuBar mainBar1 = new JMenuBar();
	JMenu edit1 = new JMenu("Edit");
	JMenuItem clean = new JMenuItem("Clear Recrod");
	JMenu changeColor = new JMenu("Change Color");
	JMenuItem color1 = new JMenuItem("Black/White(Default)");
	JMenuItem color2 = new JMenuItem("White/Black");
	JMenuItem color3 = new JMenuItem("Green/Black");
	JMenuItem color4 = new JMenuItem("Black/Green");
	
	public void data()
	{
		final JFrame f = new JFrame("Data");
		f.setLayout(new BorderLayout());
		f.setSize(720,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.setResizable(false);
		f.validate();
		//Bar
		
		f.setJMenuBar(mainBar1);
		mainBar1.setBackground(Color.WHITE);
		mainBar1.add(edit1);
		edit1.add(clean);
		edit1.add(changeColor);
		changeColor.add(color1);
		changeColor.add(color2);
		changeColor.add(color3);
		changeColor.add(color4);
		
		//Adding ActionListener
		clean.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				try {
					cleanData();
				} catch (Exception e1) { 		}
				showingData.setText("");
				try {
					showData();
				} catch (Exception e1) {		}
			}
		});
		color1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				showingData.setForeground(Color.WHITE);
				showingData.setBackground(Color.BLACK);
			}
		});
		color2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				showingData.setForeground(Color.BLACK);
				showingData.setBackground(Color.WHITE);
			}
		});
		color3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				showingData.setForeground(Color.GREEN);
				showingData.setBackground(Color.BLACK);
			}
		});
		color4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				showingData.setForeground(Color.BLACK);
				showingData.setBackground(Color.GREEN);
			}
		});
		showingData.setFont(new Font("Time News Roman", Font.BOLD, 14));
		showingData.setForeground(Color.WHITE);
		showingData.setBackground(Color.BLACK);
		showingData.setEditable(false);

		JScrollPane scroll= new JScrollPane(showingData, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		//f.getContentPane().add(scroll);
		f.add(scroll);

	}

	public void showData()throws Exception
	{	
		FileReader fr = new FileReader("C:\\Users\\User\\Desktop\\jv\\Data.txt");
		BufferedReader br = new BufferedReader(fr);
		String str;
		int a = 0;
		while((str=br.readLine())!=null)
		{
			showingData.append(str+"\n");
		}
		data();
	}
	//Password field
	String str;
	String keepPs;
	JPasswordField pass = new JPasswordField(7);
	JCheckBox showPs = new JCheckBox("Show");
	JCheckBox remPs = new JCheckBox("Remember Password(Temporary)");
	
	public void security()
	{
		JFrame box = new JFrame("Security Check");
		pass.setFont(new Font("Time News Roman", Font.BOLD , 16));
		box.setLayout(new GridLayout(2,2,1,1));
		box.setSize(450,100);
		box.setResizable(false);
		box.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		box.setVisible(true);
		
		JButton enter = new JButton("ENTER");

		box.add(pass);
		box.add(enter);		
		enter.addKeyListener(new KeyPressed());
		pass.addKeyListener(new KeyPressed());
		enter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				str = pass.getText();
				if(str.equals(password)){
					try {
						showData();
						
					} catch (Exception e1) {		}
					
				}
				else{
					JOptionPane.showMessageDialog(null,"Incorret Password","Error",JOptionPane.ERROR_MESSAGE);
					//box.setVisible(b)
				}
				if(remPs.isSelected()!=true){
					pass.setText("");
				}
			}
		});
		box.add(showPs);
		box.add(remPs);
		pass.setEchoChar('o');
		pass.setToolTipText("Type Password In Feild");
		showPs.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ev)
			{
				Object source = ev.getSource();
				int select = ev.getStateChange();
				if(source==showPs)
				{
					if(select==ItemEvent.SELECTED)	{
						pass.setEchoChar((char)0);
					}
					else{
						pass.setEchoChar('#');
					}
				}
			}
		});
		remPs.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ev)
			{
				Object source = ev.getSource();
				int select = ev.getStateChange();
				if(source==showPs)
				{
					if(select==ItemEvent.SELECTED)	{
						if(str.equals(password))
						{
							remPs.setSelected(true);
							keepPs=pass.getText();
							pass.setText(keepPs);
						}
					}
					else{
						keepPs="";
					}
					
				}
			}
		});
		//box.setVisible(isShow);
		//addKeyListener(this);
		//addKeyListener(new KeyPressed());

		
	}
	public void helpText(String a,String title)
	{
		JFrame myText = new JFrame(title);
		
		
		myText.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myText.setLayout(new CardLayout());
		JPanel textA =new JPanel();
		textA.setBackground(Color.BLACK);
		JTextArea ta = new JTextArea(5,5);
		
		ta.setEditable(false);
		myText.setResizable(false);
		ta.setBackground(Color.DARK_GRAY);
		ta.setForeground(Color.GREEN);
		ta.append(a);
		ta.setFont(new Font("Time News Roman", Font.BOLD, 17));
		textA.add(ta);
		myText.add(textA, BorderLayout.CENTER);
		myText.setSize(290,210);
		myText.setVisible(true);
	}
	String password = "1111";
	

	JTextArea showingData = new JTextArea(20,10);
	public static void main(String[]args) throws Exception
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		CoffeeShop frame = new CoffeeShop();
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(1300,680);
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				String ObjButtons[] = {"Yes","No"};
				int PromptResult = JOptionPane.showOptionDialog(null,"Are your sure want to exit?","Confirm",  JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
				if(PromptResult==JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});
	}
	
	boolean isShow=true;
	
	class KeyPressed implements KeyListener
	{
		@Override
		public void keyPressed(KeyEvent e){
		int keyCode = e.getKeyCode();
		if(keyCode==e.VK_ENTER){
			str = pass.getText();
			if(str.equals(password)){
				try {
					showData();
				} catch (Exception e1) {	JOptionPane.showMessageDialog(null, "Incorret Password", "Error",JOptionPane.ERROR_MESSAGE);	}
				isShow=false;
			}
			else{
				
			}
			if(remPs.isSelected()!=true){
				pass.setText("");
			}
		}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

	
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			}
			
		}
	
		class myMListener implements MouseListener 		{
		 
	        public void mouseClicked(MouseEvent e) {
	        	
	        }

	        public void mousePressed(MouseEvent e) {
	        	showMyImg();
	        }
	 
	        public void mouseReleased(MouseEvent e) {

	        }

	        public void mouseEntered(MouseEvent e) {
	        	
	        }

	        public void mouseExited(MouseEvent e) {

	        }
	    }
}
