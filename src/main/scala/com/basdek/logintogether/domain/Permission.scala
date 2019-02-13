package com.basdek.logintogether.domain

import java.time.Instant

import com.basdek.logintogether.domain.Permission.Expiration


object Permission {
  final case class Indefintely() {}
  type Expiration = Either[Instant, Indefintely]
}


case class Permission(subject: User,
                      operation: String, //TODO
                      resource: String, //TODO
                      expires: Expiration,
                      metadata: Option[Map[String,_]] = None)
