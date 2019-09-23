package lesson9.labs.prob1.dataaccess;

import lesson9.labs.prob1.business.Book;
import lesson9.labs.prob1.business.LibraryMember;

import java.util.HashMap;

public interface DataAccess { 
	public HashMap<String, Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
}
