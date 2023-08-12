package com.api.assessment.framework.pattern;

@FunctionalInterface
public interface Translator<I, O> {

    O to(final I input);

}
