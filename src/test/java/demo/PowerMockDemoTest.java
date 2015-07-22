package demo;

import java.io.File;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @author chenguangjian
 *
 */
@RunWith(PowerMockRunner.class)
public class PowerMockDemoTest {
    /**
     * Test method for
     * {@link demo.PowerMockDemo#callArgumentInstance(java.io.File)}.
     */
    @Test
    public void testCallArgumentInstance() {
        File file = PowerMockito.mock(File.class);
        PowerMockDemo underTest = new PowerMockDemo();
        PowerMockito.when(file.exists()).thenReturn(true);
        assertTrue(underTest.callArgumentInstance(file));
    }

    /**
     * Test method for
     * {@link demo.PowerMockDemo#callInternalInstance(java.lang.String)}.
     * 
     * @throws Exception
     */
    @Test
    @PrepareForTest(PowerMockDemo.class)
    public void testCallInternalInstance() throws Exception {
        File file = PowerMockito.mock(File.class);
        PowerMockDemo underTest = new PowerMockDemo();
        PowerMockito.whenNew(File.class).withArguments("bbb").thenReturn(file);
        PowerMockito.when(file.exists()).thenReturn(true);
        assertTrue(underTest.callInternalInstance("bbb"));
    }

    /**
     * Test method for
     * {@link demo.PowerMockDemo#callFinalMethod(demo.ClassDependency)}.
     */
    @Test
    @PrepareForTest(ClassDependency.class)
    public void testCallFinalMethod() {
        ClassDependency depencency = PowerMockito.mock(ClassDependency.class);
        PowerMockDemo underTest = new PowerMockDemo();
        PowerMockito.when(depencency.isFinal()).thenReturn(true);
        assertTrue(underTest.callFinalMethod(depencency));
    }

    /**
     * Test method for {@link demo.PowerMockDemo#callStaticMethod()}.
     */
    @Test
    @PrepareForTest(ClassDependency.class)
    public void testCallStaticMethod() {
        PowerMockDemo underTest = new PowerMockDemo();
        PowerMockito.mockStatic(ClassDependency.class);
        PowerMockito.when(ClassDependency.isStatic()).thenReturn(true);
        assertTrue(underTest.callStaticMethod());
    }

    /**
     * Test method for {@link demo.PowerMockDemo#callPrivateMethod()}.
     * 
     * @throws Exception
     */
    @Test
    @PrepareForTest(PowerMockDemo.class)
    public void testCallPrivateMethod() throws Exception {
        PowerMockDemo underTest = PowerMockito.mock(PowerMockDemo.class);
        PowerMockito.when(underTest.callPrivateMethod()).thenCallRealMethod();
        PowerMockito.when(underTest, "isPrivate").thenReturn(true);
        assertTrue(underTest.callPrivateMethod());

    }

    /**
     * Test method for
     * {@link demo.PowerMockDemo#callSystemFinalMethod(java.lang.String)}.
     */
    @Test
    @PrepareForTest(PowerMockDemo.class)
    public void testCallSystemFinalMethod() {
        PowerMockDemo underTest = new PowerMockDemo();
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getProperty("aaa")).thenReturn("bbb");
        assertEquals(false, underTest.callSystemFinalMethod("aaa"));
    }

    /**
     * Test method for
     * {@link demo.PowerMockDemo#callSystemStaticMethod(java.lang.String)}.
     */
    @Test
    public void testCallSystemStaticMethod() {
        PowerMockDemo underTest = new PowerMockDemo();
        PowerMockito.mockStatic(System.class);
        PowerMockito.when(System.getProperty("aaa")).thenReturn("bbb");
        assertEquals("bbb", underTest.callSystemStaticMethod("aaa"));
        // assertNull(underTest.callSystemStaticMethod("aaa"));

    }

}
