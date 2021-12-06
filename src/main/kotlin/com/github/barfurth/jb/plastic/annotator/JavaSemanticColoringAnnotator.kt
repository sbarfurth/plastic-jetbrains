package com.github.barfurth.jb.plastic.annotator

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiKeyword
import com.intellij.psi.PsiLiteralExpression

class JavaSemanticColoringAnnotator : AbstractSemanticColoringAnnotator() {

  override fun isKeyword(element: PsiElement): Boolean {
    return element is PsiKeyword || element is PsiLiteralExpression
  }

  override fun getSemanticKeywords(): Map<String, SemanticTokenType> {
    return mapOf(
      PsiKeyword.TRUE to SemanticTokenType.CONSTANT,
      PsiKeyword.FALSE to SemanticTokenType.CONSTANT,
      PsiKeyword.NULL to SemanticTokenType.CONSTANT,

      PsiKeyword.CLASS to SemanticTokenType.STORAGE,
      PsiKeyword.RECORD to SemanticTokenType.STORAGE,
      PsiKeyword.INTERFACE to SemanticTokenType.STORAGE,
      PsiKeyword.ENUM to SemanticTokenType.STORAGE,
      PsiKeyword.VAR to SemanticTokenType.STORAGE,
      PsiKeyword.CONST to SemanticTokenType.STORAGE,

      PsiKeyword.CHAR to SemanticTokenType.TYPE,
      PsiKeyword.BOOLEAN to SemanticTokenType.TYPE,
      PsiKeyword.LONG to SemanticTokenType.TYPE,
      PsiKeyword.FLOAT to SemanticTokenType.TYPE,
      PsiKeyword.INT to SemanticTokenType.TYPE,
      PsiKeyword.BYTE to SemanticTokenType.TYPE,
      PsiKeyword.SHORT to SemanticTokenType.TYPE,
      PsiKeyword.DOUBLE to SemanticTokenType.TYPE,
      PsiKeyword.VOID to SemanticTokenType.TYPE,
    )
  }

}
