package tech.intellispaces.commons.java.reflection.samples;

import tech.intellispaces.commons.java.reflection.support.TesteeType;

public class GenericClassWithCyclicTypeDependencyCase2 {

  @TesteeType
  public class ClassA<T1 extends ClassB<?>> {}

  public class ClassB<T2 extends ClassA<?>> {}
}
