package app.prog.controller.response;


import app.prog.model.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {

    private int id;
    private String name;
    private String particularity;
    private boolean hasParticularity;

}
