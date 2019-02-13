package com.basdek.logintogether.operations

import java.time.Instant

import com.basdek.logintogether.Config.EntityIdentifier
import com.basdek.logintogether.domain.{Permission, Secret, User}

class UserOperations {

  def identify(username: String) : Option[User] = ???

  def authenticate(user: User, password: String) : AuthenticatedUser = ??? //Error cases

  def login(authenticatedUser: AuthenticatedUser, permission: Permission) : Option[LoggedInUser] = ??? //Error cases

}

case class AuthenticatedUser(user: User)

case class LoggedInUser(user: User)

//TODO: JwtToken => User, loggedInUser

class SecretOperations(loggedInUser: User) {

  def create(content: String) : Secret = ???

  def view(secretId: EntityIdentifier) : Either[Error, Secret] = ??? //Errors: 404, 403
}

class PermissionOperations(loggedInUser: User) {

  def create(subject: User, operation: String, resource: String, expires: Option[Instant] = None, metadata : Option[Map[String, _]] = None): Either[Error, Permission] = {
    if (loggedInUser == subject) Left(new Error("Can not create Permission for self"))
    expires match {
      case Some(_) => createExpiring()
      case None => createIndefinite()
    }
  }

  private def createIndefinite() = ???

  private def createExpiring() = ???
}
