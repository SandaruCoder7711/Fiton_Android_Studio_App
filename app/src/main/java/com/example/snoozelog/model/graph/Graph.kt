package com.example.snoozelog.model.graph

import com.example.snoozelog.view.adapters.ItemList
import java.util.Date

data class Graph(
    val data: MutableMap<Date, Int>
) : ItemList