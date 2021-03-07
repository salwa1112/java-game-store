package com.salwa.interceptor;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

@Inherited
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@InterceptorBinding
public @interface Logged {
}
