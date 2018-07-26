package com.example.admin.w5d4contentprovider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.admin.w5d4contentprovider.dbhelper.SqlDbManager;

public class UserProvider extends ContentProvider {
    private SqlDbManager dbManager;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(ContractUser.AUTHORITY, ContractUser.PATH, 1);
        sUriMatcher.addURI(ContractUser.AUTHORITY, ContractUser.PATH + "/#", 2);
    }

    @Override
    public boolean onCreate() {
        dbManager = new SqlDbManager(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase db = dbManager.getWritableDatabase();
        Cursor mCursor = null;

        switch (sUriMatcher.match(uri)){
            case 1:
                mCursor = db.query(ContractUser.User.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
                break;
            case 2:
                selection = selection + ContractUser.User.ID + " = " + uri.getLastPathSegment();
                mCursor = db.query(ContractUser.User.TABLE_NAME, projection, selection, selectionArgs, null, null, null);
                break;
            default:
                Toast.makeText(getContext(), "Invalid content uri", Toast.LENGTH_LONG).show();
                throw new IllegalArgumentException("Unknown Uri: " + uri);
        }
        mCursor.setNotificationUri(getContext().getContentResolver(), uri);
        return mCursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {

        switch (sUriMatcher.match(uri)){
            case 1:
                return ContractUser.CONTENT_DICTIONARY_LIST;
            case 2:
                return ContractUser.CONTENT_DICTIONARY_ITEM;
            default:
                throw new IllegalArgumentException("Unknown Uri: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        SQLiteDatabase db = dbManager.getWritableDatabase();

        if(sUriMatcher.match(uri) != 1) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        long rowId = db.insert(ContractUser.User.TABLE_NAME, null, values);
        if(rowId > 0) {
            Uri articleUri = ContentUris.withAppendedId(ContractUser.CONTENT_URI, rowId);
            getContext().getContentResolver().notifyChange(articleUri, null);
            return articleUri;
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = dbManager.getWritableDatabase();
        int count = 0;
        switch(sUriMatcher.match(uri)) {
            case 1:
                count = db.delete(ContractUser.User.TABLE_NAME, selection, selectionArgs);
                break;
            case 2:
                String rowId = uri.getPathSegments().get(1);
                count = db.delete(ContractUser.User.TABLE_NAME, ContractUser.User.ID + " = " + rowId
                        + (!TextUtils.isEmpty(selection) ? " AND (" + selection + ")" : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI: " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = dbManager.getWritableDatabase();
        int count = 0;
        switch (sUriMatcher.match(uri)){
            case 1:
                count = db.update(ContractUser.User.TABLE_NAME, values, selection, selectionArgs);
                break;

            case 2:
                String rowId = uri.getPathSegments().get(1);
                count = db.update(ContractUser.User.TABLE_NAME, values, ContractUser.User.ID + " = " + rowId +
                        (!TextUtils.isEmpty(selection) ? " AND (" + ")" : ""), selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("Unknown Uri: " + uri );
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

}
