package me.killerkoda13.JOpenEditor.FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import me.killerkoda13.JOpenEditor.Modules.Editor;

/***
 *		---------------------------------
 *		@Author Killerkoda13 (Alex Jones)
 *		@date May 20, 2016
 *		---------------------------------
 */
public class Reload {
	
	public static void reload(Editor editor, File file)
	{
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
		editor.setText(contents);
	}
}

