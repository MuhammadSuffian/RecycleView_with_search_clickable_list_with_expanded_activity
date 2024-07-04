package com.example.list_view_with_image_and_name

import android.os.Parcel
import android.os.Parcelable

data class ItemsViewModel(val image: Int ,val text:String,val subtext:String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(text)
        parcel.writeString(subtext)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ItemsViewModel> {
        override fun createFromParcel(parcel: Parcel): ItemsViewModel {
            return ItemsViewModel(parcel)
        }

        override fun newArray(size: Int): Array<ItemsViewModel?> {
            return arrayOfNulls(size)
        }
    }
}
