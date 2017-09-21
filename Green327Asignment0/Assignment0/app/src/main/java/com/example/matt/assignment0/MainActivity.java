package com.example.matt.assignment0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double starRating;
    private double totalPrice;
    private TextView result;
    private NumberPicker price;
    private Button button;
    private RatingBar star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        this.button = (Button) findViewById(R.id.button);
        this.star = (RatingBar) findViewById(R.id.ratingBar);
        this.price = (NumberPicker) findViewById(R.id.numberPicker);
        this.result = (TextView) findViewById(R.id.textViewresult);

        this.star.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar star, float rating, boolean fromUser) {
                if(star.getRating()<= 1.5)
                {
                    starRating = .1;
                }
                else if(star.getRating()<= 2.5)
                {
                    starRating = .13;
                }
                else if(star.getRating()<= 3.5)
                {
                    starRating = .15;
                }
                else if(star.getRating()<= 4.5)
                {
                    starRating = .2;
                }
                else if(star.getRating()<= 5)
                {
                    starRating = .25;
                }

            }
        });

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(String.valueOf(totalPrice * starRating + totalPrice));
            }
        });
        price.setMinValue(0);
        price.setMaxValue(500);

        price.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                totalPrice = newVal;
            }
        });

    }
}