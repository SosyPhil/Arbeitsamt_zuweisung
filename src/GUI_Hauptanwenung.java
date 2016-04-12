import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTree;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import java.awt.Font;

import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;

import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButton;

import java.util.Vector;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class GUI_Hauptanwenung extends JFrame {

	
	private JPanel contentPane;
	private JTable table_01;
	Object arr_database[][] = null;
	private JTable table_angebote;
	/**
	 * Launch the application.
	 */
	boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, false
			};
	Object[][] all_names;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Hauptanwenung frame = new GUI_Hauptanwenung();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_Hauptanwenung() {
		
		//Integer 
			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 665);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmSpeichern = new JMenuItem("Speichern");
		mnDatei.add(mntmSpeichern);
		
		JMenuItem mntmffnen = new JMenuItem("\u00D6ffnen");
		mnDatei.add(mntmffnen);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSpinner spinner_schueler = new JSpinner();
		spinner_schueler.setModel(new SpinnerNumberModel(10, 10, 300, 1));
		
		JSpinner spinner_angebote = new JSpinner();
		spinner_angebote.setModel(new SpinnerNumberModel(new Integer(6), new Integer(2), null, new Integer(1)));
		
		JSpinner spinner_block = new JSpinner();
		spinner_block.setModel(new SpinnerNumberModel(4, 1, 5, 1));
		
		
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int int_rowc,int_spin,int_div;
				
				DefaultTableModel model=(DefaultTableModel) table_01.getModel();      //GET Table | Namen
				
				//ADD/DELETE ROWS Namensliste ---------------------
				
				int_spin=(int) spinner_schueler.getValue();	
				int_rowc=model.getRowCount();
								
				if (int_spin!=int_rowc){
					
					int_div = int_spin-int_rowc;
					
					if(int_div>0){
						for(int i=1;i<=int_div;i++){
							model.addRow(new Object[]{});
							}
					}else if(int_div<0){					
						int_div=int_div *-1;
							for(int i=1;i<=int_div;i++){
								int r = model.getRowCount()-1;
								model.removeRow(r);
								}
					}
				}
				
				//ADD/DELETE ROWS Angebote -------------
				
				DefaultTableModel model_angebote=(DefaultTableModel) table_angebote.getModel();
				int int_row_angebote,int_spin_angebote,int_div_angebote;
				
				int_spin_angebote=(int) spinner_angebote.getValue();
				int_row_angebote=model_angebote.getRowCount();
				
				if (int_spin_angebote!=int_row_angebote){
					int_div_angebote =int_spin_angebote - int_row_angebote;
					
					if(int_div_angebote>=0){
						for(int i=1;i<=int_div_angebote;i++){
								int betrag = model_angebote.getRowCount()+1;
								model_angebote.addRow(new Object[]{betrag, null, null, null, null, null, null});	
							}
					}else if(int_div_angebote<=0){
						int_div_angebote=int_div_angebote *-1;
						for(int i=1;i<=int_div_angebote;i++){
								int r_angebote = model_angebote.getRowCount()-1;
								model_angebote.removeRow(r_angebote);
						}}}	
				//ADD/DELETE COLUMS Block --------------
				
				int int_spin_column;
				
				int_spin_column=(int) spinner_block.getValue();
				System.out.println(int_spin_column);
				
				
				
				
				switch (int_spin_column) {
					case 1:  	columnEditables[7]=false;
								columnEditables[6]=false;
								columnEditables[5]=false;
								columnEditables[4]=false;
								columnEditables[3]=true;
								break;
					case 2:		columnEditables[7]=false;
								columnEditables[6]=false;
								columnEditables[5]=false;
								columnEditables[4]=true;
								columnEditables[3]=true;
								break;
					case 3:		columnEditables[7]=false;
								columnEditables[6]=false;
								columnEditables[5]=true;
								columnEditables[4]=true;
								columnEditables[3]=true;
								break;
					case 4:		columnEditables[7]=false;
								columnEditables[6]=true;
								columnEditables[5]=true;
								columnEditables[4]=true;
								columnEditables[3]=true;
								break;
					case 5:		columnEditables[7]=true;
								columnEditables[6]=true;
								columnEditables[5]=true;
								columnEditables[4]=true;
								columnEditables[3]=true;
								break;
						
				}
				
				
							
}}); 
		
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btn_go = new JButton("Create");
		btn_go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Create --------------------
				
				Error_check((int) spinner_angebote.getValue(),(int) spinner_block.getValue(),(int) spinner_schueler.getValue());         // übertragen der Anzahl an Angeboten
				 
				
				
				
				
				
				
				
				
				
				
				
				
					
				
			}
		});
		
		table_01 = new JTable();
		scrollPane.setViewportView(table_01);
		table_01.setSurrendersFocusOnKeystroke(true);
		table_01.setColumnSelectionAllowed(true);
		table_01.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_01.setForeground(Color.DARK_GRAY);
		table_01.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table_01.setModel(new DefaultTableModel(
			new Object[][]{
					/*{"a","A" ,1 ,2 ,3 ,4 },
					{"b","B" ,2 ,3 ,4 ,5 },
					{"c","C" ,3 ,4 ,5 ,6 },
					{"d","D" ,4 ,5 ,6 ,1 },
					{"e","E" ,5 ,6 ,1 ,2 },
					{"f","F" ,6 ,1 ,2 ,3 },
					{"g","G" ,1 ,2 ,3 ,4 },
					{"h","H" ,2 ,3 ,4 ,5 },
					{"i","I" ,3 ,4 ,5 ,6 },
					{"j","J" ,4 ,5 ,6 ,1 },*/
			  {null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Vorname", "Nachname", "1. Wahl", "2. Wahl", "3. Wahl", "4. Wahl"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_01.getColumnModel().getColumn(0).setResizable(false);
		table_01.getColumnModel().getColumn(0).setPreferredWidth(85);
		table_01.getColumnModel().getColumn(1).setResizable(false);
		table_01.getColumnModel().getColumn(1).setPreferredWidth(83);
		table_01.getColumnModel().getColumn(2).setResizable(false);
		table_01.getColumnModel().getColumn(2).setPreferredWidth(47);
		table_01.getColumnModel().getColumn(3).setResizable(false);
		table_01.getColumnModel().getColumn(3).setPreferredWidth(49);
		table_01.getColumnModel().getColumn(4).setResizable(false);
		table_01.getColumnModel().getColumn(4).setPreferredWidth(48);
		table_01.getColumnModel().getColumn(5).setResizable(false);
		table_01.getColumnModel().getColumn(5).setPreferredWidth(47);
		table_01.setBackground(Color.WHITE);
		table_01.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		
		
		JLabel lblSchler = new JLabel("Sch\u00FCler");
		
		JLabel lblAngebote = new JLabel("Angebote");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
	
		
		JLabel lblBlcke = new JLabel("Bl\u00F6cke");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(btnRefresh, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(spinner_angebote, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_schueler, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSchler)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAngebote)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(spinner_block, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblBlcke))))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 481, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btn_go)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(spinner_schueler, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSchler))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAngebote)
								.addComponent(spinner_block, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_angebote, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBlcke))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addGap(170)
							.addComponent(btnRefresh))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(117)
					.addComponent(btn_go)
					.addGap(39))
		);
		
		table_angebote = new JTable();
		table_angebote.setModel(new DefaultTableModel(
			new Object[][] {
				/*{new Integer(1), null, null, null, null, null, null, null},
				{new Integer(2), null, null, null, null, null, null, null},
				{new Integer(3), null, null, null, null, null, null, null},
				{new Integer(4), null, null, null, null, null, null, null},
				{new Integer(5), null, null, null, null, null, null, null},
				{new Integer(6), null, null, null, null, null, null, null},*/
					{new Integer(1), 1, "eins", null, null, null, null, null},
					{new Integer(2), 2, "zwei", null, null, null, null, null},
					{new Integer(3), 3, "drei", null, null, null, null, null},
					{new Integer(4), 4, "vier", null, null, null, null, null},
					{new Integer(5), 5, "fuenf", null, null, null, null, null},
					{new Integer(6), 6, "sechs", null, null, null, null, null},
			},
			new String[] {
				"Nr.", "Pl\u00E4tze", "Name", "1", "2", "3", "4", "5"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			void columnEditables() {
			}
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table_angebote.getColumnModel().getColumn(0).setResizable(false);
		table_angebote.getColumnModel().getColumn(0).setPreferredWidth(27);
		table_angebote.getColumnModel().getColumn(1).setResizable(false);
		table_angebote.getColumnModel().getColumn(1).setPreferredWidth(42);
		table_angebote.getColumnModel().getColumn(2).setResizable(false);
		table_angebote.getColumnModel().getColumn(3).setResizable(false);
		table_angebote.getColumnModel().getColumn(3).setPreferredWidth(20);
		table_angebote.getColumnModel().getColumn(4).setResizable(false);
		table_angebote.getColumnModel().getColumn(4).setPreferredWidth(18);
		table_angebote.getColumnModel().getColumn(5).setResizable(false);
		table_angebote.getColumnModel().getColumn(5).setPreferredWidth(19);
		table_angebote.getColumnModel().getColumn(6).setResizable(false);
		table_angebote.getColumnModel().getColumn(6).setPreferredWidth(21);
		table_angebote.getColumnModel().getColumn(7).setResizable(false);
		table_angebote.getColumnModel().getColumn(7).setPreferredWidth(21);
		scrollPane_1.setViewportView(table_angebote);
		contentPane.setLayout(gl_contentPane);
	
	}
	public void Error_check(int spin_angebote,int spin_block, int spin_names){
		
		

			
			String message = "";
			
			DefaultTableModel model_angebote=(DefaultTableModel) table_angebote.getModel();
			DefaultTableModel model_names=(DefaultTableModel) table_01.getModel();
			
			
			
			
		//ANGEBOTE	----------------------------------
			
			
			for(int i=0;i<spin_angebote;i++){ 
				//Abfragen bei Angeboten
				if(model_angebote.getValueAt(i,1)==null){	
					message = message + "Bei Angebot " + (i+1) + " ist keine Anzahl der Plätze eingetragen!\n";
				}if(model_angebote.getValueAt(i, 2)==null){
					message = message + "Bei Angebot " + (i+1) + " ist kein Name eingetragen!\n";
				}if(model_angebote.getValueAt(i, 3)==null && model_angebote.getValueAt(i, 4)==null && model_angebote.getValueAt(i, 5)==null && model_angebote.getValueAt(i, 3)==null){
					message = message + "Bei Angebot " + (i+1) + " ist kein Block Ausgewählt!\n";
				}
				
				
			}
		
		// wenn spinner gedreht wird und nicht auf refresh dondern Create gedrückt wird ist integer von spinner und tatsächlicher anzahl nich 
		// da
			
		//NAMEN ------------------------------------
			
			for(int i=0;i<spin_names;i++){
				//Abfragen Namesliste
				if(model_names.getValueAt(i, 0)==null || model_names.getValueAt(i, 0)=="" || model_names.getValueAt(i, 1)==null || model_names.getValueAt(i, 1)==""){
					message = message + "Zeile " + (i+1) + ": Bitte Vor- und Nachnamen eingeben\n";
				
				}
			
			}
	//if(message==""){
		erstwahl(spin_angebote,spin_block,spin_names);
	//}else{
		JOptionPane.showMessageDialog(null, message,"ERROR!",  JOptionPane.INFORMATION_MESSAGE);
	//}
	}
	
	public void erstwahl(int spin_angebote,int spin_block, int spin_names){
		
		
		
		for(int i=0;i<spin_angebote;i++){
			
			
			System.out.println(table_angebote.getModel().getValueAt(i, 2));
			
		}
			
		
		
	}
	
		
}

