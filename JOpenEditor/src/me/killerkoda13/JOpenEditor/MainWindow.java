package me.killerkoda13.JOpenEditor;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JToolBar;

import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JTabbedPane;
import javax.swing.BoxLayout;

import me.killerkoda13.JOpenEditor.FileIO.Open;
import me.killerkoda13.JOpenEditor.FileIO.Save;
import me.killerkoda13.JOpenEditor.Modules.Editor;
import me.killerkoda13.JOpenEditor.Modules.JTabbedPaneCloseButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/***
 *		---------------------------------
 *		@Author Killerkoda13 (Alex Jones)
 *		@date May 18, 2016
 *		---------------------------------
 */
public class MainWindow extends JFrame {

	private JPanel contentPane;
	public static JTabbedPaneCloseButton tabbedPane;
	public static JFrame frame;
	public static JLabel lblLines;
	/**
	 * Launch the application.
	 */
	public static void display() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					SwingUtilities.updateComponentTreeUI(frame);
					MainWindow.frame = frame;
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 773);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog dialog = new FileDialog(frame, "Open file", FileDialog.LOAD);
				dialog.show();
				if(dialog.getDirectory() !=null && dialog.getFile() !=null)
				{
					Open.open(new File(dialog.getDirectory()+"/"+dialog.getFile()));
				}
				System.out.println("Initiate open file dialog.");
			}
		});
		
		mnFile.add(mntmOpen);
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editor editorPane = new Editor();
				editorPane.setFont(new Font("Raleway Light", Font.PLAIN, 18));
				MainWindow.tabbedPane.addTab("New file", editorPane);
				System.out.println("New file tab.");
			}
		});
		
		JMenuItem mntmSave = new JMenuItem("Save as");
		mnFile.add(mntmSave);
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog dialog = new FileDialog(frame, "Save file", FileDialog.SAVE);
				dialog.show();
				if(dialog.getDirectory() !=null && dialog.getFile() !=null)
				{
					JScrollPane pane = (JScrollPane) tabbedPane.getSelectedComponent();
					tabbedPane.setTitleAt(tabbedPane.getSelectedIndex(), dialog.getFile());
					File file = new File(dialog.getDirectory()+"/"+dialog.getFile());
					Editor jpane = (Editor) pane.getViewport().getComponents()[0];
					Save.save(jpane.getText(), file);
				}
				System.out.println("Save File action!");
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println(e);
				JScrollPane pane = (JScrollPane) tabbedPane.getSelectedComponent();
				Editor jedit = (Editor) pane.getViewport().getComponents()[0];
				lblLines.setText("Lines: "+jedit.getText().split("\n").length);
			}
		});
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		tabbedPane = new JTabbedPaneCloseButton(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		panel.add(tabbedPane);

		Editor editorPane = new Editor();

		JScrollPane scroll = new JScrollPane(editorPane);
		tabbedPane.addTab("New file", null, scroll, null);
		editorPane.setFont(new Font("Raleway Light", Font.PLAIN, 18));
		contentPane.add(panel);

		lblLines = new JLabel("Lines: ");
		contentPane.add(lblLines, BorderLayout.SOUTH);
	}
}

