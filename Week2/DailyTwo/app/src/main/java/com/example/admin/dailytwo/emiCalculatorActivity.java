package com.example.admin.dailytwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class emiCalculatorActivity extends AppCompatActivity {

    private TextView tvTime;
    private TextView tvPrincipal;
    private TextView tvRate;
    private TextView tvResult;
    private SeekBar sbPrincipal;
    private SeekBar sbRate;
    private SeekBar sbTime;

    public static final int TWELVE = 12;
    public static final int HUNDRED = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_calculator);

        bindViews();

        seekBars();

    }

    private void seekBars() {
        sbPrincipal = findViewById(R.id.seekBarPrincipal);
        sbRate = findViewById(R.id.seekBarRate);
        sbTime = findViewById(R.id.seekBarTime);



        sbPrincipal.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                tvPrincipal.setText(progress);
                progressChangedValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(emiCalculatorActivity.this, "Seek bar progress is :" + progressChangedValue,
//                        Toast.LENGTH_SHORT).show();
                tvPrincipal.setText(String.valueOf(progressChangedValue));
                setResult();
            }
        });

        sbRate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvRate.setText(String.valueOf(progressChangedValue));
                setResult();
            }
        });


        sbTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tvTime.setText(String.valueOf(progressChangedValue));
                setResult();
            }
        });

    }

    private void setResult(){
        tvResult.setText(String.valueOf(emi_calculator(Float.valueOf(tvPrincipal.getText().toString()), Float.valueOf(tvRate.getText().toString()), Float.valueOf(tvTime.getText().toString()))));
    }

    private void bindViews() {
        tvPrincipal = findViewById(R.id.tvPrincipal);
        tvRate = findViewById(R.id.tvRate);
        tvTime = findViewById(R.id.tvTime);
        tvResult = findViewById(R.id.tvResult);

    }

    private float emi_calculator(float p,
                                float r, float t)
    {
        float emi;

        r = r / (TWELVE * HUNDRED); // one month interest
        t = t * TWELVE; // one month period
        emi = (p * r * (float)Math.pow(1 + r, t))
                / (float)(Math.pow(1 + r, t) - 1);

        return (emi);
    }
}
