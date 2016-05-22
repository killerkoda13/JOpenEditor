package me.killerkoda13.JOpenEditor.FileIO;

import me.killerkoda13.JOpenEditor.Windows.main.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.io.*;

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

