package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

       }

    public void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

//    private void displayPrice(int number) {
//        TextView priceTextView = findViewById(R.id.order_summary_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    public void submitOrder1(View view) {
        EditText text = findViewById(R.id.name_text_field);
        String name = text.getText().toString();


        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCreamCheckBox = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        RadioButton forlight = findViewById(R.id.light_button);
        boolean haslight = forlight.isChecked();

        RadioButton forheavy = findViewById(R.id.heavy_button);
        boolean hasheavy = forheavy.isChecked();

        RadioButton fornone = findViewById(R.id.heavy_button);
        boolean hasnone = fornone.isChecked();


        int price= calculatePrice(hasWhippedCreamCheckBox, hasChocolate, hasheavy, haslight, hasnone);
        String priceMessage= createOrderSummary(name, price, hasWhippedCreamCheckBox, hasChocolate, haslight, hasheavy, hasnone);
        displayMessage(priceMessage);

//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:"));
//        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject, name));
//        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
    }

    public void submitOrder(View view) {

         CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCreamCheckBox = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkBox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        RadioButton forlight = findViewById(R.id.light_button);
        boolean haslight = forlight.isChecked();

        RadioButton forheavy = findViewById(R.id.heavy_button);
        boolean hasheavy = forheavy.isChecked();

        RadioButton fornone = findViewById(R.id.heavy_button);
        boolean hasnone = fornone.isChecked();



        int price= calculatePrice(hasWhippedCreamCheckBox, hasChocolate, hasheavy, haslight, hasnone);

    }


    public int calculatePrice(boolean addWhippedCream, boolean addChocolate, boolean addheavy, boolean addlight, boolean addnone){
        int basePrice=5;


        if (addWhippedCream) {
            basePrice= basePrice + 1;
        }
        if (addChocolate){
            basePrice= basePrice+2;
        }
        if (addheavy){
            basePrice = basePrice + 2;
         }
        if (addlight){
            basePrice = basePrice + 1;
          }
        if (addnone){

        }

        return quantity * basePrice;
    }

    public void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity > 0 ){
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }

    public void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate, boolean havelow, boolean hasheavy, boolean havenone) {

        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd Whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate? " + addChocolate;
        priceMessage += "\nQuantity:  " + quantity;
        if (havelow){
            priceMessage += "\nMilk Shake: Light";
        }        if (hasheavy){
            priceMessage += "\nMilk Shake: Heavy";
        }
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";

        return priceMessage;


    }

}
