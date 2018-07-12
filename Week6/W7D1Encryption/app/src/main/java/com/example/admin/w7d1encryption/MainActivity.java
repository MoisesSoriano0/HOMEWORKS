package com.example.admin.w7d1encryption;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {

    private EditText etMain;
    private TextView tvMain;
    private String MY_SHARED_PREF = "mySharedPref";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private KeystoreWrapper keystoreWrapper;
    private CipherWrapper cipherWrapper;
    private KeyPair keyPair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMain = findViewById(R.id.etMain);
        tvMain = findViewById(R.id.tvMain);


        //get shared preferences, sharedpreference file
        sharedPreferences = getSharedPreferences(MY_SHARED_PREF, Context.MODE_PRIVATE);


        //Encryption

        try {
            keystoreWrapper = new KeystoreWrapper(this);

            cipherWrapper = new CipherWrapper();
            keyPair = keystoreWrapper.getKeyPair("something");


        } catch (CertificateException | NoSuchAlgorithmException | KeyStoreException | IOException | NoSuchPaddingException | UnrecoverableKeyException | NoSuchProviderException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

    }


    public void onSavePreference(View view) {
        //get data from the EditText

        String data = etMain.getText().toString();

        editor = sharedPreferences.edit();

        editor.putString("data", data);
        boolean isSaved = editor.commit();

        if (isSaved) {
            Toast.makeText(this, "Value saved", Toast.LENGTH_SHORT).show();
        }

    }

    public void onGetPreference(View view) {
        String data = sharedPreferences.getString("data", "default value");
        tvMain.setText(data);

    }

    public void onClearData(View view) {
        editor.clear();
    }

    public void onEncrypt(View view) throws NoSuchAlgorithmException, UnrecoverableKeyException, InvalidAlgorithmParameterException, KeyStoreException, NoSuchProviderException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {

        String plainText = etMain.getText().toString();
        String cipherText = cipherWrapper.encrypt(plainText, keyPair.getPublic());
        tvMain.setText(cipherText);
    }

    public void onDecrypt(View view) throws BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        String cipherText = tvMain.getText().toString();
        String plainText = cipherWrapper.decrypt(cipherText, keyPair.getPrivate());
        tvMain.setText(plainText);
    }
}
