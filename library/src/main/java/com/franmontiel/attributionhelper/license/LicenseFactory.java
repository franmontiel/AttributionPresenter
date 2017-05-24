package com.franmontiel.attributionhelper.license;

public class LicenseFactory {

    public static License getLicense(LicenseType type) {
        switch (type) {
            case APACHE:
                return new License("Apache License 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
            case BSD_2:
                return new License("BSD-2-Clause", "https://opensource.org/licenses/BSD-2-Clause");
            case BSD_3:
                return new License("BSD-3-Clause", "https://opensource.org/licenses/BSD-3-Clause");
            case GPL_2:
                return new License("GPL-2.0", "http://www.gnu.org/licenses/old-licenses/gpl-2.0-standalone.html");
            case GPL_3:
                return new License("GPL-3.0", "http://www.gnu.org/licenses/gpl-3.0-standalone.html");
            case LGPL_2_1:
                return new License("LGPL-2.1", "http://www.gnu.org/licenses/old-licenses/lgpl-2.1-standalone.html");
            case LGPL_3:
                return new License("LGPL-3.0", "http://www.gnu.org/licenses/lgpl-3.0-standalone.html");
            case MIT:
                return new License("MIT License", "https://opensource.org/licenses/MIT");
            default:
                return new License("", "");
        }
    }

}
