package edu.csus.ecs.pc2.core;

import java.io.File;
import java.net.MalformedURLException;

import edu.csus.ecs.pc2.core.util.JUnitUtilities;

import junit.framework.TestCase;

/**
 * This class exists to check functionality
 * of the Ini class.
 */
public class IniTest extends TestCase {
    private String loadFile = "pc2v9.ini";
    protected void setUp() throws Exception {
        String projectPath=JUnitUtilities.locate(loadFile);
        if (projectPath == null) {
            throw new Exception("Unable to locate "+loadFile);
        }
        File dir = new File(projectPath + File.separator + loadFile);
        if (dir.exists()) {
            loadFile = dir.toString();
        } else {
            System.err.println("could not find " + loadFile);
            throw new Exception("Unable to locate "+loadFile);
        }
    }

    /**
     * This is a test for bug 197
     */
    public void testOne() {
        Ini ini = new Ini();
        try {
            ini.setIniURLorFile(loadFile);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            assertNotNull("exception",null);
        }
        assertTrue("_source defined", ini.containsKey("_source"));
    }
}
