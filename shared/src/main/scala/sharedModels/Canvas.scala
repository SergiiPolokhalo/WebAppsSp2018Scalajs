package sharedModels

import play.api.libs.json.JsValue
import play.api.libs.json.Writes
import play.api.libs.json.Json
import play.api.libs.json.Reads
import play.api.libs.json.JsPath
import play.api.libs.json.Reads._
import play.api.libs.functional.syntax._
import scala.collection.mutable._

/**
 * Holds the data for a canvas, including all particles and the objects representing contributing users
 */
class Canvas (var shapes: List[sharedModels.Shape] = List[sharedModels.Shape]()) {
  def addShape(shape: sharedModels.Shape) = {
    shapes ::= shape
  }
}

object Canvas {
  implicit val format = Json.format[Canvas]
  def unapply(canvas: Canvas): Option[List[sharedModels.Shape]] = {
    Some(canvas.shapes)
  }
  def apply(shapes: List[sharedModels.Shape]): Canvas = {
    new Canvas(shapes)
  }
}