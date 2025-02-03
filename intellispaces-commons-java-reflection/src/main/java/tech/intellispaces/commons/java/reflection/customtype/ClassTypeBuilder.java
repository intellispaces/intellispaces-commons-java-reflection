package tech.intellispaces.commons.java.reflection.customtype;

import tech.intellispaces.commons.java.reflection.instance.AnnotationInstance;
import tech.intellispaces.commons.java.reflection.method.MethodStatement;
import tech.intellispaces.commons.java.reflection.reference.CustomTypeReference;
import tech.intellispaces.commons.java.reflection.reference.NamedReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClassTypeBuilder {
  private boolean isAbstract = false;
  private boolean isFinal = false;
  private String canonicalName;
  private CustomType enclosingType;
  private List<AnnotationInstance> annotations = new ArrayList<>();
  private List<NamedReference> typeParameters = new ArrayList<>();
  private CustomTypeReference extendedClass = null;
  private List<CustomTypeReference> implementedInterfaces = new ArrayList<>();
  private List<MethodStatement> constructors = new ArrayList<>();
  private List<MethodStatement> declaredMethods = new ArrayList<>();

  public ClassTypeBuilder canonicalName(String canonicalName) {
    this.canonicalName = canonicalName;
    return this;
  }

  public ClassType get() {
    validate();
    return new ClassTypeImpl(
      isAbstract,
      isFinal,
      canonicalName,
      enclosingType,
      annotations,
      typeParameters,
      extendedClass,
      implementedInterfaces,
      constructors,
      declaredMethods
    );
  }

  private void validate() {
    Objects.requireNonNull(canonicalName);
  }
}
