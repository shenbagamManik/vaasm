
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.net.URI;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.jdesktop.swingx.JXDatePicker;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TeamActivityTracker extends JFrame implements ActionListener, PropertyChangeListener{
	
	public static String fileName_Members = null ;
	public static String fileName_Activity = null;
	static String[] oto_mom = new String[2];
	
	private JPasswordField passWord;
    private JTextField txtEmpName;
    private JTextField txtVft;
    private JTextField txtExp;
    private JTextField txtFileMem;
    private JTextField txtFileTask;
    private JTextArea txtOno;
    private JTextArea txtDetails;
    private JButton btnSubmit;
    private JButton btnNewEmp;
    private JButton btnExistEmp;
    private JButton btnSave;
    private JButton btnCancel;
    private JButton btnExit;
    private JButton btnExSave;
    private JButton btnExCancel;
    private JButton btnAdd;
    private JButton btnReview;
    private JButton btnFileChooser_1;
    private JButton btnFileChooser_2;
    private JButton download;
    private JComboBox<String> comboName;
    private JComboBox<String> comboTask;
    private JFrame frm_login = new JFrame();
    private JFrame frm = new JFrame();
    private JFrame frm1 = new JFrame();
    private JFrame frm_MEM = new JFrame();
    JPanel autenticatePane = new JPanel();
    JPanel welcomePane = new JPanel();
    JPanel Registerpane = new JPanel();
    JPanel Memberpane = new JPanel();
    static DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
   
    static ArrayList<String> empName = new ArrayList<String>();
    Iterator iterator;
    public TeamActivityTracker() throws IOException

    {
    	  
         /* addWindowListener(new WindowAdapter() {
        	  
              @Override
              public void windowClosing(WindowEvent e)
              {
            	 

                  dispose();

                  System.exit(0);

              }

          });*/
    	
    	          String[] Activity = new String[] {"one-to-one", "MoM", "GPS","AI", "REMAINDER"};
    	          
    	  JLabel lblpw = new JLabel("Password: ");    	 
          JLabel lblName = new JLabel("Name: ");
          JLabel lblVft = new JLabel("VFT: ");
          JLabel lblExp = new JLabel("Experiance: ");
          JLabel lblExName = new JLabel("Name: ");
          JLabel lblExtask = new JLabel("Activity: ");
          JLabel lblDate = new JLabel("Date: ");   
          JLabel lblOto = new JLabel("One-to-one: ");
          JLabel lblmom = new JLabel("MOM");
          
          JLabel lblFileMeM = new JLabel("File location for members: ");
          JLabel lblFileTask = new JLabel("File location for Activities");
          
          
          passWord = new JPasswordField(20);
          txtDetails = new JTextArea(6, 50);
          txtDetails.setEditable(false);
          JScrollPane scrollPane_1 = new JScrollPane(txtDetails, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          txtOno = new JTextArea(6, 8);
          txtOno.setEditable(false);
          JScrollPane scrollPane_2 = new JScrollPane(txtOno, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
          txtEmpName = new JTextField(20);
          txtVft = new JTextField(20);
          txtExp = new JTextField(20);
          txtFileMem =new JTextField(30);
          txtFileTask =new JTextField(30);
          
          //Add list value to comboname         
          comboName = new JComboBox<String>();         
          comboTask = new JComboBox<String>(Activity);            
          
          btnSubmit = new JButton("Submit");
          btnNewEmp = new JButton("New");
          btnExistEmp = new JButton("Existing");
          btnSave = new JButton("Save");
          btnCancel = new JButton("Home");
          btnExit = new JButton("Exit");
          btnExSave = new JButton("Save");
          btnExCancel = new JButton("Home");
          btnAdd = new JButton("Add");
          btnReview = new JButton("Review");
          btnFileChooser_1 = new JButton("...");
          btnFileChooser_2 = new JButton("...");
          download = new JButton("Download");
          
          btnFileChooser_1.setSize(10, 10);
          btnFileChooser_2.setSize(10, 10);
          btnNewEmp.setFocusPainted(true);
          btnNewEmp.setEnabled(true);
          btnNewEmp.addActionListener(this);
          
          btnExistEmp.setFocusPainted(true);
          btnExistEmp.setEnabled(true);
          btnExistEmp.addActionListener(this);
          
          btnSave.setFocusPainted(true);
          btnSave.setEnabled(true);
          btnSave.addActionListener(this);
          
          btnCancel.setFocusPainted(true);
          btnCancel.setEnabled(true);
          btnCancel.addActionListener(this);
          //btnCancel.addKeyListener((KeyListener) this);
          
          btnExit.setFocusPainted(true);
          btnExit.setEnabled(true);
          btnExit.addActionListener(this);
          //btnExit.addKeyListener((KeyListener) this);
          
          btnExSave.addActionListener(this);
          btnExCancel.addActionListener(this);
          btnAdd.addActionListener(this);
          btnReview.addActionListener(this);
          btnSubmit.addActionListener(this);
         // btnSubmit.addKeyListener((KeyListener) this);
          btnFileChooser_1.addActionListener(this);
          btnFileChooser_2.addActionListener(this);
          download.addActionListener(this);
          
          LocalDate localDate = LocalDate.now();
          String today = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(localDate);
          System.out.println("Today::::"+today);
         
          /*Date today = Calendar.getInstance().getTime();*/
          
          JXDatePicker picker = new JXDatePicker();
          picker.setDate(Calendar.getInstance().getTime());
         
          picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
          picker.addActionListener(this);
          
          
          String selectedDay = picker.getDate().toString();
          
          System.out.println("today:::::"+today+"selectedDay::::"+selectedDay);
          
          if(today.equals(selectedDay)) {
        	  System.out.println("both day are equal");
          }
          
          
          autenticatePane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));         
          autenticatePane.setPreferredSize(new Dimension(550, 200));
          autenticatePane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Autentication"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
         //Starting point
          welcomePane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));         
          welcomePane.setPreferredSize(new Dimension(300, 100));
          welcomePane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Team Management"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
          
          //New registration
          Registerpane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));         
          Registerpane.setPreferredSize(new Dimension(300, 200));
          Registerpane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("New Registration"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
          
          //Memberpane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));    
          Memberpane.setPreferredSize(new Dimension(700, 700));
          Memberpane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Activity Management"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
          
          JPanel panInputauten = new JPanel(new BorderLayout());          
          panInputauten.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
          panInputauten.add(lblpw, BorderLayout.WEST);
          panInputauten.add(passWord, BorderLayout.EAST);
          
          JPanel panFilelocation_lbl = new JPanel(new BorderLayout());          
          panFilelocation_lbl.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));   
          panFilelocation_lbl.add(lblFileMeM, BorderLayout.NORTH);
          panFilelocation_lbl.add(lblFileTask, BorderLayout.SOUTH);
          
          JPanel panFilelocation_input1_chooser = new JPanel(new BorderLayout());           
          panFilelocation_input1_chooser.add(txtFileMem, BorderLayout.WEST);
          panFilelocation_input1_chooser.add(btnFileChooser_1, BorderLayout.EAST);
          
          JPanel panFilelocation_input2_chooser = new JPanel(new BorderLayout());           
          panFilelocation_input2_chooser.add(txtFileTask, BorderLayout.WEST);
          panFilelocation_input2_chooser.add(btnFileChooser_2, BorderLayout.EAST);
          
          JPanel panFilelocation_input = new JPanel(new BorderLayout());           
          panFilelocation_input.add(panFilelocation_input1_chooser, BorderLayout.NORTH);
          panFilelocation_input.add(panFilelocation_input2_chooser, BorderLayout.SOUTH);
          
          JPanel panFilelocation = new JPanel(new BorderLayout());    
          panFilelocation.setVisible(false);
          
          panFilelocation.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
          panFilelocation.add(panFilelocation_lbl, BorderLayout.WEST);
          panFilelocation.add(panFilelocation_input, BorderLayout.EAST);
          
          
          
          //Welcome form                
          JPanel panControlsWelcome = new JPanel(new BorderLayout());          
          panControlsWelcome.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
          panControlsWelcome.add(btnNewEmp, BorderLayout.WEST);
          panControlsWelcome.add(btnExistEmp, BorderLayout.EAST);
          
          //New Registration Form
          JPanel panDisplay = new JPanel(new BorderLayout());          
          panDisplay.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
          panDisplay.add(lblName, BorderLayout.NORTH);
          panDisplay.add(lblVft, BorderLayout.CENTER);
          panDisplay.add(lblExp, BorderLayout.SOUTH);
          
          JPanel panInput = new JPanel(new BorderLayout());          
          panInput.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
          panInput.add(txtEmpName, BorderLayout.NORTH);
          panInput.add(txtVft, BorderLayout.CENTER);
          panInput.add(txtExp, BorderLayout.SOUTH);
          
          JPanel panControlsRegis = new JPanel(new BorderLayout());          
          panControlsRegis.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
          panControlsRegis.add(btnSave, BorderLayout.WEST);
          panControlsRegis.add(btnCancel, BorderLayout.CENTER);
          panControlsRegis.add(btnExit, BorderLayout.EAST);
          
          JPanel panControlsRegis_1 = new JPanel(new BorderLayout()); 
          panControlsRegis_1.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
          panControlsRegis_1.add(panDisplay, BorderLayout.WEST);
          panControlsRegis_1.add(panInput, BorderLayout.EAST);
          
          JPanel panControlsRegis_2 = new JPanel(new BorderLayout()); 
          panControlsRegis_2.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
          panControlsRegis_2.add(panControlsRegis, BorderLayout.CENTER);
          
          //Existing user form
          JPanel panExDisplay = new JPanel(new BorderLayout(0, 5));           
          //panExDisplay.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));          
          panExDisplay.add(lblExName,BorderLayout.NORTH);          
          panExDisplay.add(lblExtask,BorderLayout.CENTER);          
          panExDisplay.add(lblDate,BorderLayout.SOUTH);
          
          JPanel panExInput = new JPanel(new BorderLayout(0, 5));          
         // panExInput.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
          //panExInput.setPreferredSize(new Dimension(100, 200));
          panExInput.add(comboName, BorderLayout.NORTH);          
          panExInput.add(comboTask, BorderLayout.CENTER);          
          panExInput.add(picker, BorderLayout.SOUTH);
          
          JPanel panControls = new JPanel(new BorderLayout());          
          //panControlsEmp.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));     
          panControls.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder(""), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
          panControls.setPreferredSize(new Dimension(10,30));
          panControls.add(btnAdd, BorderLayout.WEST);
          panControls.add(btnReview, BorderLayout.EAST);
          
          JPanel panExisting_1 = new JPanel(new BorderLayout(0, 5)); 
          panExisting_1.setPreferredSize(new Dimension(400,120));
         // panExisting_1.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
          panExisting_1.add(panExDisplay, BorderLayout.WEST);
          panExisting_1.add(panExInput, BorderLayout.EAST);
          panExisting_1.add(panControls, BorderLayout.SOUTH);
          
          JPanel panBelow_1 = new JPanel(new BorderLayout(0, 5));
          panBelow_1.setPreferredSize(new Dimension(600,200));
          panBelow_1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("One-to-One"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
          panBelow_1.add(scrollPane_1,BorderLayout.CENTER);
          
          JPanel panBelow_2 = new JPanel(new BorderLayout(0, 5));
          panBelow_2.setPreferredSize(new Dimension(600,50));
          panBelow_2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("MOM"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
          panBelow_2.add(scrollPane_2,BorderLayout.CENTER);
          
          JPanel panBelow_3 = new JPanel(new BorderLayout());          
          //panControlsEmp.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
          panBelow_3.setPreferredSize(new Dimension(50,50));
          panBelow_3.add(btnExSave, BorderLayout.WEST);
          panBelow_3.add(download, BorderLayout.CENTER);
          panBelow_3.add(btnExCancel, BorderLayout.EAST);
          btnExSave.setVisible(false);
          download.setVisible(false);
          btnExCancel.setVisible(false);
          
          
          
          JPanel panExisting_2 = new JPanel(new BorderLayout(0, 5)); 
          panExisting_2.setPreferredSize(new Dimension(600,500));
         // panExisting_1.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
          panExisting_2.add(panBelow_1, BorderLayout.NORTH);
          panExisting_2.add(panBelow_2, BorderLayout.CENTER);
          panExisting_2.add(panBelow_3, BorderLayout.SOUTH);
         
          
          autenticatePane.add(panInputauten, BorderLayout.NORTH);
          autenticatePane.add(panFilelocation, BorderLayout.CENTER);
          autenticatePane.add(btnSubmit, BorderLayout.SOUTH);
          welcomePane.add(panControlsWelcome, BorderLayout.CENTER);
          Registerpane.add(panControlsRegis_1, BorderLayout.NORTH);         
          Registerpane.add(panControlsRegis_2, BorderLayout.SOUTH);
          Memberpane.add(panExisting_1,BorderLayout.NORTH);          
          Memberpane.add(panExisting_2,BorderLayout.SOUTH);
          
          
         
          frm_login.add(autenticatePane, BorderLayout.CENTER);
          frm_login.setLocation(600, 500);
          frm_login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT
          frm_login.setResizable(false);
          frm_login.pack();
          frm_login.setVisible(true);
          frm_login.getRootPane().setDefaultButton(btnSubmit);
          
         // welcomePane.add(panControls, BorderLayout.SOUTH);
          frm.add(welcomePane, BorderLayout.CENTER);
          frm.setLocation(600, 500);
          frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT
          frm.setResizable(false);
          frm.pack();
          frm.setVisible(false);
          frm.getRootPane().setDefaultButton(btnNewEmp);
          
          frm1.add(Registerpane, BorderLayout.CENTER);
          frm1.setLocation(600, 500);
          frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT
          frm1.setResizable(false);
          frm1.pack();
          frm1.setVisible(false);    
          frm1.getRootPane().setDefaultButton(btnSave);
          
          frm_MEM.add(Memberpane, BorderLayout.CENTER);
          frm_MEM.setLocation(500, 100);
          frm_MEM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // EDIT
          frm_MEM.setResizable(false);
          frm_MEM.pack();
          frm_MEM.setVisible(false);
          
        /*  pack();
          add(welcomePane);
          */
          //Login window
          btnSubmit.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){

              try {  
            	  boolean fileFlag;
            	  File selectedFile = new File("DB_File.txt");
            	  btnSubmit = (JButton)e.getSource();	
            	 
            	  if(btnSubmit.getText().equals("Submit")) {
            		  
            	      fileName_Members = selectedFile.getAbsolutePath();
            	      if(passWord.getText().equals("Thk4All") && selectedFile.exists() && !selectedFile.isDirectory()) { 
            	    	 try{
            	    		 BufferedReader br = new BufferedReader(new FileReader(selectedFile));
            	    		 String st;
            	    		 int i =0;
            	    		
            	    		  while ((st = br.readLine()) != null)
            	    		  {
            	    			  oto_mom[i] =st; System.out.println(st);
            	    		    System.out.println(i);
            	    		    i++;
            	    		  }
            	    		   fileName_Members =  oto_mom[0];
            	    		  fileName_Activity = oto_mom[1];
            	    		  System.out.println("File1::::"+fileName_Members+"   File2:::"+fileName_Activity);
            	    		  frm_login.dispose();
                    		  frm.setVisible(true);
                    		  frm1.setVisible(false);
                    		  frm_MEM.setVisible(false);
            	    	}catch(IOException e1){}
            	    	}
            	      else if(passWord.getText().equals("Thk4All")){
            	    	  	panFilelocation.setVisible(true);
              				btnSubmit.setText("OK");  
              				
            	      }
            	      else {
            	    	  passWord.setText("");
            	    	  JOptionPane.showMessageDialog(frm_login, "Please Give the right password");
            	      }
            	      
            	      
            	     
            	  }else if(btnSubmit.getText().equals("OK")) {
            		  writeXLSFile(txtFileMem.getText(),txtFileTask.getText(),selectedFile);
            		  frm_login.dispose();
            		  frm.setVisible(true);
            		  frm1.setVisible(false);
            		  frm_MEM.setVisible(false);
            	  }
          		
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
              }//end of try catch
            }});//End of btnNewEmp ActionListener
          
          btnFileChooser_1.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){

              try {  

            	  btnFileChooser_1 = (JButton)e.getSource();	
            	   	 
            	  JFileChooser fileChooser = new JFileChooser();
            	  fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            	  int result = fileChooser.showSaveDialog(btnSave);
            	  if (result == JFileChooser.APPROVE_OPTION) {
            	      File selectedFile = fileChooser.getSelectedFile();
            	      if(selectedFile.exists() && !selectedFile.isDirectory()) { 
            	    	  JOptionPane.showMessageDialog(frm_login, selectedFile.getName()+" Already exists");
            	    	  fileName_Members = selectedFile.getAbsolutePath();
            	    	  txtFileMem.setText(fileName_Members);
            	    	}
            	      else {
            	    	  JOptionPane.showMessageDialog(frm_login, "you have selected new DB "+selectedFile.getAbsolutePath());
            	    	  fileName_Members = selectedFile.getAbsolutePath();
            	    	  txtFileMem.setText(fileName_Members);
            	      } //end of else
            	  }//end of first if
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
              }//end of try catch
            }});//End of btnFileChooser_1 ActionListener
          btnFileChooser_2.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){

              try {  

            	  btnFileChooser_2 = (JButton)e.getSource();	
            	  JFileChooser fileChooser = new JFileChooser();
            	  fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            	  int result = fileChooser.showSaveDialog(btnSave);
            	  if (result == JFileChooser.APPROVE_OPTION) {
            	      File selectedFile = fileChooser.getSelectedFile();
            	      if(selectedFile.exists() && !selectedFile.isDirectory()) { 
            	    	  JOptionPane.showMessageDialog(frm_login, selectedFile.getName()+" Already exists");
            	    	  fileName_Activity = selectedFile.getAbsolutePath();
            	    	  txtFileTask.setText(fileName_Activity);
            	    	}
            	      else {
            	    	  JOptionPane.showMessageDialog(frm_login, "you have selected new DB "+selectedFile.getAbsolutePath());
            	    	  fileName_Activity = selectedFile.getAbsolutePath();
            	    	  txtFileTask.setText(fileName_Activity);
            	      } //end of else
            	  }//end of first if
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
              }//end of try catch
            }});//End of btnFileChooser_2 ActionListener
          
          //opens registration window
          btnNewEmp.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){

              try {  

            	  btnNewEmp = (JButton)e.getSource();		
            	  frm.dispose();	
            	  
            	  frm1.setVisible(true);
            	  
          		System.out.println("Registration done");
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
              }//end of try catch
            }});//End of btnNewEmp ActionListener
          
          btnSave.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){

              try {  

            	  btnSave = (JButton)e.getSource();
            	  String name,vft,exp;
            	  String fileName;
            	  boolean fileFlag;
            	  name = txtEmpName.getText();
            	  vft = txtVft.getText();
            	  exp = txtExp.getText();
            	  txtEmpName.setText("");
            	  txtVft.setText("");
            	  txtExp.setText("");
            	  
            	      File selectedFile = new File(fileName_Members);
            	      fileName_Members = selectedFile.getAbsolutePath();
            	      if(selectedFile.exists() && !selectedFile.isDirectory()) { 
            	    	  fileFlag = true;
            	    	}
            	      else {
            	    	  fileFlag = false;
            	      }
            	      System.out.println("Selected file: " + selectedFile.getAbsolutePath()+"exists::"+fileFlag);
            	     
            	      writeXLSFile(fileName_Members,name,vft,exp,fileFlag);
            	 
          		System.out.println("File saved");
          		JOptionPane.showMessageDialog(frm1,"Member added successfully!");
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
            }
          }});//End of btnSave ActionListener
          btnCancel.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){

              try {  

            	  btnCancel = (JButton)e.getSource();		
            	  frm1.dispose();	
            	  
            	  frm.setVisible(true);
          		System.out.println("Cancel");
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
            }
          }});//End of btnCancel ActionListener
         
          
          btnExit.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){

              try {  

            	  btnExit = (JButton)e.getSource();		
            	  frm1.dispose();	            	  
            	  frm.dispose();
          		System.out.println("Exited");
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
            }
          }});//End of btnExit ActionListener
          btnAdd.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){

              try {  
            	  picker.setDate(Calendar.getInstance().getTime());
            	 
            	  Font myFont = new Font("Times New Roman",Font.BOLD,12);
            	  download.setVisible(false);
            	  txtDetails.setFont(myFont);
            	  txtDetails.setText("");
            	  txtOno.setFont(myFont);
            	  txtOno.setText("");
            	  btnAdd = (JButton)e.getSource();		
            	  btnExSave.setVisible(true);
                  btnExCancel.setVisible(true);
                  txtDetails.setEditable(true);
                  txtOno.setEditable(true);
            	  
            	  
          		System.out.println("Add");
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
            }
          }});//End of btnAdd ActionListener
          download.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){

              try {  
            	  picker.setDate(Calendar.getInstance().getTime());
            	 
            	  Font myFont = new Font("Times New Roman",Font.BOLD,12);
            	  btnExSave.setVisible(false);
                  btnExCancel.setVisible(true);
                  String fileName = comboName.getSelectedItem().toString()+"_"+comboTask.getSelectedItem().toString()+"_"+formatter.format(picker.getDate())+".pdf";
                  System.out.println("**********************"+fileName);
                  File location = new File(fileName);
                  writePDFFile(fileName,comboName.getSelectedItem().toString(),comboTask.getSelectedItem().toString(),formatter.format(picker.getDate()),txtOno.getText(),txtDetails.getText());
                  
                  JOptionPane.showMessageDialog(download, "File Downloaded in "+location.getAbsolutePath());
            	  
          		System.out.println("Add");
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
            }
          }});//End of btnAdd ActionListener
          btnReview.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){

              try {  

            	  btnReview = (JButton)e.getSource();            	 
            	  btnExSave.setVisible(false);
                  btnExCancel.setVisible(true);
                  download.setVisible(true);
                  txtDetails.setEditable(false);
                  txtOno.setEditable(false); 
                  txtDetails.setText("No Activities");
                  txtOno.setEditable(false);  
                  txtOno.setText("No Activities");
                  JOptionPane.showMessageDialog(frm_MEM,"Please select the date!");
                  
                  System.out.println("btnReview");
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
            }
          }});//End of btnReview ActionListener
          picker.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){
            	  btnExSave.setVisible(false);
                  btnExCancel.setVisible(true);
                  download.setVisible(true);            	  
              try {  
            	  Font myFont = new Font("Times New Roman",Font.BOLD,12);
            	String[] o2o_mom =  readXLSFile_1(fileName_Activity,picker.getDate(),comboName.getSelectedItem().toString(),comboTask.getSelectedItem().toString());
            	 if (o2o_mom == null) {
            		 txtDetails.setText("No value found");
                 	txtOno.setText("No value found");
            	 }else {
            		 txtDetails.setFont(myFont);
            	txtDetails.setText(o2o_mom[0]);
            	txtOno.setFont(myFont);
            	txtOno.setText(o2o_mom[1]);
            	 }
                 
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
            }
          }});//End of btnReview ActionListener
         
          btnExistEmp.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){
              try {  
            	  
            	  btnExistEmp = (JButton)e.getSource();		
            	  frm.dispose();	            	  
            	  frm_MEM.setVisible(true);
            	  readXLSFile(fileName_Members);
            	  comboName.setModel(new DefaultComboBoxModel(empName.toArray()));
            	 Date date = picker.getDate();
            	 
            	 
            	 System.out.println("Date today is::::::::"+date.toString());
            	  System.out.println("Existing user");
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
            }
          }});//End of btnCancel ActionListener
          btnExCancel.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){

              try {  

            	  btnExCancel = (JButton)e.getSource();
            	  frm.setVisible(true);
            	  frm_MEM.dispose();
            	 
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
            }
          }});//End of btnSave ActionListener
          btnExSave.addActionListener(new ActionListener(){

              public void actionPerformed(ActionEvent e){

              try {  

            	  btnExSave = (JButton)e.getSource();
            	  String name,task,oto,mom;
            	  Date date;
            	 
            	  boolean fileFlag;
            	  name = comboName.getSelectedItem().toString();
            	  task = comboTask.getSelectedItem().toString();
            	  date = picker.getDate();
            	  oto = txtDetails.getText();
            	  System.out.println("oto:  "+oto);
            	  mom = txtOno.getText();
            	  System.out.println("mom:   "+mom);
            	  
            	  txtDetails.setText("");
            	  txtOno.setText("");
            	 
            	      File selectedFile = new File(fileName_Activity);
            	      if(selectedFile.exists() && !selectedFile.isDirectory()) { 
            	    	  fileFlag = true;
            	    	}
            	      else {
            	    	  fileFlag = false;
            	      }             	      
            	      writeXLSFile_1(fileName_Activity,name,task,oto,mom,date,fileFlag);
            	      JOptionPane.showMessageDialog(frm_MEM, "Message Saved");
            	 
              }catch (Exception ioe1){
            	  System.out.println(ioe1.getMessage());
            }
          }});//End of btnSave ActionListener
        
    }//End of TeamActivityTracker constructor
    public static void writePDFFile(String fileName,String name,String task,String date,String oto,String mom) throws FileNotFoundException{
    	
    	try {
    	Document document = new Document(PageSize.A4, 50, 50, 50, 50);
    	PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
    			 
    			document.open();
    			Anchor anchorTarget = new Anchor("Report",FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD,new CMYKColor(255, 255, 255,17)));
    		      anchorTarget.setName("Simple Report");
    		      Paragraph paragraph1 = new Paragraph();
    		 
    		      paragraph1.setSpacingBefore(300);
    		 
    		      paragraph1.add(anchorTarget);
    		      document.add(paragraph1);
    		      
    		      Paragraph pdfName_title = new Paragraph("Name:\t",FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD,new CMYKColor(0, 255, 255,17)));
    		      Paragraph pdfName = new Paragraph(name,FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD,new CMYKColor(255, 255, 255,17)));
    		      Paragraph pdfTask_title = new Paragraph("Task:\t",FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD,new CMYKColor(0, 255, 255,17)));
    		      Paragraph pdfTask = new Paragraph(task,FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD,new CMYKColor(255, 255, 255,17)));
    		      Paragraph pdfDate_title = new Paragraph("Date:\t",FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD,new CMYKColor(0, 255, 255,17)));
    		      Paragraph pdfDate = new Paragraph(date,FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD,new CMYKColor(255, 255, 255,17)));
    		      Paragraph pdfOto = new Paragraph("One-to-One:",FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD,new CMYKColor(0, 255, 255,17)));
    		      Paragraph pdfOto_para = new Paragraph(oto,FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD,new CMYKColor(255, 255, 255,17))); 
    		      Paragraph pdfmom = new Paragraph("MOM:",FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD,new CMYKColor(0, 255, 255,17)));
    		      Paragraph pdfmom_para = new Paragraph(mom,FontFactory.getFont(FontFactory.HELVETICA, 11, Font.BOLD,new CMYKColor(255, 255, 255,17)));
    		document.add(pdfName_title);
    		document.add(pdfName);
    		document.add(pdfTask_title);
    		document.add(pdfTask);
    		document.add(pdfDate_title);
    		document.add(pdfDate);
    		document.add(pdfOto);
    		document.add(pdfOto_para);
    		document.add(pdfmom);
    		document.add(pdfmom_para);
    		document.close();
    	}catch(DocumentException doce){}
    	
    }
    public static  ArrayList<String> readXLSFile(String fileName) throws IOException
	{
    	
		InputStream ExcelFileToRead = new FileInputStream(fileName);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet sheet=wb.getSheetAt(0);
		int r = sheet.getFirstRowNum();
		System.out.print("row value"+r);
		HSSFRow row; 
		HSSFCell cell;
		
		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(HSSFRow) rows.next();
			cell =row.getCell(1);
			empName.add(cell.getStringCellValue());
			/*Iterator cells = row.cellIterator();
			
			while (cells.hasNext())
			{
				cell=(HSSFCell) cells.equals(obj).next();
		
				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
				{
					System.out.print(cell.getNumericCellValue()+" ");
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}*/
			
			System.out.print(cell.getStringCellValue()+" ");
		}
	return empName;
	}
    public static String[] readXLSFile_1(String fileName,Date date,String name,String task) throws IOException
	{
    	
    	
    	
        String today = formatter.format(date);
        String selected_day = formatter.format(date);       
		InputStream ExcelFileToRead = new FileInputStream(fileName);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet sheet=wb.getSheetAt(0);
		int r = sheet.getFirstRowNum();		
		HSSFRow row; 
		HSSFCell cell_name;
		HSSFCell cell_task;
		HSSFCell cell_date;
		HSSFCell cell_oto;
		HSSFCell cell_mom;
		
		Iterator rows = sheet.rowIterator();
		

		while (rows.hasNext())
		{
			row=(HSSFRow) rows.next();
			cell_name = row.getCell(1);
			cell_task = row.getCell(2);
			cell_date = row.getCell(3);			
			selected_day=formatter.format(cell_date.getDateCellValue());			
			
			if(cell_name.toString().equals(name)&&cell_task.toString().equals(task)&&selected_day.equals(today)) {
				
			cell_oto =row.getCell(4);
			oto_mom[0] = cell_oto.getStringCellValue();			
			cell_mom =row.getCell(5);
			oto_mom[1] = cell_mom.getStringCellValue();
			break;
		
			}
			else {
				oto_mom[0] = null;
				oto_mom[1] = null;
			}
			/*Iterator cells = row.cellIterator();
			
			while (cells.hasNext())
			{
				cell=(HSSFCell) cells.equals(obj).next();
		
				if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC)
				{
					System.out.print(cell.getNumericCellValue()+" ");
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}*/
			
			System.out.print("Selected day::-------------- "+selected_day+"\n");
		}//End of while loop
	return oto_mom;
	}
    
    public static void writeXLSFile(String fileMem, String filetask,File db){
    	
    	try {
    		BufferedWriter br = new BufferedWriter(new FileWriter(db));
    		br.write(fileMem);
    		br.newLine();
    		br.write(filetask);
    		br.close();    		
    	}catch(IOException e3) {
    		
    	}
    }
public static void writeXLSFile(String fileName,String Name,String vft,String exp,boolean flag) throws IOException {
		int r;
		String excelFileName = fileName;//name of excel file

		String sheetName = "TeamMembers";//name of sheet
		System.out.println("flag value"+flag);
		if(flag) {
			InputStream ExcelFileToRead = new FileInputStream(fileName);
			HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
			HSSFSheet sheet=wb.getSheetAt(0);
			r = sheet.getLastRowNum();
			HSSFRow row_1 = sheet.createRow(++r);
			HSSFCell row_1cell_1 = row_1.createCell(1);
			row_1cell_1.setCellValue(Name);
			HSSFCell row_1cell_2 = row_1.createCell(2);
			row_1cell_2.setCellValue(vft);
			HSSFCell row_1cell_3 = row_1.createCell(3);
			row_1cell_3.setCellValue(exp);
			FileOutputStream fileOut = new FileOutputStream(excelFileName);
			
			//write this workbook to an Outputstream.
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
			System.out.println("number of rows"+r);
		}else{
			r = 0;
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet sheet = wb.createSheet(sheetName) ;
			HSSFRow row_1 = sheet.createRow(r);
			HSSFCell row_1cell_1 = row_1.createCell(1);
			row_1cell_1.setCellValue(Name);
			HSSFCell row_1cell_2 = row_1.createCell(2);
			row_1cell_2.setCellValue(vft);
			HSSFCell row_1cell_3 = row_1.createCell(3);
			row_1cell_3.setCellValue(exp);
			FileOutputStream fileOut = new FileOutputStream(excelFileName);
			
			//write this workbook to an Outputstream.
			wb.write(fileOut);
			fileOut.flush();
			fileOut.close();
		}
		System.out.println("number of rows outside"+r);		
		
		/*HSSFRow row = sheet.createRow(r);
		HSSFCell cell_1 = row.createCell(1);
		cell_1.setCellValue("Name");
		HSSFCell cell_2 = row.createCell(2);
		cell_2.setCellValue("Vft");
		HSSFCell cell_3 = row.createCell(3);
		cell_3.setCellValue("Experience");
		r++;*/	

		/*//iterating r number of rows
		for (int r=0;r < 5; r++ )
		{
			HSSFRow row = sheet.createRow(r);
	
			//iterating c number of columns
			for (int c=0;c < 5; c++ )
			{
				HSSFCell cell = row.createCell(c);
				
				cell.setCellValue("Cell "+r+" "+c);
			}
		}*/
		
		
		
	}//End of writeXLSFile

public static void writeXLSFile_1(String fileName,String Name,String task,String oto,String mom,Date date,boolean flag) throws IOException {
	int r;
	String excelFileName = fileName;//name of excel file

	String sheetName = "TeamActivity";//name of sheet
	System.out.println("flag value"+flag);
	if(flag) {
		InputStream ExcelFileToRead = new FileInputStream(fileName);
		HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
		HSSFSheet sheet=wb.getSheetAt(0);
		r = sheet.getLastRowNum();
		HSSFRow row_1 = sheet.createRow(++r);
		HSSFCell row_1cell_1 = row_1.createCell(1);
		row_1cell_1.setCellValue(Name);
		HSSFCell row_1cell_2 = row_1.createCell(2);
		row_1cell_2.setCellValue(task);
		
		CellStyle cellStyle = wb.createCellStyle();
		CreationHelper createHelper = wb.getCreationHelper();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd.MM.yyyy"));
		HSSFCell row_1cell_3 = row_1.createCell(3);
		row_1cell_3.setCellValue(new Date());
		row_1cell_3.setCellStyle(cellStyle);
		
		HSSFCell row_1cell_4 = row_1.createCell(4);
		row_1cell_4.setCellValue(oto);
		HSSFCell row_1cell_5 = row_1.createCell(5);
		row_1cell_5.setCellValue(mom);
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		
		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
		System.out.println("number of rows"+r);
	}else{
		r = 0;
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName) ;
		HSSFRow row_1 = sheet.createRow(r);
		HSSFCell row_1cell_1 = row_1.createCell(1);
		row_1cell_1.setCellValue(Name);
		HSSFCell row_1cell_2 = row_1.createCell(2);
		row_1cell_2.setCellValue(task);
		
		CellStyle cellStyle = wb.createCellStyle();
		CreationHelper createHelper = wb.getCreationHelper();
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd.MM.yyyy"));
		HSSFCell row_1cell_3 = row_1.createCell(3);
		row_1cell_3.setCellValue(new Date());
		row_1cell_3.setCellStyle(cellStyle);
		
		
		HSSFCell row_1cell_4 = row_1.createCell(4);
		row_1cell_4.setCellValue(oto);
		HSSFCell row_1cell_5 = row_1.createCell(5);
		row_1cell_5.setCellValue(mom);
		FileOutputStream fileOut = new FileOutputStream(excelFileName);
		
		//write this workbook to an Outputstream.
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	System.out.println("number of rows outside"+r);		
	
	/*HSSFRow row = sheet.createRow(r);
	HSSFCell cell_1 = row.createCell(1);
	cell_1.setCellValue("Name");
	HSSFCell cell_2 = row.createCell(2);
	cell_2.setCellValue("Vft");
	HSSFCell cell_3 = row.createCell(3);
	cell_3.setCellValue("Experience");
	r++;*/	

	/*//iterating r number of rows
	for (int r=0;r < 5; r++ )
	{
		HSSFRow row = sheet.createRow(r);

		//iterating c number of columns
		for (int c=0;c < 5; c++ )
		{
			HSSFCell cell = row.createCell(c);
			
			cell.setCellValue("Cell "+r+" "+c);
		}
	}*/
	
	
	
}//End of writeXLSFile

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}//End of TeamAvtivityTracker constructor
	
	public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()

        {  
            @Override
            public void run(){
            try {
					new TeamActivityTracker().setVisible(true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

        });

    }


}//End of class
