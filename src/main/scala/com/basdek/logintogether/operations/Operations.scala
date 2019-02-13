package com.basdek.logintogether.operations

import java.time.Instant

import com.basdek.logintogether.Config.EntityIdentifier
import com.basdek.logintogether.domain.{Permission, Secret, User}

import scala.concurrent.Future

trait UserOperations[F[_]] {

  def identify(username: String) : F[Option[User]]

  def authenticate(user: User, password: String) : F[Option[AuthenticatedUser]]

  def login(authenticatedUser: AuthenticatedUser, permission: Permission) : F[Option[LoggedInUser]]



  /**
  {
    permission match {
      case Permission(_, _,_, Left(expireInstant), Some(issuer: Map[String, User])) if authenticatedUser.user == permission.subject && authenticatedUser.user.mates.contains(issuer("issuedBy"))=> ???
      case _ => ???
    }
  }
    **/

}

object UserOperationsInterpreter extends UserOperations[Future] {
  override def identify(username: String): Future[Option[User]] = Future.successful(Some(User("jane.doe", "xxx", Set.empty)))
  override def authenticate(user: User, password: String): Future[Option[AuthenticatedUser]] = Future.successful(Some(AuthenticatedUser(User("jane.doe", "xxx", Set.empty))))
  override def login(authenticatedUser: AuthenticatedUser, permission: Permission): Future[Option[LoggedInUser]] = ???
}

case class AuthenticatedUser(user: User) //TODO: move

case class LoggedInUser(user: User) //TODO: move, moet je hier weten op basis van welke permissie?

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
