package com.example.snoozelog.model.cases

import com.example.snoozelog.view.adapters.ItemList


data class Case (
    val id: Long,
    var comment: String,
    var date: Long,
    val habitId: Long
) : ItemList