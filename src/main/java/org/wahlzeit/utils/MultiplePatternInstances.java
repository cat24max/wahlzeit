package org.wahlzeit.utils;

import java.lang.annotation.*;

@Retention(RetentionPolicy.SOURCE)
public @interface  MultiplePatternInstances {
    PatternInstance[] value();
}
