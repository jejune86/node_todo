package com.sa2d.drawing_diary.repositories;

import com.sa2d.drawing_diary.models.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PageRepository {
    private final JdbcTemplate jdbc;

    public PageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbc = jdbcTemplate;
    }

    public void addPage(Page page) {
        String sql = "Insert into pages values (DEFAULT, ?, ?)";
        jdbc.update(sql, page.getTitle(), page.getContent());
    }

    public List<Page> findAllPages() {
        String sql = "select * from pages";

        RowMapper<Page> pageRowMapper = (r,i) -> {
            Page page = new Page();
            page.setTitle(r.getString("title"));
            page.setContent(r.getString("content"));
            return page;
        };
        return jdbc.query(sql, pageRowMapper);
    }
}
