package com.liam.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static int quantity = 0;

    private boolean isCreamAdded = false;

    // A view holder for all the used widgets.
    private ViewHolder myWidgets;

    // Prices for coffee and all kinds of toppings.
    private int coffeePrice = 5;
    private int creamPrice = 1;
    private int chocolatePrice = 2;


    /**
     * To use a ViewHolder class to encapsulate all the Widgets,
     * in case to outer classes could get access to them.
     */
    private class ViewHolder {
        private final Button myButton;
        private final Button mButton;
        private final CheckBox mCheck;
        private final CheckBox mChocolate;
        private final EditText mNameText;

        ViewHolder() {
            mButton = findViewById(R.id.order_button);

            myButton = findViewById(R.id.my_button);
            myButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toAnother = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(toAnother);
                }
            });

            mCheck = findViewById(R.id.add_cream);
            mChocolate = findViewById(R.id.add_chocolate);
            mNameText = findViewById(R.id.edit_name);
        }

        /* Getter methods for all the widgets. */
        public CheckBox getCream() { return mCheck;}
        public CheckBox getChocolate() { return mChocolate; }
        public Button getOrderButton() { return mButton; }
        public Button getJumpButton() { return myButton; }
        public EditText getNameText() { return mNameText; }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all the View widget.
        myWidgets = new ViewHolder();
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

    public void increment(View v) {
        // int quantity = 3;
        if(quantity < 100)
            quantity += 1;
        else
            Toast.makeText(this, "Sorry, but you can't buy more than 100 cups of coffees.",
                    Toast.LENGTH_SHORT).show();
        displayQuantity(quantity);
    }

    public void decrement(View v) {
        // int quantity = 2;
        if(quantity > 1)
            quantity -= 1;
        else
            Toast.makeText(this, "Sorry, but you just buy negative cups of coffees.",
                    Toast.LENGTH_SHORT).show();
        displayQuantity(quantity);
    }

    public void submitOrder(View v) {
        // int number_of_coffees = 2;
        //display(quantity);
        //displayPrice(quantity * 5);
        String orderMessage = createOrderSummary(5);
        displayMessage(orderMessage);
    }

    public void onCheckBoxClicked(View v) {
        if(isCreamAdded)
            isCreamAdded = false;
        else
            isCreamAdded = true;
    }

    /**
     * This method displays the given quantity value on the screen.
     * @param number the value being displayed.
     */
    private void displayQuantity(int number) {
        TextView t_view = findViewById(R.id.quantity_text_view);
        t_view.setText(String.valueOf(number));
    }

    /**
     * This method displays the given price value on the screen.
     * @param number the value being displayed.
     */
    private void displayPrice(int number) {
        TextView price_text_view = findViewById(R.id.order_summary_text_view);
        price_text_view.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given message on the screen.
     * @param message the message being displayed.
     */
    private void displayMessage(String message) {
        TextView orderSummary = findViewById(R.id.order_summary_text_view);
        orderSummary.setText(message);
    }

    /**
     * Calculates the price of the order the current quantity.
     * @param quantity the quantity of coffees.
     */
    private int calculatePrice(int quantity) {
        int unit_price = coffeePrice;
        if(myWidgets.getCream().isChecked()) unit_price += creamPrice;
        if(myWidgets.getChocolate().isChecked()) unit_price += chocolatePrice;

        return quantity * unit_price;
    }

    /**
     * Create a Order receipt that contains the quantity and total costs of items.
     * @param price price for each item.
     * @return a String denoting order information.
     */
    private String createOrderSummary(int price) {
        StringBuilder sb = new StringBuilder();
        sb.append("Name : ").append(myWidgets.getNameText().getText()).append("\n");
        sb.append("Is Wipped Cream Added : ").append(myWidgets.getCream().isChecked()).append("\n");
        sb.append("Is Chocolate Added : ").append(myWidgets.getChocolate().isChecked()).append("\n");
        sb.append("Quantity : ").append(quantity).append("\n");
        sb.append("Total : $").append(calculatePrice(quantity));
        return sb.toString();
    }
}
