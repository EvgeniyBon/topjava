package ru.javawebinar.topjava.Dao;

import ru.javawebinar.topjava.model.MealTo;

import java.time.LocalDateTime;
import java.util.List;

public interface MealDao {
   void remove(Long id);
   void update(Long id, String Description, LocalDateTime time,Integer calories,Boolean excess);
   void getById (Long id);
   void addMeal(MealTo meal);
   List<MealTo> getCollection();
}
