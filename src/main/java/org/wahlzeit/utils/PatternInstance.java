package org.wahlzeit.utils;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
@Repeatable(MultiplePatternInstances.class)
public @interface PatternInstance {
    String patternName();
    String[] participants();
}
