package cz.uhk.fim.ppro.aop;

import cz.uhk.fim.ppro.model.Zlomek;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Aspekty pro kalulacku
 */
@Aspect
@Component
public class KalkulackaAspect {

    @Autowired
    private Logger logger;

    @Pointcut("execution(* cz.uhk.fim.ppro.tools.Kalkulacka.*(..))")
    public void vsechnyMetody() {
    }

    @Before("vsechnyMetody()")
    public void predMetodou(JoinPoint joinPoint) {
        logger.debug("Pred volanim metody {}", joinPoint.getSignature().getName());
        logger.debug("\tVstupy: ");
        Arrays.stream(joinPoint.getArgs()).map(Object::toString).forEach(logger::debug);
    }

    @AfterReturning(pointcut = "vsechnyMetody()", returning = "zlomek")
    public void poMetode(JoinPoint joinPoint, Zlomek zlomek) {
        logger.debug("Po navratu z metody {}", joinPoint.getSignature().getName());
        logger.debug("\tVysledek: {}", zlomek.toString());
    }

    @AfterThrowing(pointcut = "vsechnyMetody()", throwing = "ex")
    public void poChybe(JoinPoint joinPoint, IllegalArgumentException ex) {
        logger.error("Po chybe v metode {}", joinPoint.getSignature().getName());
        logger.error("\tChyba: {}", ex.getMessage());
    }

}
