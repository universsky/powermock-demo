/**
 * 
 */
package demo;

import java.io.File;

/**
 * @author chenguangjian
 *
 */
public class PowerMockDemo {
    /**
     * (1) 普通Mock： Mock参数传递的对象
     * 
     * @param file
     * @return
     */
    public boolean callArgumentInstance(File file) {
        return file.exists();
    }

    /**
     * (2) Mock方法内部new出来的对象
     * 
     * @param path
     * @return
     */
    public boolean callInternalInstance(String path) {
        File file = new File(path);
        return file.exists();

    }

    /**
     * (3) Mock普通对象的final方法
     * 
     * @param refer
     * @return
     */
    public boolean callFinalMethod(ClassDependency refer) {
        return refer.isFinal();
    }

    /**
     * (4) Mock普通类的静态方法
     * 
     * @return
     */
    public boolean callStaticMethod() {
        return ClassDependency.isStatic();
    }

    /**
     * (5) Mock 私有方法
     * 
     * @return
     */
    public boolean callPrivateMethod() {
        return isPrivate();
    }

    /**
     * (6) Mock系统类的final方法
     * 
     * @param str
     * @return
     */
    public boolean callSystemFinalMethod(String str) {
        return str.isEmpty();
    }

    /**
     * (6) Mock系统类的静态方法
     * 
     * @param str
     * @return
     */
    public String callSystemStaticMethod(String str) {
        return System.getProperty(str);
    }

    private boolean isPrivate() {
        return false;
    }

    public static void main(String[] args) {
        String cs = new PowerMockDemo().callSystemStaticMethod("aaa");
        System.out.println(cs);
    }
}

class ClassDependency {
    public final boolean isFinal() {
        // do something
        return true;
    }

    public static boolean isStatic() {
        // do something
        return true;
    }

}
