package uk.gov.hmrc.$!APP_PACKAGE_NAME!$.controllers.healthController

import java.util.jar

import play.api.Play
import collection.JavaConversions._

trait Manifest {

  import play.api.Play.current

  protected def appName:String

  lazy val contents: Map[String, String] = resources.foldLeft(Map.empty[String, String]) { (map, url) =>
    val manifest = new java.util.jar.Manifest(url.openStream())
    if (map.isEmpty && isApplicationManifest(manifest)) {
      manifest.getMainAttributes.toMap.map {
        t => t._1.toString -> t._2.toString
      }
    } else {
      map
    }
  }

  private val resources = Play.application.classloader.getResources("META-INF/MANIFEST.MF")

  private def isApplicationManifest(manifest: jar.Manifest) =
    appName == manifest.getMainAttributes.getValue("Implementation-Title")
}


