package me.killerkoda13.JOpenEditor.Modules;

import me.killerkoda13.JOpenEditor.Windows.main.MainWindow;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/***
 *		---------------------------------
 *		@Author Killerkoda13 (Alex Jones)
 *		@date May 19, 2016
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
	
	public void setText(String text)
	{
		setText(text);
	}
}

