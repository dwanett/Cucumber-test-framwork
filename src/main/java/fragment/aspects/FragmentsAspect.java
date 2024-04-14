package fragment.aspects;

import fragment.FragmentReplacer;
import fragment.GherkinSerializer;
import io.cucumber.core.gherkin.Feature;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
public class FragmentsAspect {

    /**
     * замена фрагментов и данных в фиче
     *
     * @param features  список фич
     * @param assertion assert
     * @return список фич
     * @throws IOException
     * @throws IllegalAccessException
     */
    public static List<Feature> replaceSteps(List<Feature> features, Assertions assertion) throws IOException, IllegalAccessException {
        features = features.stream()
                .filter(cucumberFeature -> cucumberFeature.getSource() != null)
                .collect(Collectors.toList());

        FragmentReplacer fragmentReplacer = new FragmentReplacer(features, assertion);
        fragmentReplacer.replace();
        features = new GherkinSerializer().reserializeFeatures(features, assertion);
        return features;
    }

    @Pointcut("execution(* io.cucumber.core.resource.ResourceScanner.scanForResourcesUri(..))")
    public void cucumberFeaturesScanner() {
    }


    /**
     * тут используется строгий assert
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */

    @Around("cucumberFeaturesScanner()")
    public Object replaceStepsScanner(ProceedingJoinPoint joinPoint) throws Throwable {
        return replaceSteps((List<Feature>) joinPoint.proceed(), null);
    }
}
