package sample.project.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AnilK on 10/04/2019.
 */
@RunWith(PowerMockRunner.class)
public class ValidateStructure {
    private Logger logger = LoggerFactory.getLogger(ValidateStructure.class);

    @Test
    public void ctsUtilsConfigurationExists() {
        try {
            Class.forName(ClassNames.CONFIGURATION.getClassName());
        } catch (ClassNotFoundException e) {
            Assert.fail("Should have class called " + ClassNames.CONFIGURATION.getClassName());
        }
    }

    @Test
    public void ctsUtilsDriverExists() {
        try {
            Class.forName(ClassNames.DRIVER.getClassName());
        } catch (ClassNotFoundException e) {
            Assert.fail("Should have class called " + ClassNames.DRIVER.getClassName());
        }
    }
}
