package net.madeng.gradle.plugin.slack.api

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
class Attachment {

  String authorName
  String authorLink
  String authorIcon
  String color
  String fallback
  def fields = []
  String footer
  String footerIcon
  String imageUrl
  String pretext
  String text
  String thumbUrl
  String title
  String titleLink
  Long ts = System.currentTimeSeconds()

  def field(Closure closure) {
    closure.resolveStrategy = Closure.DELEGATE_FIRST
    Field field = new Field()
    closure.delegate = field
    fields << field
    closure()
  }
}