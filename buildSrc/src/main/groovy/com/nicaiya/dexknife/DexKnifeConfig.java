package com.nicaiya.dexknife;

import org.gradle.api.tasks.util.PatternSet;

import java.util.Set;

public class DexKnifeConfig {
    PatternSet patternSet;
    PatternSet suggestPatternSet;
    boolean useSuggest = true;
    boolean filterSuggest = false;
    boolean logMainList = false;
    boolean logFilterSuggest = false;
    boolean logFilter = false;
    Set<String> additionalParameters;
}
