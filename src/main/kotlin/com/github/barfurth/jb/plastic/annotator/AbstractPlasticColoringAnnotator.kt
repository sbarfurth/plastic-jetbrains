package com.github.barfurth.jb.plastic.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.util.Pair
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

abstract class AbstractPlasticColoringAnnotator : Annotator {

  override fun annotate(element: PsiElement, holder: AnnotationHolder) {
    if(!isColorable(element)) return

    val highlight = getHighlight(element.text, element.textRange.startOffset) ?: return

    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
      .range(highlight.first)
      .textAttributes(highlight.second)
      .create()
  }

  private fun getHighlight(word: String, startOffset: Int): Pair<TextRange, TextAttributesKey>? {
    val type = getTypeByWord(word) ?: return null
    return Pair(TextRange(startOffset, startOffset + word.length), type.getAttributeKey())
  }

  private fun isColorable(element: PsiElement): Boolean {
    return getColorableClasses().any { clazz -> clazz.isAssignableFrom(element.javaClass) }
  }

  private fun getTypeByWord(word: String): PlasticTokenType? {
    if(getConstantKeywords().contains(word)) return PlasticTokenType.CONSTANT
    if(getStorageKeywords().contains(word)) return PlasticTokenType.STORAGE
    if(getTypeKeywords().contains(word)) return PlasticTokenType.TYPE
    return null
  }

  protected abstract fun getColorableClasses(): Collection<Class<*>>

  protected abstract fun getConstantKeywords(): Collection<String>
  protected abstract fun getStorageKeywords(): Collection<String>
  protected abstract fun getTypeKeywords(): Collection<String>

}
