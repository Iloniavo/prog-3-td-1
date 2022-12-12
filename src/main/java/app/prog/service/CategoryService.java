package app.prog.service;

import app.prog.model.CategoryEntity;
import app.prog.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<CategoryEntity> getCategories(){
        return repository.findAll();
    }

    public CategoryEntity getCategoryById(Integer id){
        return repository.getById(id);
    }
}
