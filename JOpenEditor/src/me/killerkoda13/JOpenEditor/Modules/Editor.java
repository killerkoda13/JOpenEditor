package me.killerkoda13.JOpenEditor.Modules;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JEditorPane;

import Windows.main.MainWindow;

/***
 *		---------------------------------
 *		@Author Killerkoda13 (Alex Jones)
 *		@date May 18, 2016
 *		---------------------------------
 */

public class Editor extends JEditorPane{
	int lines = 0;
	JEditorPane pane = this;
	public Editor()
	{
		this.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				lines = pane.getText().split("\n").length;
			MainWindow.lblLines.setText("Lines: "+lines);
			}
		});
	}
}

