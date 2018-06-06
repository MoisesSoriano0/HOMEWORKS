package com.example.admin.dailytwo;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonP implements Parcelable {
    String name;
    String age;
    String sex;
    String nationality;

    protected PersonP(Parcel in) {
        name = in.readString();
        age = in.readString();
        sex = in.readString();
        nationality = in.readString();
    }

    public static final Creator<PersonP> CREATOR = new Creator<PersonP>() {
        @Override
        public PersonP createFromParcel(Parcel in) {
            return new PersonP(in);
        }

        @Override
        public PersonP[] newArray(int size) {
            return new PersonP[size];
        }
    };

    @Override
    public String toString() {
        return "PersonP{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public PersonP(String name, String age, String sex, String nationality) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.nationality = nationality;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
        dest.writeString(sex);
        dest.writeString(nationality);
    }
}
