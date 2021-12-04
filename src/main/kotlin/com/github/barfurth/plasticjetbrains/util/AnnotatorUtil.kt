package com.github.barfurth.plasticjetbrains.util

import com.intellij.psi.PsiElement

object AnnotatorUtil {

  fun findClassByName(className: String): Class<*> {
    return try {
      Class.forName(className)
    } catch (e: ClassNotFoundException) {
      Void::class.java
    }
  }

  fun getRootElement(element: PsiElement): PsiElement? {
    val parent = element.parent ?: return null
    return parent.parent
  }

}
