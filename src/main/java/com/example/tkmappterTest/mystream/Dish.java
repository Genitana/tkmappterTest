package com.example.tkmappterTest.mystream;

public class Dish {
    private String name;
    private boolean vegetarian;  //素食的
    private int calories;       //卡路里
    private Type type ;

    public Dish(){
        super();
    }
    public Dish(String name,boolean vegetarian,int calories,Type type){
        this.name = name;
        this.vegetarian=vegetarian;
        this.calories=calories;
        this.type=type;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum  Type{
        MEAT, FISH , OTHER
    }
}
