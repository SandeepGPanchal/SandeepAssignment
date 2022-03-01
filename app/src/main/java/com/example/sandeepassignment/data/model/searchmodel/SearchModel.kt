package com.example.sandeepassignment.data.model.searchmodel

import com.example.sandeepassignment.data.model.searchmodel.Search

data class SearchModel(
    var Response: String,
    var Search: List<Search>,
    var totalResults: String,
    var Error: String
)