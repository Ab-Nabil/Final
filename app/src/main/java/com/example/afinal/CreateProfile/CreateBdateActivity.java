package com.example.afinal.CreateProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.afinal.R;

import java.util.Calendar;

public class CreateBdateActivity extends AppCompatActivity implements View.OnClickListener {

    private int mYear, mMonth, mDay;
    ImageView bDateBackRow;
    ImageView bDateForwardRow;
    EditText bDateValue;
    public String mAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_bdate);

        bDateValue = (EditText) findViewById(R.id.bDateEditText);
        bDateBackRow = (ImageView) findViewById(R.id.bDateBackRow);
        bDateForwardRow = (ImageView) findViewById(R.id.bDateForwardRow);

        bDateBackRow.setOnClickListener(this);
        bDateValue.setOnClickListener(this);
        bDateForwardRow.setOnClickListener(this);
    }
    private void getAge(int year,int month,int day){
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)){
            age--;
        }

        Integer ageInt = new Integer(age);
        mAge = ageInt.toString();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bDateForwardRow: {

                if (bDateValue.getText().toString().isEmpty()) {
                    bDateValue.setError("Enter Your Birth-Date");
                    break;
                } else {
                    Intent intent = getIntent();
                    String rUserName = intent.getStringExtra("username");
                    intent = new Intent(CreateBdateActivity.this, CreateFitLevelActivity.class);
                    intent.putExtra("username",rUserName);
                    startActivity(intent);
                    break;
                }
            }
            case R.id.bDateBackRow:
                Intent intent=new Intent(CreateBdateActivity.this,CreateHeightActivity.class);
                startActivity(intent);
                break;


            case R.id.bDateEditText:

            if (v == bDateValue) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                bDateValue.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                getAge(year,monthOfYear,dayOfMonth);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();


            }


        }

    }


}