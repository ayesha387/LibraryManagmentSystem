/*
import com.example.LMS.entity.Book
import com.example.LMS.model.BookDto
import com.example.LMS.repository.BookRepo
*/
/*import com.project.carworkshop.entity.Make
import com.project.carworkshop.model.MakeModel*//*

import com.project.carworkshop.repository.MakeRepository
import spock.lang.Specification

class BookServiceImplSpec extends Specification
{
    def bookRepo = Mock(BookRepo.class)
    def bookService = new BookServiceImpl(bookRepo)

  def "verify getBook() returns list of BookMode for bookId"()
  {
      given:
      def book = new Book(id: 1L,bookName: "Frictions")
      bookRepo.findBookById(_) >> book
      when:
      def response = bookService.getBook(22)

      then:
      response != null
      response.get(0).bookId == book.getId()
      response.get(0).getBookName() == book.getBookName()
  }

    def "verify getBook() returns null for bookId"()
    {
        given:
        def book = new Book(id: 1L,bookName: "Electricity")
        bookRepo.findBookById(_) >> null
        when:
        def response = bookService.getBook(3)

        then:
        response != null
        response.size()==0
    }

    def "verify saveBook() insert or update record successfully"()
    {
        given:
        bookRepo.save(_) >> responseBookObject
        when:
        def res = bookService.saveBook(requestBookObject)

        then:
        res.getBookId() == 4
        res.bookName.equals("Electronics")

        where:
        requestBookObject                               |   responseBookObject
        new BookDto(bookName: "Electronics") |   new Book(id: 2, makeName: "Electronics")
        new BookDto(bookId: 2, bookName: "Statics")  |   new Book(id:2, bookName: "Statics")
        //new MakeModel(makeId: 3L, makeName: "Hyundai")  |
    }
}
*/
