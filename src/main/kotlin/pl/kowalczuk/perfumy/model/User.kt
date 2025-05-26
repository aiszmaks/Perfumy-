package pl.kowalczuk.perfumy.model

import java.util.*

data class User(
    val id: UUID,
    val email: String,
    val password: String,
    val createdAt: Long
)