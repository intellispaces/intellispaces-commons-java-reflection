package tech.intellispaces.javastatements.reference;

import tech.intellispaces.actions.Actions;
import tech.intellispaces.actions.Getter;
import tech.intellispaces.javastatements.StatementType;
import tech.intellispaces.javastatements.StatementTypes;
import tech.intellispaces.javastatements.common.JavaModelFunctions;
import tech.intellispaces.javastatements.context.TypeContext;
import tech.intellispaces.javastatements.session.Session;

import java.util.Map;
import java.util.Optional;

/**
 * Adapter of {@link javax.lang.model.type.WildcardType} to {@link WildcardReference}.
 */
class WildcardTypeReferenceBasedOnWildcardReference extends AbstractTypeReference implements WildcardReference {
  private final Getter<Optional<TypeReferenceBound>> extendedBoundGetter;
  private final Getter<Optional<TypeReferenceBound>> superBoundGetter;

  WildcardTypeReferenceBasedOnWildcardReference(javax.lang.model.type.WildcardType wildcardType, TypeContext typeContext, Session session) {
    super();
    this.extendedBoundGetter = Actions.cachedLazyGetter(JavaModelFunctions::getExtendedBound, wildcardType, typeContext, session);
    this.superBoundGetter = Actions.cachedLazyGetter(JavaModelFunctions::getSuperBound, wildcardType, typeContext, session);
  }

  @Override
  public StatementType statementType() {
    return StatementTypes.WildcardReference;
  }

  @Override
  public Optional<TypeReferenceBound> extendedBound() {
    return extendedBoundGetter.get();
  }

  @Override
  public Optional<TypeReferenceBound> superBound() {
    return superBoundGetter.get();
  }

  @Override
  public TypeReference specify(Map<String, NotPrimitiveTypeReference> typeMapping) {
    TypeReferenceBound extendedBound = extendedBound().orElse(null);
    if (extendedBound != null) {
      extendedBound = (TypeReferenceBound) extendedBound.specify(typeMapping);
    }
    TypeReferenceBound superBound = superBound().orElse(null);
    if (superBound != null) {
      superBound = (TypeReferenceBound) superBound.specify(typeMapping);
    }
    return new WildcardReferenceImpl(extendedBound, superBound);
  }
}
