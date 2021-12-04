package com.github.barfurth.plasticjetbrains.highlighter

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.util.Pair
import com.intellij.openapi.util.TextRange

interface TokenHighlighter {

  fun getHighlights(text: String, startOffset: Int): List<Pair<TextRange, TextAttributesKey>>

  fun getHighlights(tokenType: HighlightTokenType, text: String, startOffset: Int): List<Pair<TextRange, TextAttributesKey>> {
    return if (getSupportedTokenTypes().contains(tokenType)) {
      getHighlights(text, startOffset)
    } else emptyList()
  }

  fun getTextAttributeKeyByToken(token: String): String

  fun getSupportedTokenTypes(): List<HighlightTokenType>

}
