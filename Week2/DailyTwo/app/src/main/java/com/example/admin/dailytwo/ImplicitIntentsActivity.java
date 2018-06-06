package com.example.admin.dailytwo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ImplicitIntentsActivity extends AppCompatActivity {


    private ImageView image_captured;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intents);

        image_captured = findViewById(R.id.imageCamera);
        phoneNumber = findViewById(R.id.phoneInput);

    }

    public void onClickButtonImplicit(View view) {
        Intent intent = null;

        switch (view.getId()){
            case R.id.btnCamera:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                break;
            case R.id.btnShareString:
//                intent = new Intent(Intent.EXTRA_TEXT);
//                intent.putExtra(Intent.EXTRA_TEXT, "What do you call a labrador that's a magician?");
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "What do you call a labrador that's a magician?");
                intent.putExtra(Intent.EXTRA_TEXT, "A labracadabrador lol");
                intent.setData(Uri.parse("mailto:default@recipient.com"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.btnCallNumber:
//                intent = new Intent(this, userFormActivity.class);
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+phoneNumber.getText().toString()));
                startActivity(intent);
                break;
        }

//        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            image_captured.setImageBitmap(bitmap);
        }
    }
}
