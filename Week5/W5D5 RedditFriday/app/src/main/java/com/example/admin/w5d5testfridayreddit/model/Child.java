
package com.example.admin.w5d5testfridayreddit.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Child implements Parcelable
{

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("data")
    @Expose
    private DataReddit data;
    public final static Creator<Child> CREATOR = new Creator<Child>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Child createFromParcel(Parcel in) {
            return new Child(in);
        }

        public Child[] newArray(int size) {
            return (new Child[size]);
        }

    }
    ;

    protected Child(Parcel in) {
        this.kind = ((String) in.readValue((String.class.getClassLoader())));
        this.data = ((DataReddit) in.readValue((DataReddit.class.getClassLoader())));
    }

    public Child() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public DataReddit getData() {
        return data;
    }

    public void setData(DataReddit data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(kind);
        dest.writeValue(data);
    }

    public int describeContents() {
        return  0;
    }

}
