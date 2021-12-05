package com.github.barfurth.jb.plastic.annotator

import com.github.barfurth.jb.plastic.util.AnnotatorUtil

class JavaPlasticColoringAnnotator : AbstractPlasticColoringAnnotator() {

  override fun getColorableClasses(): Collection<Class<*>> {
    return listOf(
      AnnotatorUtil.findClassByName("com.intellij.psi.PsiKeyword"),
      AnnotatorUtil.findClassByName("com.intellij.psi.PsiLiteralExpression")
    )
  }

  override fun getConstantKeywords(): Collection<String> {
    return listOf(
      "false",
      "true",
      "null"
    )
  }

  override fun getStorageKeywords(): Collection<String> {
    return listOf(
      "class",
      "interface",
      "enum",
      "extends",
      "implements",
      "synchronized",
      "abstract",
      "private",
      "var",
      "static",
      "const ",
      "protected",
      "final",
      "public",
      "protected",
      "public",
      "private",
      "sealed",
      "non-sealed"
    )
  }

  override fun getTypeKeywords(): Collection<String> {
    return listOf(
      "char",
      "boolean",
      "long",
      "float",
      "int",
      "byte",
      "short",
      "double",
      "void"
    )
  }

}
