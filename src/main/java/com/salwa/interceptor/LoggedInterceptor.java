package com.salwa.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@Logged
public class LoggedInterceptor implements Serializable {

    @AroundInvoke
    public Object logEntryToTheMethod(InvocationContext ctx) throws Exception {
        System.out.println("Method " + ctx.getMethod() + " was called");
        Object result = ctx.proceed();
        // Log to console after executing method
        System.out.println("Leaving method: " + ctx.getMethod().getName() );
        return result;
    }
}
