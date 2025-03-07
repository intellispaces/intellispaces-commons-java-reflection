package tech.intellispaces.commons.java.reflection.customtype;

import tech.intellispaces.commons.java.reflection.method.MethodStatement;
import tech.intellispaces.commons.java.reflection.reference.CustomTypeReference;

import java.util.List;
import java.util.Optional;

/**
 * The class type.
 */
public interface ClassType extends CustomType {

  List<MethodStatement> constructors();

  /**
   * Extended class references.
   */
  Optional<CustomTypeReference> extendedClass();

  /**
   * Implemented interface references.
   */
  List<CustomTypeReference> implementedInterfaces();

  @Override
  default Optional<ClassType> asClass() {
    return Optional.of(this);
  }

  /**
   * Connected custom type.
   */
  default CustomType asCustomType() {
    return this;
  }
}
