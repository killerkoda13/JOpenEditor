package me.killerkoda13.JOpenEditor.FileIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/***
 *		---------------------------------
 *		@Author Killerkoda13 (Alex Jones)
 *		@date May 18, 2016
 *		---------------------------------
 */
public class Save {


	public static void save(String contents, File file)
	{
		try {
			FileWriter writer = new FileWriter(file);
			if(file.exists())
			{
				if(file.canWrite())
				{
					writer.write(contents);
					writer.flush();
					writer.close();
				}
			}else
			{
				if(file.canWrite())
				{
					file.createNewFile();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

