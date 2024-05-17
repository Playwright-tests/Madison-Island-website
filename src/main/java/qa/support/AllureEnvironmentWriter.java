package qa.support;

import com.google.common.collect.ImmutableMap;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class AllureEnvironmentWriter {

    public static void setEnvironment() {

        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Available processors (core)", String.valueOf(Runtime.getRuntime().availableProcessors()))
                        .put("Maximum memory", String.valueOf(Runtime.getRuntime().maxMemory()))
                        .put("Total memory", String.valueOf(Runtime.getRuntime().totalMemory()))
                        .put("Free memory", String.valueOf(Runtime.getRuntime().freeMemory()))
                        .put("Operating system", System.getProperty("os.name") + " " + System.getProperty("os.arch"))
                        .put("Java runtime version", System.getProperty("java.runtime.version"))
                        .build(), System.getProperty("user.dir") + "/allure-results/"
        );
    }
}
