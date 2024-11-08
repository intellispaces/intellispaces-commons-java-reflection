package intellispaces.common.javastatement.type;

import intellispaces.common.base.exception.NotImplementedExceptions;
import intellispaces.common.base.exception.UnexpectedExceptions;
import intellispaces.common.base.type.AbstractType;
import intellispaces.common.javastatement.reference.TypeReference;

import java.util.List;

class ReferenceBasedType<T> extends AbstractType<T> implements Type<T> {
  private final TypeReference base;
  private final List<TypeReference> qualifiers;

  ReferenceBasedType(TypeReference base, List<TypeReference> qualifiers) {
    this.base = base;
    this.qualifiers = qualifiers;
  }

  @Override
  public TypeReference typeReference() {
    if (qualifiers.isEmpty()) {
      return base;
    }
    throw NotImplementedExceptions.withCode("BrAAig");
  }

  @Override
  public TypeReference baseTypeReference() {
    return base;
  }

  @Override
  public List<TypeReference> qualifierTypeReferences() {
    return qualifiers;
  }

  @Override
  @SuppressWarnings("unchecked")
  public Class<T> baseClass() {
    if (base.isCustomTypeReference()) {
      return (Class<T>) base.asCustomTypeReferenceOrElseThrow().targetClass();
    } else {
      throw UnexpectedExceptions.withMessage("Unsupported reference type: {0}",
        base.statementType().typename());
    }
  }

  @Override
  @SuppressWarnings("unchecked, rawtypes")
  public List<intellispaces.common.base.type.Type<?>> qualifierTypes() {
    return (List) qualifiers.stream()
      .map(TypeBaseOnReferenceImpl::new)
      .toList();
  }
}
