package com.example.sandeepassignment.data.model.infomodel

import android.os.Parcel
import android.os.Parcelable

class Rating() :Parcelable {
    var Source: String?=null
    var Value: String?=null

    constructor(parcel: Parcel) : this() {
        Source = parcel.readString()
        Value = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Source)
        parcel.writeString(Value)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Rating> {
        override fun createFromParcel(parcel: Parcel): Rating {
            return Rating(parcel)
        }

        override fun newArray(size: Int): Array<Rating?> {
            return arrayOfNulls(size)
        }
    }
}