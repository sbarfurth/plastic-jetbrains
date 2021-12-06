package com.github.barfurth.jb.plastic.annotator

import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.lexer.KtKeywordToken
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtConstantExpression

class KotlinSemanticColoringAnnotator : AbstractSemanticColoringAnnotator() {

  override fun isKeyword(element: PsiElement): Boolean {
    if (element is LeafPsiElement) {
      val type = element.elementType
      return type is KtKeywordToken
    }
    return element is KtConstantExpression
  }

  override fun getSemanticKeywords(): Map<String, SemanticTokenType> {
    return mapOf(
      KtTokens.NULL_KEYWORD.value to SemanticTokenType.CONSTANT,
      KtTokens.FALSE_KEYWORD.value to SemanticTokenType.CONSTANT,
      KtTokens.TRUE_KEYWORD.value to SemanticTokenType.CONSTANT,

      KtTokens.VAL_KEYWORD.value to SemanticTokenType.STORAGE,
      KtTokens.VAR_KEYWORD.value to SemanticTokenType.STORAGE,
      KtTokens.CLASS_KEYWORD.value to SemanticTokenType.STORAGE,
      KtTokens.OBJECT_KEYWORD.value to SemanticTokenType.STORAGE,
      KtTokens.ENUM_KEYWORD.value to SemanticTokenType.STORAGE,
      KtTokens.FUN_KEYWORD.value to SemanticTokenType.STORAGE,
      KtTokens.INTERFACE_KEYWORD.value to SemanticTokenType.STORAGE,
      KtTokens.ANNOTATION_KEYWORD.value to SemanticTokenType.STORAGE,
      KtTokens.DATA_KEYWORD.value to SemanticTokenType.STORAGE,
      KtTokens.CONST_KEYWORD.value to SemanticTokenType.STORAGE,

      KtTokens.GET_KEYWORD.value to SemanticTokenType.FUNCTION,
      KtTokens.SET_KEYWORD.value to SemanticTokenType.FUNCTION
    )
  }

}
