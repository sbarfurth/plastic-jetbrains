package com.github.barfurth.jb.plastic.annotator

import com.github.barfurth.jb.plastic.util.AnnotatorUtil

class KotlinPlasticColoringAnnotator : AbstractPlasticColoringAnnotator() {

  override fun getColorableClasses(): Collection<Class<*>> {
    return listOf(
      AnnotatorUtil.findClassByName("org.jetbrains.kotlin.lexer.KtKeywordToken"),
    )
  }

  override fun getConstantKeywords(): Collection<String> {
    return listOf()
  }

  override fun getStorageKeywords(): Collection<String> {
    return listOf()
  }

  override fun getTypeKeywords(): Collection<String> {
    return listOf()
  }

}
