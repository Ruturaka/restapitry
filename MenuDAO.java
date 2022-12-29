package com.journaldev.spring.dao;

import com.journaldev.model.Menu;

import java.util.List;

public interface MenuDAO {

    Menu getDishById(Integer id);

    List<Menu> getWholeMenu();

    int createDish(Menu menu);

    int deleteDish(Menu menu);

    int updateDish(Menu menu);
}
