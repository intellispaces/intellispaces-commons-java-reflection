package tech.intellispaces.commons.java.reflection.instance;

import tech.intellispaces.commons.java.reflection.reference.TypeReference;

import java.util.List;

public interface ArrayInstances {

  static ArrayInstance of(TypeReference elementTypeReference, List<Instance> elements) {
    return new ArrayInstanceImpl(elementTypeReference, elements);
  }
}
