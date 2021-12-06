package com.github.barfurth.jb.plastic.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.util.Pair
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

abstract class AbstractSemanticColoringAnnotator : Annotator {

  override fun annotate(element: PsiElement, holder: AnnotationHolder) {
    if(!isKeyword(element)) return

    val highlight = getHighlight(element.text, element.textRange.startOffset) ?: return

    if(element.textMatches("abstract")) {
      println(highlight)
      println(getSemanticKeywords())
    }

    holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
      .range(highlight.first)
      .textAttributes(highlight.second)
      .create()
  }

  private fun getHighlight(word: String, startOffset: Int): Pair<TextRange, TextAttributesKey>? {
    val type = getSemanticKeywords()[word] ?: return null
    return Pair(TextRange(startOffset, startOffset + word.length), type.getAttributeKey())
  }

  protected abstract fun isKeyword(element: PsiElement): Boolean
  protected abstract fun getSemanticKeywords(): Map<String, SemanticTokenType>

}
