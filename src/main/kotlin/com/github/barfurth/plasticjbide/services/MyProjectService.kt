package com.github.barfurth.plasticjbide.services

import com.intellij.openapi.project.Project
import com.github.barfurth.plasticjbide.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
