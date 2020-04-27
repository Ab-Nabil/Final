package com.example.afinal.CreateProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.afinal.R;

public class CreateWeightActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView weightbackRow;
    ImageView weightforwardRow;
    EditText weightValue;

    String mWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_create_weight );
        weightValue=(EditText)findViewById(R.id.weightEditText);
        weightbackRow=(ImageView)findViewById(R.id.weightBackRow);
        weightforwardRow=(ImageView)findViewById(R.id.weightForwardRow);




        weightbackRow.setOnClickListener(this);
        weightValue.setOnClickListener(this);
        weightforwardRow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.weightForwardRow:{
                mWeight  = weightValue.getText().toString();
                    if (mWeight.isEmpty()){
                        weightValue.setError("Enter Your Weight");
                        return;
                    }
                    else {
                        Intent intent = getIntent();
                        String rUserName = intent.getStringExtra("username");
                        intent = new Intent(CreateWeightActivity.this, CreateHeightActivity.class);
                        intent.putExtra("username",rUserName);
                        startActivity(intent);

                    }
                break;
            }
            case R.id.weightBackRow:{
                Intent intent = new Intent(CreateWeightActivity.this,CreateGenderActivity.class);
                startActivity(intent);
                break;
            }

        }
    }
}
