import java.util.ArrayList;

public class DrieOpEenRij extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	ArrayList<String> row1 = new ArrayList<String>();
	ArrayList<String> row2 = new ArrayList<String>();
	ArrayList<String> row3 = new ArrayList<String>();
	ArrayList<String> row4 = new ArrayList<String>();
	ArrayList<String> row5 = new ArrayList<String>();
	ArrayList<String> row6 = new ArrayList<String>();
	public boolean serving;
	public boolean player;

	public DrieOpEenRij() {
		initComponents();
		fillLists();
		String html = "<html>\n"
				+ "<head>\n"
				+ "<style type=\"text/css\">\n"
				+ "table {\n"
				+ "width: 100%\n"
				+ "}\n"
				+ "td, th {\n"
				+ "height:35px; width:42px; text-align:center; background-color: #FFFFFFF;"
				+ "\n" + "}\n" + "</style>\n" + "</head>\n" + "<body>\n"
				+ "<div style=\"background-color: black\">\n"
				+ "<table border=\"1\" cellpadding=\"10\" cellspacing=\"1\">\n"
				+ getString(row1) + getString(row2) + getString(row3)
				+ getString(row4) + getString(row5) + getString(row6)
				+ "</div>\n" + "</body>\n" + "</html>";
		jLabel4.setText(html);
		this.MessageSystem("Speler 1 is aan de beurt!", "blue");
	}

	public void fillLists() {
		if (row1.isEmpty()) {
			fillrows(row1);
			fillrows(row2);
			fillrows(row3);
			fillrows(row4);
			fillrows(row5);
			fillrows(row6);
		}
	}

	public void fillrows(ArrayList<String> list) {
		list.add("<td></td>");
		list.add("<td></td>");
		list.add("<td></td>");
		list.add("<td></td>");
		list.add("<td></td>");
		list.add("<td></td>");
		list.add("<td></td>");
	}

	public String getString(ArrayList<String> list) {
		String a = "<tr>" + list + "</tr>";
		a = a.replace("[", "");
		a = a.replace("]", "");
		a = a.replace(",", "");
		a = a.replace("☺", "<font color=red size=5>☺</font> ");
		a = a.replace("☻", "<font color=blue size=5>☻</font> ");
		return a;

	}

	public void refreshPage() {
		String html = "<html>\n"
				+ "<head>\n"
				+ "<style type=\"text/css\">\n"
				+ "table {\n"
				+ "width: 100%\n"
				+ "}\n"
				+ "td, th {\n"
				+ "height:35px; width:42px; text-align:center; background-color: #FFFFFFF;"
				+ "\n" + "}\n" + "</style>\n" + "</head>\n" + "<body>\n"
				+ "<div style=\"background-color: black\">\n"
				+ "<table border=\"1\" cellpadding=\"10\" cellspacing=\"1\">\n"
				+ getString(row1) + getString(row2) + getString(row3)
				+ getString(row4) + getString(row5) + getString(row6)
				+ "</div>\n" + "</body>\n" + "</html>";
		jLabel4.setText(html);
	}

	public void setFiche(int init, ArrayList<String> list, int listnum) {
		String i;
		if (player){i = "☺"; }else{i = "☻";}
		list.set(init, "<td>"+i+"</td>");
		this.hold(init, listnum);
		this.refreshPage();
	}
	
	public void removeFiche(int init, ArrayList<String> list) {
		list.set(init, "<td></td>");
		this.refreshPage();
	}

	public void hold(final int rownum,final int listnum) {
		new Thread() {
			public void run() {
				try {
					Thread.sleep(250);
					if (listnum == 1 && row2.get(rownum).equals("<td></td>")){
						removeFiche(rownum,row1);
						setFiche(rownum, row2, 2);
					}else
					if (listnum == 2 && row3.get(rownum).equals("<td></td>")){
						removeFiche(rownum,row2);
						setFiche(rownum, row3, 3);
					}else
					if (listnum == 3 && row4.get(rownum).equals("<td></td>")){
						removeFiche(rownum,row3);
						setFiche(rownum, row4, 4);
					}else
					if (listnum == 4 && row5.get(rownum).equals("<td></td>")){
						removeFiche(rownum,row4);
						setFiche(rownum, row5, 5);
					}else
					if (listnum == 5 && row6.get(rownum).equals("<td></td>")){
						removeFiche(rownum,row5);
						setFiche(rownum, row6, 6);
					}else{
						if (!row1.get(rownum).equals("<td></td>")){
					       disableButton(rownum+1);
						}
						if (player){player = false; MessageSystem("Speler 1 is aan de beurt!","blue");}else{player = true;MessageSystem("Speler 2 is aan de beurt!","red");}
						serving = false;
					}
					return;
				} catch (InterruptedException e) {
				}
			}
		}.start();
	}
	
	public void disableButton(int rownum){
		if (rownum == 1){jButton1.setEnabled(false);}
		if (rownum == 2){jButton2.setEnabled(false);}
		if (rownum == 3){jButton3.setEnabled(false);}
		if (rownum == 4){jButton4.setEnabled(false);}
		if (rownum == 5){jButton5.setEnabled(false);}
		if (rownum == 6){jButton6.setEnabled(false);}
		if (rownum == 7){jButton7.setEnabled(false);}
	}
	
	public void MessageSystem(String message, String color){
		String htm = "<html><font color="+color+">"+message+"</font></html>";
		jLabel3.setText(htm);
	}

	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jButton1.setText("1");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("2");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton3.setText("3");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jButton4.setText("4");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		jButton5.setText("5");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton6.setText("6");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		jButton7.setText("7");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jLabel1.setText("jLabel1");

		jLabel2.setText("jLabel2");

		jLabel3.setText("jLabel3");

		jLabel4.setText("");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(
														jLabel4,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jLabel1)
																.addGap(85,
																		85,
																		85)
																.addComponent(
																		jLabel3)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)
																.addComponent(
																		jLabel2))
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jButton1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		50,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		50,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton3,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		50,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton4,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		50,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton5,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		50,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton6,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		50,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(
																		jButton7,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		50,
																		javax.swing.GroupLayout.PREFERRED_SIZE)
																.addGap(0,
																		0,
																		Short.MAX_VALUE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2)
												.addComponent(jButton3)
												.addComponent(jButton4)
												.addComponent(jButton5)
												.addComponent(jButton6)
												.addComponent(jButton7))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel4,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										290,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(20, 20, 20)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1)
												.addComponent(jLabel2)
												.addComponent(jLabel3))));

		pack();
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (!serving){
		serving = true;
		this.setFiche(0,row1,1);
		}
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		if (!serving){
		serving = true;
		this.setFiche(1,row1,1);
		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		if (!serving){
		serving = true;
		this.setFiche(2,row1,1);
		}
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		if (!serving){
		serving = true;
		this.setFiche(3,row1,1);
		}
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		if (!serving){
		serving = true;
		this.setFiche(4,row1,1);
		}
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		if (!serving){
		serving = true;
		this.setFiche(5,row1,1);
		}
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		if (!serving){
		serving = true;
		this.setFiche(6,row1,1);
		}
	}

	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(DrieOpEenRij.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DrieOpEenRij.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DrieOpEenRij.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DrieOpEenRij.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DrieOpEenRij().setVisible(true);
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
}