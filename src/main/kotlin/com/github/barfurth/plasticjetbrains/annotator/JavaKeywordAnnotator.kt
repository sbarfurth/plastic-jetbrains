package com.github.barfurth.plasticjetbrains.annotator

import com.github.barfurth.plasticjetbrains.util.AnnotatorUtil
import com.intellij.psi.PsiElement


class JavaKeywordAnnotator : AbstractKeywordHighlighterAnnotator() {
  private val keywordTokenClazz: Class<*> = AnnotatorUtil.findClassByName("com.intellij.psi.PsiKeyword")
  private val literalTokenClass: Class<*> = AnnotatorUtil.findClassByName("com.intellij.psi.PsiLiteralExpression")
  private val methodClazz: Class<*> = AnnotatorUtil.findClassByName("com.intellij.psi.PsiMethod")

  override fun isKeywordElement(element: PsiElement): Boolean {
    return keywordTokenClazz.isAssignableFrom(element.javaClass) || literalTokenClass.isAssignableFrom(element.javaClass)
  }

  override fun isMethodAccessModifierKeyword(element: PsiElement): Boolean {
    val rootParent: PsiElement = AnnotatorUtil.getRootElement(element) ?: return false
    return methodClazz.isAssignableFrom(rootParent.javaClass)
  }
}
