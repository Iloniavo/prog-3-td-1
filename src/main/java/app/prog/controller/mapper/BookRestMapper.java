package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookRestMapper {

    private final AuthorService authorService;

    public BookResponse toRest(BookEntity domain) {

        if(domain.getAuthor() == null){
            return BookResponse.builder()
                    .id(domain.getId())
                    .title(domain.getTitle())
                    .author(null)
                    .hasAuthor(domain.hasAuthor())
                    .categories(domain.getCategories())
                    .build();
        }

        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor().getName())
                .categories(domain.getCategories())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        AuthorEntity entity = authorService.getAuthorByName(rest.getAuthor());
        return BookEntity.builder()
                .author(entity)
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        AuthorEntity authorEntity = authorService.getAuthorById(rest.getId());
        return BookEntity.builder()
                .id(rest.getId())
                .author(authorEntity)
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }
}
