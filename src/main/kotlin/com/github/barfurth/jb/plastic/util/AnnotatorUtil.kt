package com.github.barfurth.jb.plastic.util

object AnnotatorUtil {

  fun findClassByName(className: String): Class<*> {
    return try {
      Class.forName(className)
    } catch (e: ClassNotFoundException) {
      Void::class.java
    }
  }

}
