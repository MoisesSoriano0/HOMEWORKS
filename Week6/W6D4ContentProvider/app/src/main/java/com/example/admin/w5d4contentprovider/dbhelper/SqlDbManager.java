package com.example.admin.w5d4contentprovider.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.w5d4contentprovider.ContractUser;

public class SqlDbManager extends SQLiteOpenHelper {


    public SqlDbManager(Context context) {
        super(context, ContractUser.DATABASE_NAME, null, ContractUser.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String	CREATE_USERS_TABLE = "CREATE	TABLE " + ContractUser.User.TABLE_NAME + "(" + ContractUser.User.ID + " INTEGER PRIMARY KEY,"
                + ContractUser.User.NAME + " TEXT,"
                + ContractUser.User.LAST_NAME + " TEXT,"
                + ContractUser.User.BIRTHDAY + " TEXT,"
                + ContractUser.User.AGE + " TEXT,"
                + ContractUser.User.ADDRESS + " TEXT,"
                + ContractUser.User.EMAIL + " TEXT,"
                + ContractUser.User.PHONE + " TEXT,"
                + ContractUser.User.PASSWORD + " TEXT" + ")";

        sqLiteDatabase.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ContractUser.User.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
