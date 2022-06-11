package io.adam.practices.compress;

import java.io.File;

/**
 * @author dcyu
 * @since 2021-03-23 22:02
 */
public class AbstractCompress {


    protected static void createDirectory (String outputDir, String subDir) {
        File file = new File(outputDir);
        if (!(subDir == null || "".equals(subDir))) {
            file = new File(outputDir + File.separator + subDir);
        }
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.mkdirs();
        }
    }
}
