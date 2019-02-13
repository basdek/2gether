package com.basdek.logintogether.domain

case class User(username : String, password: String, mates: Set[User]) {

}
