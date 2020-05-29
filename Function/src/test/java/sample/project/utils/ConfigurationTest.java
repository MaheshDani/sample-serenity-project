package sample.project.utils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

@PowerMockIgnore({"javax.net.ssl.*", "javax.security.*", "javax.management.*"})
@RunWith(PowerMockRunner.class)
@PrepareForTest(Configuration.class)
public class ConfigurationTest {
    private Logger logger = LoggerFactory.getLogger(ConfigurationTest.class);
    private Properties mockProperties;

    @Before
    public void setUp() {
        mockProperties = mock(Properties.class);
        mockProperties.setProperty("test.user", "CTF_user");
    }

    @Test
    public void testGetProperties() {
        PowerMockito.mockStatic(Configuration.class);
        when(mockProperties.getProperty("test.user")).thenReturn("CTF_user");
        assertThat("testGetProperties()", mockProperties.getProperty("test.user"), is("CTF_user"));
    }

    @Test
    public void testReadCredentials() {
        String propertyFile = "properties/default.properties";
        assertThat("testReadCredentials()",
                Configuration.readCredentials(propertyFile, "test.user"), is("CTF_user"));
    }
}
