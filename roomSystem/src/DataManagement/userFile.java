package DataManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;

import Foundation.roomList;
import Foundation.userList;

public class userFile implements Serializable {
	File file;
	FileInputStream input;
	FileOutputStream output;
	
	public userFile()
	{
		file = new File("./src/userFileData.dat");
	}

	public void fileSave(userList list)
	{
		try 
		{
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(list);
			out.close();
			//System.out.println("�������� ���������� ����Ǿ����ϴ�.");	
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public userList fileRead()
	{
		try 
		{
		
			ObjectInputStream fileRead=new ObjectInputStream(new FileInputStream(file));
			userList man = (userList) fileRead.readObject();
			//System.out.println("�������� ���������� �ε�Ǿ����ϴ�.");
			fileRead.close();
			return man;
		} 
		catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
