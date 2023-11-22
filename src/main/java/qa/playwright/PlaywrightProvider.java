package qa.playwright;

import org.reflections.Reflections;
import qa.enums.Browser;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class PlaywrightProvider {

    public static PlaywrightBrowserLauncher get(Browser browser) {

        String launcherPackage = PlaywrightBrowserLauncher.class.getPackage().getName();

        Reflections reflections = new Reflections(launcherPackage);

        Set<Class<? extends PlaywrightBrowserLauncher>> factories = reflections.getSubTypesOf(PlaywrightBrowserLauncher.class);

        Class<? extends PlaywrightBrowserLauncher> launcherClass = factories
                .stream()
                .filter(x -> x.getName().toLowerCase().contains(browser.getName().toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Did not find class with name " + browser));

        String launcherClassName = launcherClass.getName();

        try {

            return (PlaywrightBrowserLauncher) Class.forName(launcherClassName).getConstructor().newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 InvocationTargetException | NoSuchMethodException e) {

            throw new IllegalStateException(e);
        }
    }
}
