package com.liam.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // private ViewHolder
    private static int quantity = 0;

    private Button myButton;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.order_button);

        myButton = findViewById(R.id.my_button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAnother = new Intent(MainActivity.this, MainActivity.class);
                startActivity(toAnother);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent toAnother = new Intent(this, MyTest.class);
        startActivity(toAnother);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void increament(View v) {
        // int quantity = 3;
        quantity += 1;
        display(quantity);
    }

    public void decrement(View v) {
        // int quantity = 2;
        quantity -= 1;
        display(quantity);
    }

    public void submitOrder(View v) {
        // int number_of_coffees = 2;
        //display(quantity);
        //displayPrice(quantity * 5);
        String priceMessage = "Total : $" + quantity * 5;
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     * @param number the value being displayed.
     */
    private void display(int number) {
        TextView t_view = findViewById(R.id.quantity_text_view);
        t_view.setText("" + number);
    }

    /**
     * This method displays the given price value on the screen.
     * @param number the value being displayed.
     */
    private void displayPrice(int number) {
        TextView price_text_view = findViewById(R.id.price_text_view);
        price_text_view.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given message on the screen.
     * @param message the message being displayed.
     */
    private void displayMessage(String message) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }



}
