package com.example.admin.w7d3timberlaeakcanaryzxing;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import timber.log.Timber;

public class SecondActivity extends AppCompatActivity {

    private ImageView pdfView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        pdfView = findViewById(R.id.pdfView);

    }



    public void openPDF(View view) {
        openPDFFiles("example.pdf");
    }

    private void openPDFFiles(String fileName) //fileName is the pdf file name which is keep in assets folder. ex file.pdf
    {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), "");
        try {
            in = assetManager.open(fileName);
            out = openFileOutput(file.getName(), MODE_PRIVATE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Timber.e(e);
        }
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse("file://" + getFilesDir() + "/"+fileName), "application/pdf");
            startActivity(intent);
        }catch (RuntimeException ex){
            Toast.makeText(SecondActivity.this, "There's no PDF Reader found in your device", Toast.LENGTH_SHORT).show();
            Timber.e(ex);
        }

    }

    private void copyFile(InputStream in, OutputStream out) throws IOException

    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)

        {
            out.write(buffer, 0, read);
        }
    }
}
