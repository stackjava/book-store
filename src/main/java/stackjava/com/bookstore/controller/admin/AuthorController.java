package stackjava.com.bookstore.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import stackjava.com.bookstore.model.Author;
import stackjava.com.bookstore.model.form.AuthorCreateForm;
import stackjava.com.bookstore.service.AuthorService;

@Controller()
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/admin/authors")
    public String authors(Model model) {
        model.addAttribute("authorList", authorService.findAllAuthor());
        return "authors";
    }

    @RequestMapping("/admin/author-create")
    public String authorsCreate(Model model) {
        model.addAttribute("author", new Author());
        return "author-create";
    }

    @PostMapping("/admin/authors")
    public String authors(@ModelAttribute("author") @Validated AuthorCreateForm authorCreateForm,
                          BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError objectError: result.getAllErrors()) {
                System.out.println(objectError);
                System.out.println(objectError.getCode());
            }
            return "author-create";
        }
        return "authors";
    }

}
