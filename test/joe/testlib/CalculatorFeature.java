package joe.testlib;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.testing.features.Feature;
import com.google.common.collect.testing.features.TesterAnnotation;

@SuppressWarnings("unchecked")
public enum CalculatorFeature implements Feature<Calculator> {
	POSITIVE_NUMBERS,
	NEGATIVE_NUMBERS,
	ANY_SIGN(NEGATIVE_NUMBERS, POSITIVE_NUMBERS),
	
	INTEGER_PARAMETERS,
	FLOATING_POINT_PARAMETERS,
	ANY_TYPE(INTEGER_PARAMETERS, FLOATING_POINT_PARAMETERS),
	
	ADDITION,
	MULTIPLICATION,
	ANY_OPERATION(ADDITION, MULTIPLICATION),
	
  GENERAL_PURPOSE(ANY_SIGN, ANY_TYPE, ANY_OPERATION),
  ;

  private final Set<Feature<? super Calculator>> implied;

  CalculatorFeature(Feature<? super Calculator> ... implied) {
    this.implied = ImmutableSet.copyOf(implied);
  }

  @Override
  public Set<Feature<? super Calculator>> getImpliedFeatures() {
    return implied;
  }

  @Retention(RetentionPolicy.RUNTIME)
  @Inherited
  @TesterAnnotation
  public @interface Require {
    public abstract CalculatorFeature[] value() default {};
    public abstract CalculatorFeature[] absent() default {};
  }
}