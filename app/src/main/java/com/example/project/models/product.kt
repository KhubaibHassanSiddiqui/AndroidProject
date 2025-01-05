package com.example.project.models

data class Product(
    var category: String? = null,
    var img: String? = null,
    var isAvailable: Boolean = false,
    var name: String? = null,
    var price: Double = 0.0
)