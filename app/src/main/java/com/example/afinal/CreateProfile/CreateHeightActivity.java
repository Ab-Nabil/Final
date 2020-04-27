package com.example.afinal.CreateProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.afinal.R;

public class CreateHeightActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView heightbackRow;
    ImageView heightforwardRow;
    EditText heightValue;

    String mHeight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_create_height );

        heightValue=(EditText)findViewById(R.id.heightEditText);
        heightbackRow=(ImageView)findViewById(R.id.heightBackRow);
        heightforwardRow=(ImageView)findViewById(R.id.heightForwardRow);



        heightbackRow.setOnClickListener(this);

        heightforwardRow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.heightForwardRow: {
                mHeight = heightValue.getText().toString();
                if (mHeight.isEmpty()) {
                    heightValue.setError("Enter Your Height");

                }
                else {
                    Intent intent1 = getIntent();
                    String rUserName = intent1.getStringExtra("username");
                    intent1 = new Intent(CreateHeightActivity.this, CreateBdateActivity.class);
                    intent1.putExtra("username",rUserName);
                    startActivity(intent1);

                }
                break;
            }

            case R.id.heightBackRow:{
                Intent intent=new Intent(CreateHeightActivity.this,CreateWeightActivity.class);
                startActivity(intent);
                break;
            }

        }
    }
}
