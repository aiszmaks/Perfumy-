package pl.kowalczuk.perfumy.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import pl.kowalczuk.perfumy.model.User
import pl.kowalczuk.perfumy.request.UserRequest
import pl.kowalczuk.perfumy.response.UserResponse
import java.util.*

val users = mutableListOf<User>()

fun Route.userRoutes() {
    route("/api/user") {

        post {
            try {
                val req = call.receive<UserRequest>()
                val newUser = User(
                    id = UUID.randomUUID(),
                    email = req.email,
                    password = req.password,
                    createdAt = System.currentTimeMillis()
                )
                users.add(newUser)

                call.response.header("id", newUser.id.toString())
                call.respond(UserResponse)
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest, "Invalid JSON: ${e.message}")
            }
        }

        get {
            call.respond(users.map {
                UserResponse(
                    id = it.id,
                    email = it.email,
                    createdAt = it.createdAt
                )
            })
        }

        get("/{id}") {
            val id = call.parameters["id"] ?: return@get call.respond(HttpStatusCode.BadRequest)
            val user = users.find { it.id.toString() == id }
                ?: return@get call.respond(HttpStatusCode.NotFound)
            call.respond(UserResponse(user.id, user.email, user.createdAt))
        }
    }
}