package sg.edu.rp.c346.id21023028.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2, btnDemo3, btnExercise3, btnDemo4, btnDemo5;
    TextView tv2, tv3, tve3, tv4, tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region link UI to variable
        btnDemo1 = findViewById(R.id.buttonDemo1);
        btnDemo2 = findViewById(R.id.buttonDemo2);
        btnDemo3 = findViewById(R.id.buttonDemo3);
        btnExercise3 = findViewById(R.id.buttonExercise3);
        btnDemo4 = findViewById(R.id.buttonDemo4);
        btnDemo5 = findViewById(R.id.buttonDemo5);
        tv2 = findViewById(R.id.textViewDemo2);
        tv3 = findViewById(R.id.textViewDemo3);
        tve3 = findViewById(R.id.textViewExercise3);
        tv4 = findViewById(R.id.textViewDemo4);
        tv5 = findViewById(R.id.textViewDemo5);
        //endregion

        //region demo 1 dialog
        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //set dialog details
//                myBuilder.setTitle("Demo 1-Simple Dialog");
//                myBuilder.setMessage("I can develop Android App");
//                myBuilder.setCancelable(false); //allows you to tap outside the dialog to close it
//                myBuilder.setPositiveButton("Close",null);

                //set dialog details (modified part)
                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a single Dialog Box");
                myBuilder.setCancelable(false); //allows you to tap outside the dialog to close it
                myBuilder.setPositiveButton("DISMISS",null);


                //create and show dialog
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        //endregion

        //region demo 2 dialog
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create dialog builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //set dialog details
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below.");
                myBuilder.setCancelable(false);

                //configuring negative button (negative is on the left side)
                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv2.setText("You have selected Negative.");
                    }
                });

                //configuring postive button (button is on right side)
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv2.setText("You have selected Positive.");
                    }
                });



                //configuring neutral button (button is always at most left side)
                myBuilder.setNeutralButton("Cancel",null);

                //create and show dialog
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        //endregion

        //region demo 3 button dialog
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                //create dialog object
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //setting dialog options
                myBuilder.setView(viewDialog);  // Set the view of the dialog to use
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString(); //final needed when creating variable
                        // Set the text to the TextView
                        tv3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        //endregion

        //region exercise 3 dialog
        btnExercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the input.xml layout file
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.inputexercise3, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editText1Exercise);
                final EditText etInput2 = viewDialog.findViewById(R.id.editText2Exercise);

                //create dialog object
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                //setting dialog options
                myBuilder.setView(viewDialog);  // Set the view of the dialog to use
                myBuilder.setTitle("Exercise 3");

                //processing after clicking ok
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        int value1 = Integer.parseInt(etInput.getText().toString()); //final needed when creating variable
                        int value2 = Integer.parseInt(etInput2.getText().toString());
                        // Set the text to the TextView
                        tve3.setText(String.format("The sum is %d",value1+value2));
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
        //endregion

        //region demo4
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create listener to set date (processing after user clicks on with new date)
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tv4.setText(String.format("Date: %d/%d/%4d",dayOfMonth,month,year));
                    }
                };

                //create date picker dialog (to be displayed to user)

                //get the current data by first getting instance, then choosing the type of values
                Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DATE);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                //create the dialog
//                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
//                        myDateListener, 2014,11,31);

                //create dialog (set the date to current date)
                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this,
                        myDateListener, year,month,day);
                myDateDialog.show();
            }
        });
        //endregion

        //region demo5
        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() { //create listener to set time (processing after user clicks on with new time)
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tv5.setText(String.format("Time: %d:%d",hourOfDay,minute));
                    }
                };

                //create time picker dialog (to be displayed to user)
//                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
//                        myTimeListener,20,00,true);
//                myTimeDialog.show();

                //create time picker dialog 12 hour view(to be displayed to user)
//                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
//                        myTimeListener,20,00,false);
//                myTimeDialog.show();

                //create time picker dialog 12 hour view and current system time(to be displayed to user)
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this,
                        myTimeListener,hour,minute,false);
                myTimeDialog.show();
            }
        });

    }
}