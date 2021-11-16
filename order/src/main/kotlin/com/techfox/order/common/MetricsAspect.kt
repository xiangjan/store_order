package com.techfox.order.common

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import kotlin.jvm.Throws


@Aspect
@Component
class MetricsAOP {
    @Pointcut(value="execution(public * com.techfox.order.Controller.*.*(..))")
    fun withMetricsAnnotation() {}

    @Pointcut(value="execution(public * com.techfox.order.service.*.*(..))")
    fun withMetricsService() {}

    @Around(value = "withMetricsAnnotation() || withMetricsService()")
    @Throws(Throwable::class)
    fun metrics(pjp: ProceedingJoinPoint) {
        //sample AOP
        val signatureStr =  pjp.signature.toString();
        val start = System.currentTimeMillis()
        pjp.proceed()
        val executionTime = System.currentTimeMillis() - start
        println("${signatureStr} are processed excute time is ${executionTime}")
    }
}
