package com.example.admin.w7d1compoundviewhw.compoundview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.w7d1compoundviewhw.R;

public class LoginLayout extends LinearLayout {

    @StyleableRes
    int index0 = 0;
    @StyleableRes
    int index1 = 1;
    @StyleableRes
    int index2 = 2;

    private TextView tvUserName;
    private TextView tvPassword;

    public LoginLayout(Context context, AttributeSet attrs) {
        super(context);
        init(context,attrs);
    }

//    public LoginLayout(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public LoginLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    public LoginLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//    }

    private void init(Context context, AttributeSet attrs) {
        inflate(context, R.layout.login_layout, this);

        int[] sets = {R.attr.userAttr, R.attr.passAttr};

        TypedArray typedArray = context.obtainStyledAttributes(attrs, sets);
        TypedArray typedArray1 = context.obtainStyledAttributes(attrs, R.styleable.LoginLayout);
        CharSequence user = typedArray.getText(index0);
        CharSequence pass = typedArray.getText(index1);

        tvUserName = findViewById(R.id.tvUserName);
        tvPassword = findViewById(R.id.tvPass);

        System.out.println(typedArray1.getText(index0));
        System.out.println(typedArray1.getText(index1));



        tvUserName.setText(typedArray1.getText(index1));
        tvPassword.setText(typedArray1.getText(index0));


    }
}
