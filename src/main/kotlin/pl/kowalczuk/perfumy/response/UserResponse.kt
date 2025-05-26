package pl.kowalczuk.perfumy.response

import kotlinx.serialization.Serializable
import pl.kowalczuk.perfumy.util.UUIDSerializer
import java.util.*

@Serializable
data class UserResponse(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val email: String,
    val createdAt: Long
)