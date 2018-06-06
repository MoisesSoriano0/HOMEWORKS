package com.example.admin.dailytwo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class userFormActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etAge;
    private EditText etSex;
    private EditText etNationality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        bindViews();


    }

    private void bindViews() {
        etName = findViewById(R.id.etName);
        etAge = findViewById(R.id.etAge);
        etSex = findViewById(R.id.etSex);
        etNationality = findViewById(R.id.etNationality);
    }

    private ArrayList<PersonP> arr = new ArrayList<PersonP>();
    public void onClickButton(View view) {
        PersonP person = new PersonP(etName.getText().toString(), etAge.getText().toString(), etSex.getText().toString(),etNationality.getText().toString());
        arr.add(person);

        Toast.makeText(userFormActivity.this, "Saved Person", Toast.LENGTH_LONG).show();
        //                Toast.makeText(emiCalculatorActivity.this, "Seek bar progress is :" + progressChangedValue,
//                        Toast.LENGTH_SHORT).show();


    }

    public void onClickButtonPpl(View view) {
        Intent intent = new Intent(getApplicationContext(), peopleListActivity.class);
        intent.putParcelableArrayListExtra(Constants.KEY.PERSON, arr);


        startActivity(intent);
    }
}
