package com.example.admin.quwang.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 2017/3/27.
 */

public class WebBean implements Parcelable{
    private String linkurl;
    private String title;

    protected WebBean(Parcel in) {
        linkurl = in.readString();
        title = in.readString();
    }

    public WebBean() {
    }

    public static final Creator<WebBean> CREATOR = new Creator<WebBean>() {
        @Override
        public WebBean createFromParcel(Parcel in) {
            return new WebBean(in);
        }

        @Override
        public WebBean[] newArray(int size) {
            return new WebBean[size];
        }
    };

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(linkurl);
        dest.writeString(title);
    }
}
