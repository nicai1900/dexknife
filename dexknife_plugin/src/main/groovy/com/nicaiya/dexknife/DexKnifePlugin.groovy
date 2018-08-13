package com.nicaiya.dexknife

import org.gradle.api.Plugin
import org.gradle.api.Project

class DexKnifePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {

        project.getTasks().create("hello", {
            System.out.println("Hello")
        })

    }
}