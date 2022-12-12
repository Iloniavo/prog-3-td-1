package app.prog.controller;

import app.prog.controller.mapper.AuthorRestMapper;
import app.prog.controller.response.AuthorResponse;
import app.prog.controller.response.CreateAuthorResponse;
import app.prog.controller.response.UpdateAuthorResponse;
import app.prog.model.AuthorEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class AuthorController {

    private final AuthorService service;
    private final AuthorRestMapper mapper;

    @GetMapping("/authors")
    public List<AuthorResponse> getBooks(){
        return service.getAuthors()
                .stream()
                .map(mapper::toRest)
                .collect(Collectors.toList());
    }

    @PostMapping("/authors")
    public List<AuthorResponse> createAuthors(@RequestBody List<CreateAuthorResponse> toCreate){
        List<AuthorEntity> responses = service.createAuthors(toCreate
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList()));
        return responses.stream().map(mapper::toRest).collect(Collectors.toList());
    }

    @PutMapping("/authors")
    public List<AuthorResponse> updateAuthors(@RequestBody List<UpdateAuthorResponse> authors){
        List<AuthorEntity> toUpdate = service.updateAuthors(authors
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList())
        );
        return toUpdate.stream().map(mapper::toRest).collect(Collectors.toList());
    }

    @DeleteMapping("/authors/{id}")
    public AuthorEntity deleteAuthor(@PathVariable Integer id){
        return service.deleteAuthor(id);
    }
}
