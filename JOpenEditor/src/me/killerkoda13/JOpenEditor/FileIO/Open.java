package me.killerkoda13.JOpenEditor.FileIO;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JEditorPane;

import me.killerkoda13.JOpenEditor.MainWindow;

/***
 *		---------------------------------
 *		@Author Killerkoda13 (Alex Jones)
 *		@date May 18, 2016
 *		---------------------------------
 */
public class Open {
	
	public static void open(File file)
	{
		JEditorPane editorPane = new JEditorPane();
		editorPane.setFont(new Font("Raleway Light", Font.PLAIN, 18));
		MainWindow.tabbedPane.addTab(file.getName(),editorPane);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		String contents = "";
		String str;
		try {
			while((str = reader.readLine()) != null)
			{
				contents += str+"\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		editorPane.setText(contents);
	}

}

