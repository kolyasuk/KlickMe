package iful.edu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import iful.edu.util.MousePositionHandler;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private int difficaltyLevel=5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setMinimumSize(new Dimension(350, 350));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("KlickMe!");
		setBounds(100, 100, 629, 510);
		setLocationRelativeTo(null);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenu mnDifficulty = new JMenu("Difficulty");
		mnSettings.add(mnDifficulty);
		
		JMenuItem mntmEasy = new JMenuItem("Easy");
		mntmEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				difficaltyLevel=1;
			}
		});
		mnDifficulty.add(mntmEasy);
		
		JMenuItem mntmMedium = new JMenuItem("Medium");
		mntmMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficaltyLevel=5;
			}
		});
		mnDifficulty.add(mntmMedium);
		
		JMenuItem mntmHard = new JMenuItem("Hard");
		mntmHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficaltyLevel=10;
			}
		});
		mnDifficulty.add(mntmHard);
		
		JMenuItem mntmStopButtonMoving = new JMenuItem("Stop this shit!");
		mntmStopButtonMoving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficaltyLevel=-1;
			}
		});
		
		JSeparator separator = new JSeparator();
		mnDifficulty.add(separator);
		mnDifficulty.add(mntmStopButtonMoving);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		MousePositionHandler mph = new MousePositionHandler(btnExit);

		btnExit.setFocusable(false);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(270, 204, 64, 23);
		contentPane.add(btnExit);
		
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				mph.checkMousePosition(arg0, difficaltyLevel, contentPane);
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				mouseMoved(e);
			}
			
		});
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				int paneEndX = btnExit.getX()+btnExit.getWidth();
				int paneEndY = btnExit.getY()+btnExit.getHeight();
				if(paneEndX>contentPane.getWidth() || paneEndY>contentPane.getHeight()) {
					mph.randomButtonLocation(btnExit, contentPane);
				}
				
			}
		});
	}
}
