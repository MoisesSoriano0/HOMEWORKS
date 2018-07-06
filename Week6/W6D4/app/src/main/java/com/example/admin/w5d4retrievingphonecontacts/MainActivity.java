package com.example.admin.w5d4retrievingphonecontacts;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.admin.w5d4retrievingphonecontacts.manager.ContactManager;
import com.example.admin.w5d4retrievingphonecontacts.manager.PermissionManager;
import com.example.admin.w5d4retrievingphonecontacts.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity implements PermissionManager.IPermissionManager{

    private PermissionManager permissionManager;
    private ListView lvContact;
    private ContactManager contactManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lvContact = findViewById(R.id.lvContacts);
        setContentView(R.layout.activity_main);

        //check permission
        permissionManager = new PermissionManager(this);
        contactManager = new ContactManager(this);
        permissionManager.checkPermission();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        permissionManager.checkResult(requestCode, permissions, grantResults);
    }

    public void getPhoneContacts() {

    }

    @Override
    public void onPermissionResult(boolean isGranted) {

        if (isGranted) {

            List<Contact> contactList = contactManager.getContacts();
            ArrayAdapter arrayAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.simple_expandable_list_item_1,
                    contactList);
            lvContact.setAdapter(arrayAdapter);
        }

    }
}
