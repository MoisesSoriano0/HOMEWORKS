
package com.example.admin.w5d5testfridayreddit.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Variants implements Parcelable
{

    public final static Creator<Variants> CREATOR = new Creator<Variants>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Variants createFromParcel(Parcel in) {
            return new Variants(in);
        }

        public Variants[] newArray(int size) {
            return (new Variants[size]);
        }

    }
    ;

    protected Variants(Parcel in) {
    }

    public Variants() {
    }

    public void writeToParcel(Parcel dest, int flags) {
    }

    public int describeContents() {
        return  0;
    }

}
