package com.example.admin.w5d4contentprovider;

import android.net.Uri;
import android.provider.BaseColumns;

public class ContractUser {

    public static final String AUTHORITY = "com.example.androidcontentprovider.User";
    public static final String PATH  = "/users";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + PATH);

    public static final String CONTENT_DICTIONARY_LIST = "vnd.android.cursor.dir/vnd.com.example.androidcontentprovider.users";
    public static final String CONTENT_DICTIONARY_ITEM = "vnd.android.cursor.item/vnd.com.example.androidcontentprovider.users";

    public static final String DATABASE_NAME = "users_db";
    public static final int DATABASE_VERSION = 1;


    public static class User implements BaseColumns {

        private User(){}

        public static final String TABLE_NAME = "username";

        public static final String ID = "_id";
        public static final String NAME = "name";
        public static final String LAST_NAME = "lastname";
        public static final String BIRTHDAY = "birthday";
        public static final String AGE = "age";
        public static final String ADDRESS = "address";
        public static final String EMAIL = "email";
        public static final String PHONE = "phone";
        public static final String PASSWORD = "password";

    }
}
