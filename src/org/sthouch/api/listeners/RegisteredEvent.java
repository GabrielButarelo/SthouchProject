package org.sthouch.api.listeners;

import java.lang.annotation.*;

@Target({java.lang.annotation.ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RegisteredEvent {}