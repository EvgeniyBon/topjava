package ru.javawebinar.topjava.Dao;

import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsListGenerator;

import java.time.LocalDateTime;
import java.util.List;

public class MealDaoImpl implements MealDao{
    public static List<MealTo> getMealList() {
        return mealList;
    }

    private static List<MealTo>mealList = MealsListGenerator.getList();

    @Override
    public void remove(Long id) {

    }

    @Override
    public void update(Long id, String Description, LocalDateTime time, Integer calories, Boolean excess) {

    }

    @Override
    public void getById(Long id) {

    }

    @Override
    public void addMeal(MealTo meal) {

    }

    @Override
    public List<MealTo> getCollection() {
        return mealList;
    }
}
