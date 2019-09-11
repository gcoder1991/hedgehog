package org.ek.hedgehog.util;

public class SystemUtils {

    public static boolean getOSMatches(String osNamePrefix) {
        String os = System.getProperty("os.name");

        if (os == null) {
            return false;
        }
        return os.startsWith(osNamePrefix);
    }

    public static boolean isLinux() {
        return getOSMatches("Linux") || getOSMatches("LINUX");
    }

}
