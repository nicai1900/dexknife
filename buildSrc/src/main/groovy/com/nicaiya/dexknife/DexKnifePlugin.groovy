package com.nicaiya.dexknife

import org.gradle.api.Plugin
import org.gradle.api.Project


public class DexKnifePlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.afterEvaluate {
            for (variant in project.android.applicationVariants) {
                dexKnifeProcessVariant(project, variant)
            }
        }
    }

    public static void dexKnifeProcessVariant(Project project, variant) {
        println("DexKnife: Processing Variant")

        if (isMultiDexEnabled(variant)) {
            if (SplitToolsFor311.isCompat()) {
                SplitToolsFor311.processSplitDex(project, variant)
            } else {
                System.err.println("DexKnife Error: DexKnife is not compatible your Android gradle plugin.")
            }
        } else {
            System.err.println("DexKnife : MultiDexEnabled is false, it's not work.")
        }
    }

    public static boolean isMultiDexEnabled(variant) {
        def is = variant.buildType.multiDexEnabled
        if (is != null) {
            return is
        }

        is = variant.mergedFlavor.multiDexEnabled
        if (is != null) {
            return is
        }

        return false
    }

}