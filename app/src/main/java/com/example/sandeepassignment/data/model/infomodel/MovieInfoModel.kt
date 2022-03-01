package com.example.sandeepassignment.data.model.infomodel

import android.os.Parcel
import android.os.Parcelable

class MovieInfoModel() : Parcelable {
    var Actors: String? = null
    var Awards: String? = null
    var BoxOffice: String? = null
    var Country: String? = null
    var DVD: String? = null
    var Director: String? = null
    var Genre: String? = null
    var Language: String? = null
    var Metascore: String? = null
    var Plot: String? = null
    var Poster: String? = null
    var Production: String? = null
    var Rated: String? = null
    var Ratings: List<Rating>? = null
    var Released: String? = null
    var Response: String? = null
    var Runtime: String? = null
    var Title: String? = null
    var Type: String? = null
    var Website: String? = null
    var Writer: String? = null
    var Year: String? = null
    var imdbID: String? = null
    var imdbRating: String? = null
    var imdbVotes: String? = null
    var Error: String? = null

    constructor(parcel: Parcel) : this() {
        Actors = parcel.readString()
        Awards = parcel.readString()
        BoxOffice = parcel.readString()
        Country = parcel.readString()
        DVD = parcel.readString()
        Director = parcel.readString()
        Genre = parcel.readString()
        Language = parcel.readString()
        Metascore = parcel.readString()
        Plot = parcel.readString()
        Poster = parcel.readString()
        Production = parcel.readString()
        Rated = parcel.readString()
        Ratings = parcel.createTypedArrayList(Rating)
        Released = parcel.readString()
        Response = parcel.readString()
        Runtime = parcel.readString()
        Title = parcel.readString()
        Type = parcel.readString()
        Website = parcel.readString()
        Writer = parcel.readString()
        Year = parcel.readString()
        imdbID = parcel.readString()
        imdbRating = parcel.readString()
        imdbVotes = parcel.readString()
        Error = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Actors)
        parcel.writeString(Awards)
        parcel.writeString(BoxOffice)
        parcel.writeString(Country)
        parcel.writeString(DVD)
        parcel.writeString(Director)
        parcel.writeString(Genre)
        parcel.writeString(Language)
        parcel.writeString(Metascore)
        parcel.writeString(Plot)
        parcel.writeString(Poster)
        parcel.writeString(Production)
        parcel.writeString(Rated)
        parcel.writeTypedList(Ratings)
        parcel.writeString(Released)
        parcel.writeString(Response)
        parcel.writeString(Runtime)
        parcel.writeString(Title)
        parcel.writeString(Type)
        parcel.writeString(Website)
        parcel.writeString(Writer)
        parcel.writeString(Year)
        parcel.writeString(imdbID)
        parcel.writeString(imdbRating)
        parcel.writeString(imdbVotes)
        parcel.writeString(Error)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieInfoModel> {
        override fun createFromParcel(parcel: Parcel): MovieInfoModel {
            return MovieInfoModel(parcel)
        }

        override fun newArray(size: Int): Array<MovieInfoModel?> {
            return arrayOfNulls(size)
        }
    }
}