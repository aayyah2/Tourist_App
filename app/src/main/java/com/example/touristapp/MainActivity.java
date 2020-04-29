package com.example.touristapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private Map<Attraction, String> attractionDirectory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        attractionDirectory = new HashMap<>();
        boolean param1 = false;
        boolean param2 = false;
        boolean param3 = false;

        createAttractionMap();

        View optionsChunk = getLayoutInflater().inflate(R.layout.activity_main, null, false);

        Button nextButton = findViewById(R.id.nextButton);
        RadioButton ny = findViewById(R.id.nyButton);
        RadioButton ct = findViewById(R.id.ctButton);
        RadioButton nj = findViewById(R.id.njButton);

        RadioButton child = findViewById(R.id.childButton);
        RadioButton adult = findViewById(R.id.adultButton);

        RadioButton attraction = findViewById(R.id.attractionButton);
        RadioButton restaurant = findViewById(R.id.restaurantButton);
        RadioButton hotel = findViewById(R.id.hotelButton);


        nextButton.setOnClickListener(v -> {

            RadioGroup locationGroup = findViewById(R.id.locationGroup);
            int locationPref = locationGroup.getCheckedRadioButtonId();
            System.out.println(locationGroup.getCheckedRadioButtonId());
            if (locationGroup.getCheckedRadioButtonId() != -1) {
                if(ny.isChecked()) {
                    locationPref = 0;
                } else if (ct.isChecked()) {
                    locationPref = 1;
                } else if (nj.isChecked()) {
                    locationPref = 2;
                }
            }


            RadioGroup childGroup = findViewById(R.id.childGroup);
            int categoryPref = childGroup.getCheckedRadioButtonId();
            System.out.println(childGroup.getCheckedRadioButtonId());
            if (childGroup.getCheckedRadioButtonId() != -1) {
                if(adult.isChecked()) {
                    categoryPref = 1;
                } else if (child.isChecked()) {
                    categoryPref = 0;
                }
            }


            RadioGroup typeGroup = findViewById(R.id.typeGroup);
            int typePref = typeGroup.getCheckedRadioButtonId();
            System.out.println(typeGroup.getCheckedRadioButtonId());
            if (typeGroup.getCheckedRadioButtonId() != -1) {

                if(attraction.isChecked()) {
                    typePref = 1;
                } else if (restaurant.isChecked()) {
                    typePref = 0;
                } else if (hotel.isChecked()) {
                    typePref = 2;
                }
            }
            Attraction userPref = new Attraction(locationPref, categoryPref, typePref);

            String testCode = userPref.getAttractionID();
            TextView testView = findViewById(R.id.testView);
            testView.setText(testCode);

            String result = findAttraction(locationPref, categoryPref, typePref);
            if (locationPref == 0) {
                setContentView(R.layout.newyork_layout);
            } else if (locationPref == 1) {
                setContentView(R.layout.connecticut_layout);
            } else {
                setContentView(R.layout.activity_nj);
            }

            TextView resultView = findViewById(R.id.resultView);
            String userResult = "Your ideal " + userPref.getCategoryID() + "in " + userPref.getStateID()
                    + "that is " + userPref.getChildID() + "is " + result;
            resultView.setText(userResult);

            //image
        });

    }
    private void createAttractionMap() {
        Attraction one = new Attraction(0, 0, 0);
        Attraction two = new Attraction(0, 0, 1);
        Attraction three = new Attraction(0,0,2);
        Attraction four = new Attraction(0, 1, 0);
        Attraction five = new Attraction(0,1, 1);
        Attraction six = new Attraction(0,1,2);
        Attraction seven = new Attraction(1,0,0);
        Attraction eight = new Attraction(1,0,1);
        Attraction nine = new Attraction(1,0,2);
        Attraction ten = new Attraction(1,1,0);
        Attraction eleven = new Attraction(1,1,1);
        Attraction twelve = new Attraction(1,1,2);
        Attraction thirteen = new Attraction(2,0,0);
        Attraction fourteen = new Attraction(2,0,1);
        Attraction fifteen = new Attraction(2, 0, 2);
        Attraction sixteen = new Attraction(2,1,0);
        Attraction seventeen = new Attraction(2,1,1);
        Attraction eighteen = new Attraction(2,1,2);

        attractionDirectory.put(one, "Ellen's Stardust Diner ");
        attractionDirectory.put(two, "Children's Museum of the Arts ");
        attractionDirectory.put(three, "Lotte New York Palace ");
        attractionDirectory.put(four, "The Four Horsemen ");
        attractionDirectory.put(five, "Guggenheim Museum ");
        attractionDirectory.put(six, "Crowne Plaza Times Square Manhatten ");
        attractionDirectory.put(seven, "Lenny and Joe's ");
        attractionDirectory.put(eight, "IT Adventure Ropes Course ");
        attractionDirectory.put(nine, "The Whaler's Inn ");
        attractionDirectory.put(ten, "The Cottage ");
        attractionDirectory.put(eleven, "New England Air Museum ");
        attractionDirectory.put(twelve, "Delamar Southport ");
        attractionDirectory.put(thirteen, "Clinton Station Diner ");
        attractionDirectory.put(fourteen, "Fosterfields Living Historical Farm ");
        attractionDirectory.put(fifteen, "Sand Castle Bed and Breakfast ");
        attractionDirectory.put(sixteen, "Cafe Panache ");
        attractionDirectory.put(seventeen, "Atlantic City Boardwalk ");
        attractionDirectory.put(eighteen, "The Southern Mansion ");

    }

    private String findAttraction(int one, int two, int three) {
        if ((one == -1 && two == -1)&& (three == -1)) {
            return "Please select all fields";
        }
        String code = "" + one + "" + two + "" + three;
        for ( Map.Entry<Attraction, String> entry : attractionDirectory.entrySet()) {
            if (entry.getKey().getAttractionID().equals(code)) {
                return entry.getValue();
            }
        }
        return "None Found ";
    }



}
