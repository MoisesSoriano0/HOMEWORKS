
package com.example.admin.w5d5testfridayreddit.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MediaEmbed implements Parcelable
{

    public final static Creator<MediaEmbed> CREATOR = new Creator<MediaEmbed>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MediaEmbed createFromParcel(Parcel in) {
            return new MediaEmbed(in);
        }

        public MediaEmbed[] newArray(int size) {
            return (new MediaEmbed[size]);
        }

    }
    ;

    protected MediaEmbed(Parcel in) {
    }

    public MediaEmbed() {
    }

    public void writeToParcel(Parcel dest, int flags) {
    }

    public int describeContents() {
        return  0;
    }

}
