package fr.pr.coursesrapides.coursesrapides.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IngredientCategorieIntrouvableException extends RuntimeException {
    public IngredientCategorieIntrouvableException(String s) {
        super(s);
    }
}
