package intellispaces.common.javastatement.samples;

import intellispaces.common.javastatement.support.TesteeType;

@TesteeType
public @interface AnnotationWithArrayOfAnnotationElement {

  TestAnnotation[] arrayOfAnnotationElement();
}