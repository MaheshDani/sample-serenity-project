package sample.project.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private static final Logger LOGGER = LoggerFactory.getLogger(Configuration.class);
    private static Properties configuration;
    private static Properties vaultConfig;

    static {
        initConfig();
    }

    public static String get(String string) {
        return configuration.getProperty(string);
    }

    public static String readCredentials(String propertyFile, String property) {
        Properties properties = new Properties();
        try {
            InputStream propertyFileInputStream = getClassPathResourceStream(propertyFile);
            loadProperties(properties, getClassPathResourceStream(propertyFile));
            propertyFileInputStream.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Could not load properties", e);
        } finally {
            vaultConfig = properties;
        }
        return vaultConfig.getProperty(property);
    }

    public static void initConfig() {
        String propertyFile = "properties/" + "default.properties";
        Properties localProperties = new Properties();
        try {
            InputStream propertyFileInputStream = getClassPathResourceStream(propertyFile);
            loadProperties(localProperties, getClassPathResourceStream(propertyFile));
            propertyFileInputStream.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException("Could not load properties", e);
        } finally {
            configuration = localProperties;
        }
    }

    private static void loadProperties(Properties props, InputStream inputStream) {
        try {
            props.load(inputStream);
        } catch (IOException ioexception) {
            LOGGER.error(ioexception.getMessage());
        }
    }

    public static InputStream getClassPathResourceStream(String classpathResourceLoc) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream(classpathResourceLoc);
    }
}
