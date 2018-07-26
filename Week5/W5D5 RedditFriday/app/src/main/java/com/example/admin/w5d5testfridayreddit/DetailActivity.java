package com.example.admin.w5d5testfridayreddit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    TextView tvTitle, tvAuthor, tvDowns, tvUploads, tvComments;
    ImageView ivPic;
    Bundle bundle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvTitle = findViewById(R.id.tvTitledet);
        tvAuthor = findViewById(R.id.tvAuthordet);
        tvDowns = findViewById(R.id.tvDownsd);
        tvUploads = findViewById(R.id.tvUploadsdet);
        tvComments = findViewById(R.id.tvCommentsdet);
        ivPic = findViewById(R.id.ivPic);
        bundle = getIntent().getExtras();

        tvTitle.setText(bundle.get("tvTitle").toString());
        tvAuthor.setText(bundle.get("tvAuthor").toString());
        tvDowns.setText(bundle.get("tvDowns").toString());
        tvUploads.setText(bundle.get("tvUploads").toString());
        tvComments.setText(bundle.get("tvComments").toString());
        Picasso.get().load(bundle.get("ivPicture").toString()).into(ivPic);

    }

    public void onSharedClick(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        startActivity(intent);
    }
}
