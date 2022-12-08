package app.prog.controller.mapper;

import app.prog.controller.request.BookRequest;
import app.prog.controller.response.BookResponse;
import app.prog.controller.response.BookUpdate;
import app.prog.model.Book;
import app.prog.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookRestMapper {

    private final BookService bookService;
    public BookResponse toRest(Book domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public Book toCreate(BookRequest domain){
        return Book.builder()
                .title(domain.getTitle())
                .author(domain.getAuthor())
                .build();
    }

    public Book toUpdate(BookUpdate domain){
        Book book = bookService.getBookById(domain.getId());
                book.setTitle(domain.getTitle());
                book.setAuthor(domain.getAuthor());
        return book;
    }
}
