package com.github.barfurth.jb.plastic.annotator

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

enum class SemanticTokenType {
  CONSTANT, STORAGE, TYPE, FUNCTION;

  fun getAttributeKey(): TextAttributesKey {
    val name = "SEMANTIC_${this.name}"
    return TextAttributesKey.createTextAttributesKey(name, DefaultLanguageHighlighterColors.KEYWORD)
  }
}
