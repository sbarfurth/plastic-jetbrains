package com.github.barfurth.plasticjetbrains.annotator

import com.github.barfurth.plasticjetbrains.highlighter.HighlightTokenType
import com.github.barfurth.plasticjetbrains.highlighter.KeywordHighlighter
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.util.Pair
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

abstract class AbstractKeywordHighlighterAnnotator : Annotator {

  override fun annotate(element: PsiElement, holder: AnnotationHolder) {
    if (isKeywordElement(element)) {
      val keyword = element.text
      val startOffset = element.textRange.startOffset
      val highlights = getKeywordHighlights(element, keyword, startOffset)
      for (highlight in highlights) {
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
          .range(highlight.first)
          .textAttributes(highlight.second)
          .create()
      }
    }
  }

  private fun getKeywordHighlights(element: PsiElement, keyword: String, startOffset: Int): List<Pair<TextRange, TextAttributesKey>> {
    val keywordHighlighter = ServiceManager.getService(KeywordHighlighter::class.java)
    val highlights: MutableList<Pair<TextRange, TextAttributesKey>> = ArrayList()
    highlights.addAll(keywordHighlighter.getHighlights(HighlightTokenType.KEYWORD, keyword, startOffset))
    if (isMethodAccessModifierKeyword(element)) {
      highlights.addAll(keywordHighlighter.getHighlights(HighlightTokenType.METHOD_KEYWORD, keyword, startOffset))
    }
    return highlights
  }

  protected abstract fun isKeywordElement(element: PsiElement): Boolean
  protected abstract fun isMethodAccessModifierKeyword(element: PsiElement): Boolean

}
