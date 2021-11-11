package com.example.almin.DBRoom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "TVShow") // name of the table of database
data class TV_ShowEntity (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")val id: Int = 0,
    @ColumnInfo(name = "pk")val pk: Int = 0,
    @ColumnInfo(name = "name")val name: String = "",
    @ColumnInfo(name = "languge")val languge: String = "",
    @ColumnInfo(name = "summary")val summary: String = "",
    @ColumnInfo(name = "image")val image: String = ""

    )