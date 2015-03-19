package Foundation;

import java.io.Serializable;
import java.util.ArrayList;

import ProblemDomain.bookedRoom;

public class CbookList implements Serializable{
	private ArrayList<bookedRoom> booklist;
	
	public CbookList() {
		booklist = new ArrayList<bookedRoom>();
	}

	public void addBook(bookedRoom a) {
		booklist.add(a);
	}

	public bookedRoom getBook(int i) {
		return booklist.get(i);
	}

	public void setBook(int i, bookedRoom a){
		booklist.set(i, a);
	}
	
	public int size() {
		return booklist.size();
	}

	public void deleteBook(int i) {
		booklist.remove(i);
	}
	
	public int getSize()
	{
		return booklist.size();
	}
	
}
