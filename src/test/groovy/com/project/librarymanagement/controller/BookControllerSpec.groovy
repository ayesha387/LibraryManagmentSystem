/*
import com.example.LMS.model.BookDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class BookControllerSpec extends Specification
{
    def mockBookService = Mock(BookService.class)
    def controller = new BookController(bookService: mockBookService)
    def mockMvc = MockMvcBuilders.standaloneSetup(controller).build()

    */
/*
List< MakeModel> makeModelList = new ArrayList<>();
MakeModel makeModel = new MakeModel()
makeModel.setMakeId(1L)
makeModel.setMakeName("Audi")
makeModelList.add(makeModel)
*//*

    //def objMakeModel = new MakeModel(makeId: 1L, makeName: "Audi")

    def setupBookResponse()
    {
        [new BookDto(bookId: 1, bookName: "Friction"), new BookDto(bookId: 2, bookName: "Functions")]
    }

    def "GET: / verify endpoint returns list of BookDto object"()
    {
        given:
        mockBookService.getBook(bookId) >> libraryBookResponse
        when:
        def response = mockMvc.perform(get(inputParam).contentType(MediaType.APPLICATION_JSON_VALUE))

        then:
        response.andExpect(status().isOk())
        response.andExpect {content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)}
        response.andExpect {MockMvcResultMatchers.jsonPath('$[0].bookId').value(2)}

        where:
        inputParam                  |   bookId      | libraryBookResponse
        "/api/book/list"            |   null        | setupBookResponse()
        "/api//book/list?bookId=1"  |   1L          | setupBookResponse()
    }


    def "GET: / verify endpoint returns null value"()
    {
        given:
        mockBookService.getBook(_) >> null
        when:
        def response = mockMvc.perform(get("/book/list").contentType(MediaType.APPLICATION_JSON_VALUE))

        then:
        response.andExpect(status().isOk())
        response.andExpect {content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)}
        response.andExpect {MockMvcResultMatchers.jsonPath('$.bookId').value(null)}
    }

    def "POST: / Verify  creates new record succesfully"()
    {
        given:
        def bookDto = new BookDto(bookName: "Friction")
        def bookBtoJson = new ObjectMapper().writeValueAsString(bookDto)

        // mock behaviour
        mockBookService.saveBook(bookDto) >> new BookDto(bookId: 1, bookName: "chem" )

        when:
        def response = mockMvc.perform(post("/book/save").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(bookDtoJson))

        then: "status should be 200"
        response.andExpect(status().isOk())
        response.andExpect {content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)}
        response.andExpect {MockMvcResultMatchers.jsonPath('$.bookId').value(1)}
    }

    def "POST: / Verify  Update existing record succesfully"()
    {
        given:
        def bookDto = new BookDto(bookId: 2, bookName: "Communication")
        def bookDtoJson = new ObjectMapper().writeValueAsString(bookDto)

        // mock behaviour
        mockBookService.saveBook(bookDto) >> bookDto

        when:
        def response = mockMvc.perform(post("/book/save").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(bookDtoJson))

        then: "status should be 200"
        response.andExpect(status().isOk())
        response.andExpect {content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)}
        response.andExpect {MockMvcResultMatchers.jsonPath('$.bookId').value(2)}
    }
}
*/
