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

import Foundation.*;
import ProblemDomain.conferenceRoom;



public class roomFile implements Serializable {
	File file;
	FileInputStream input;
	FileOutputStream output;
	
	public roomFile()
	{
		file = new File("./src/roomFileData.dat");
	}

	public void fileSave(roomList list)
	{
		try 
		{
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(list);
			out.close();
			//System.out.println("룸파일이 성공적으로 저장되었습니다.");	
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public roomList fileRead()
	{
		try 
		{
			ObjectInputStream fileRead=new ObjectInputStream(new FileInputStream(file));
			roomList man = (roomList) fileRead.readObject();
			//System.out.println("룸파일을 성공적으로 로드되었습니다.");
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
