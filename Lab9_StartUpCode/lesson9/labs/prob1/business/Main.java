package lesson9.labs.prob1.business;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lesson9.labs.prob1.dataaccess.DataAccess;
import lesson9.labs.prob1.dataaccess.DataAccessFacade;

public class Main {
    final static BiFunction<DataAccess, String, List<String>> getFilteredMembers = (da, s) -> da.readMemberMap().values().stream()
            .filter(lm -> lm.getMemberId().contains(s))
            .map(lm -> lm.getMemberId())
            .collect(Collectors.toList());

	final static BiFunction<DataAccess, Predicate<Book>, Stream<Book>> filterBooks = (da, filter) -> da.readBooksMap().values().stream()
			.filter(book -> filter.test(book));

    final static BiFunction<DataAccess, Predicate<Book>, List<String>> getIsbn = (da, filter) ->
			filterBooks.apply(da, filter)
            .map(book -> book.getIsbn())
            .collect(Collectors.toList());

    final static BiPredicate<Book, Integer> filterByCopyAmount = (book, amount) -> book.getCopies().length > amount;
	final static BiPredicate<Book, Integer> filterByAuthorAmount = (book, amount) -> book.getAuthors().stream().count() > amount;

    public static void main(String[] args) {
        System.out.println(allWhoseZipContains3());
        System.out.println(allHavingAtLeastTwoCopies());
        System.out.println(allHavingMultipleAuthors());
    }

    //Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
    public static List<String> allWhoseZipContains3() {
        DataAccess da = new DataAccessFacade();
        return getFilteredMembers.apply(da, "3");
    }

    //Returns a list of all isbns of books having at least two copies
    public static List<String> allHavingAtLeastTwoCopies() {
        DataAccess da = new DataAccessFacade();
        return getIsbn.apply(da, (book) -> filterByCopyAmount.test(book, 2));
    }

    //Returns a list of all isbns of  Books that have multiple authors
    public static List<String> allHavingMultipleAuthors() {
		DataAccess da = new DataAccessFacade();
		return getIsbn.apply(da, (book) -> filterByAuthorAmount.test(book, 1));
    }

}
