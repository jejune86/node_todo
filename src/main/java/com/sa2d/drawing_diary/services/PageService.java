package com.sa2d.drawing_diary.services;

import com.sa2d.drawing_diary.models.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageService {
    private List<Page> pages = new ArrayList<>();

    public void addPage(Page page) {
        pages.add(page);
    }

    public List<Page> findAll() {
        return pages;
    }
}
