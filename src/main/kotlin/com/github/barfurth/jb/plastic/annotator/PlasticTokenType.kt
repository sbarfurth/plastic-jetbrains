package com.github.barfurth.jb.plastic.annotator

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey

enum class PlasticTokenType {
  CONSTANT, STORAGE, TYPE;

  fun getAttributeKey(): TextAttributesKey {
    val name = "PLASTIC_${this.name}"
    return TextAttributesKey.createTextAttributesKey(name, DefaultLanguageHighlighterColors.KEYWORD)
  }
}
