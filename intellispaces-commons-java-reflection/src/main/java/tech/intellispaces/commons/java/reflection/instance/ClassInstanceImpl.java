package tech.intellispaces.commons.java.reflection.instance;

import tech.intellispaces.commons.java.reflection.StatementType;
import tech.intellispaces.commons.java.reflection.StatementTypes;
import tech.intellispaces.commons.java.reflection.customtype.CustomType;

class ClassInstanceImpl implements ClassInstance {
  private final CustomType type;

  ClassInstanceImpl(CustomType type) {
    this.type = type;
  }

  @Override
  public StatementType statementType() {
    return StatementTypes.ClassInstance;
  }

  @Override
  public CustomType type() {
    return type;
  }

  @Override
  public String prettyDeclaration() {
    return type.canonicalName() + ".class";
  }
}
