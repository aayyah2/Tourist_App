package com.example.touristapp;

public class Attraction {
    //0 = NY, 1 = CT, 2 = NJ
    private int stateID;

    //0 = Child Friendly, 1 = Adult Friendly
    private int childID;

    //0 = Food, 1 = Visiting, 2 = Hotel
    private int categoryID;

    //000, 001, 002, etc.
    private String attractionID;

    public Attraction(final int state, final int child, final int category) {
        stateID = state;
        childID = child;
        categoryID = category;
        attractionID = "" + stateID + "" + childID + "" + categoryID;
    }

    public String getAttractionID() {
        return attractionID;
    }

}
