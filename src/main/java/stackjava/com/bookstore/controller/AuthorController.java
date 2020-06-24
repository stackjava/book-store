package stackjava.com.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import stackjava.com.bookstore.service.AuthorService;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping("/admin/authors")
    public String authors(Model model) {
        model.addAttribute("authorList", authorService.findAllAuthor());
        return "authors";
    }

}
