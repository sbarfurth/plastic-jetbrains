package com.github.barfurth.plasticjetbrains.highlighter

import com.intellij.openapi.components.Service
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.util.Pair
import com.intellij.openapi.util.TextRange
import kotlin.streams.toList

@Service
class KeywordHighlighter : TokenHighlighter {

  private fun getSupportedTokens(): Collection<String> {
    return listOf(
      // Storage
      "class", "const", "interface", "var", "let", "val", "function", "abstract", "enum", "static", "final",
      // Visibility
      "public", "private", "protected", "sealed",
      // Constant literal
      "undefined", "null", "true", "false"
    )
  }

  override fun getHighlights(text: String, startOffset: Int): List<Pair<TextRange, TextAttributesKey>> {
    val textRange = TextRange(startOffset, startOffset + text.length)
    return createHighlightsForMatchingTokens(getSupportedTokens(), text, textRange)
  }

  override fun getHighlights(tokenType: HighlightTokenType, text: String, startOffset: Int): List<Pair<TextRange, TextAttributesKey>> {
    val textRange = TextRange(startOffset, startOffset + text.length)
    return createHighlightsForMatchingTokens(getSupportedTokens(), text, textRange)
  }

  override fun getTextAttributeKeyByToken(token: String): String {
    return token + "_KEYWORD"
  }

  override fun getSupportedTokenTypes(): List<HighlightTokenType> {
    return listOf(HighlightTokenType.KEYWORD, HighlightTokenType.METHOD_KEYWORD)
  }

  private fun createHighlightsForMatchingTokens(supportedTokens: Collection<String>, text: String, textRange: TextRange): List<Pair<TextRange, TextAttributesKey>> {
    return supportedTokens.stream()
      .filter { token: String -> token.equals(text, ignoreCase = true) }
      .map { token: String -> TextAttributesKey.createTextAttributesKey(getTextAttributeKeyByToken(token)) }
      .map { highlightAttribute: TextAttributesKey -> Pair.create(textRange, highlightAttribute) }
      .toList()
  }

}
