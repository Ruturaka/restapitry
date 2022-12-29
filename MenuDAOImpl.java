package com.journaldev.spring.dao;

import com.journaldev.model.Menu;
import com.journaldev.model.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class MenuDAOImpl implements MenuDAO{
    JdbcTemplate jdbcTemplate;

    @Autowired
    public MenuDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Menu getDishById(Integer id) {
        return jdbcTemplate.queryForObject("select * from menu where id = ?", new Object[]{id}, new MenuMapper());

    }

    @Override
    public List<Menu> getWholeMenu() {
        return jdbcTemplate.query("select * from menu", new MenuMapper());

    }

    @Override
    public int createDish(Menu menu) {
        return jdbcTemplate.update("insert into menu(id, dish, price) values(?,?,?)", menu.getId(), menu.getDish(), menu.getPrice());
    }

    @Override
    public int deleteDish(Menu menu) {
        return jdbcTemplate.update("delete from menu where id=?", menu.getId());
    }

    @Override
    public int updateDish(Menu menu) {
        return jdbcTemplate.update("update menu set dish=?, price=? where id=?", menu.getDish(), menu.getPrice(), menu.getId());
    }


}
