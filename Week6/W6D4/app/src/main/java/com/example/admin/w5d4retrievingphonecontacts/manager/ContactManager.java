package com.example.admin.w5d4retrievingphonecontacts.manager;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.example.admin.w5d4retrievingphonecontacts.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {

    Context context;
    String contactName;
    List<Contact> contacts;

    public ContactManager(Context context) {
        this.context = context;
        this.contacts = new ArrayList<>();
    }

    static class URI{
        //All the meta-data of the contact is already in the sdk, ContactsContract
       static Uri contactUri = ContactsContract.Contacts.CONTENT_URI;
       static Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
    }

    public class COLUMNS {
        //For contacts content provider
        static final String DISPLAY_NAME = ContactsContract.Contacts.DISPLAY_NAME;
        static final String HAS_PHONE_NUMBER = ContactsContract.Contacts.HAS_PHONE_NUMBER;

//        for phone content provider
        static final String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
    }


    public List<Contact> getContacts() {
        Cursor contactsCursor = context.getContentResolver()
                .query(URI.contactUri,
                        null,
                        null,
                        null,
                        null);


        while (contactsCursor.moveToNext()) {
            contactName = contactsCursor
                    .getString(
                            contactsCursor
                                    .getColumnIndex(COLUMNS.DISPLAY_NAME)); //We pass the name to find the

            int HAS_PHONE_NUMBER_INDEX = contactsCursor.getColumnIndex(COLUMNS.HAS_PHONE_NUMBER);
            int HAS_PHONE = contactsCursor.getInt(HAS_PHONE_NUMBER_INDEX);

            //One contact provider has the names only, if it has phone number, you call another content provider to get the number
            if (HAS_PHONE > 0) {
                List<String> numbers = new ArrayList<>();
                Cursor phoneCursor = context.getContentResolver()
                        .query(
                                URI.phoneUri, //Content URI
                                new String[]{COLUMNS.NUMBER}, //projection
                                COLUMNS.DISPLAY_NAME + "=?", //selection
                                new String []{contactName},  //selection argument
                                COLUMNS.NUMBER + " ASC" //sortOrder
                        );

                while (phoneCursor.moveToNext()) {
                    String phoneNumbers = phoneCursor.getString(phoneCursor.getColumnIndex(COLUMNS.NUMBER));
                    numbers.add(phoneNumbers);
                }

                Contact contact = new Contact(contactName, numbers);
                contacts.add(contact);
            }

        }

        return contacts;

    }

}
