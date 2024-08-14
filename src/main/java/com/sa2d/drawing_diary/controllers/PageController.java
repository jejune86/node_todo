package com.sa2d.drawing_diary.controllers;

import com.sa2d.drawing_diary.models.Page;
import com.sa2d.drawing_diary.repositories.PageRepository;
import com.sa2d.drawing_diary.services.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {
    private final PageRepository pageRepository;

    public PageController(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @GetMapping("/pages")
    public String pages(Model model) {
        var pages = pageRepository.findAllPages();
        model.addAttribute("pages", pages);

        return "pages.html";
    }

    @PostMapping("/pages")
    public String addPage(
            @RequestParam String title,
            @RequestParam String content,
            Model model) {
        Page page = new Page();
        page.setTitle(title);
        page.setContent(content);
        pageRepository.addPage(page);

        var pages = pageRepository.findAllPages();
        model.addAttribute("pages", pages);
        return "redirect:/pages";
    }

}
