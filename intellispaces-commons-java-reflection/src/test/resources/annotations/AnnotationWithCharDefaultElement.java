package tech.intellispaces.commons.java.reflection.samples;

import tech.intellispaces.commons.java.reflection.support.TesteeType;

@TesteeType
public @interface AnnotationWithCharDefaultElement {

  char charElementDefault() default 'a';
}