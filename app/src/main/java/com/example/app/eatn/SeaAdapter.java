package com.example.app.eatn;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SeaAdapter extends ArrayAdapter<SeaClass> {


    int quantity = 0; int i = 0;
    int value = 0; String hold = "";
    int pos = 0, counter = 1;
    String [] order_details = new String[1000];
    DatabaseHelper mydb;
    String Number,Name,Quantity,Price = "";

    public SeaAdapter(Activity context, ArrayList<SeaClass> sea_food) {
        super(context, 0, sea_food);
        this.mydb = new DatabaseHelper(context.getApplicationContext());

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.menu_design, parent, false);
        }

        final SeaClass currentfastfood = getItem(position);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.item_image);
        imageView.setImageResource(currentfastfood.getImageResourceId());


        TextView nameTextView = (TextView) listItemView.findViewById(R.id.item_name);
        nameTextView.setText(currentfastfood.getItemName());

        TextView priceTextView = (TextView) listItemView.findViewById(R.id.item_price);
        priceTextView.setText("Price " + currentfastfood.getItemPrice());


        Button plus = (Button) listItemView.findViewById(R.id.plus_btn);
        final View finalListItemView = listItemView;
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = Integer.parseInt(currentfastfood.getItemquantity()) + 1;
                currentfastfood.setItemquantity(Integer.toString(quantity));
                TextView quantityTextView = (TextView) finalListItemView.findViewById(R.id.quantity);
                quantityTextView.setText(currentfastfood.getItemquantity());




            }
        });

        Button minus = (Button) listItemView.findViewById(R.id.minus_btn);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Integer.parseInt(currentfastfood.getItemquantity()) > 0) {
                    quantity = Integer.parseInt(currentfastfood.getItemquantity()) - 1;
                    currentfastfood.setItemquantity(Integer.toString(quantity));
                    TextView quantityTextView = (TextView) finalListItemView.findViewById(R.id.quantity);
                    quantityTextView.setText(currentfastfood.getItemquantity());

                }

            }
        });


        hold = currentfastfood.getItemquantity();
        value = Integer.parseInt(hold);
        quantity = value + quantity;

        TextView quantityTextView = (TextView) listItemView.findViewById(R.id.quantity);
        quantityTextView.setText(String.valueOf(quantity));

        Button cart_btn = (Button) listItemView.findViewById(R.id.cart_btn);
        cart_btn.setTag(position);

        cart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cart_btn.setEnabled(false);
                pos = (Integer)view.getTag();
                if(Integer.parseInt(currentfastfood.getItemquantity()) != 0) { //if quan < 0 or equals to 0
                    if (pos == 0) {
                        boolean isinserted = mydb.Add_to_Cart("Finger Fish",currentfastfood.getItemquantity(),String.valueOf(600*Integer.parseInt(currentfastfood.getItemquantity())));
                        if (isinserted)
                        {
                            int price = 1; //price * quantity = total price
                            order_details[i] = "Id " + counter + " Finger Fish Price Rs " + 600 * Integer.parseInt(currentfastfood.getItemquantity()) + " ";
                            counter++;  //var use for no of items order
                            i++;  //var uses to store data in array */
                            Toast.makeText(getContext(), "Order Added Successfully !", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(getContext(), "Please, Try again", Toast.LENGTH_SHORT).show();




                    }
                    if (pos == 1) {
                        boolean isinserted =  mydb.Add_to_Cart("Shrimp",currentfastfood.getItemquantity(),String.valueOf(900*Integer.parseInt(currentfastfood.getItemquantity())));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id " + counter + " Shrimp Price Rs " + 900 * Integer.parseInt(currentfastfood.getItemquantity())  + " ";
                            counter++;
                            i++;
                            Toast.makeText(getContext(), "Order Added Successfully !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Please, Try again", Toast.LENGTH_SHORT).show();




                    }
                    if (pos == 2) {
                        boolean isinserted = mydb.Add_to_Cart("Fried Fish",currentfastfood.getItemquantity(),String.valueOf(650*Integer.parseInt(currentfastfood.getItemquantity())));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id : " + counter + " Fried Fish Price Rs " + 650 * Integer.parseInt(currentfastfood.getItemquantity()) + " ";
                            counter++;
                            i++;
                            Toast.makeText(getContext(), "Order Added Successfully !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Please, Try again", Toast.LENGTH_SHORT).show();





                    }
                    if (pos == 3) {

                        boolean isinserted = mydb.Add_to_Cart("Prawn soap",currentfastfood.getItemquantity(),String.valueOf(450*Integer.parseInt(currentfastfood.getItemquantity() )));
                        if (isinserted)
                        {
                            int price = 1;
                            order_details[i] = "Id " + counter + " Prawn soap Rs " + 450 * Integer.parseInt(currentfastfood.getItemquantity() )+ " ";
                            counter++;
                            i++;
                            Toast.makeText(getContext(), "Order Added Successfully !", Toast.LENGTH_SHORT).show();

                        }
                        else
                            Toast.makeText(getContext(), "Please, Try again", Toast.LENGTH_SHORT).show();

                    }



                } else {  Toast.makeText(getContext(), "Quantity value can't be zero or lesser!!!", Toast.LENGTH_SHORT).show();

                    int j = 0;
                    Toast.makeText(getContext(), "" + order_details[j] + "\n" + order_details[j+1] + "\n"+ order_details[j+2] + "\n" + order_details[j+3], Toast.LENGTH_LONG).show();

                }




            }
        });

        return listItemView;
    }}