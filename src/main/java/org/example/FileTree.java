package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class FileTree {

    public static void main(String[] args) throws IOException {
        String path = args.length > 0 ? args[0] : ".";
        new FileTree().print(path);
    }

    private void print(String path) {
        int originalPathDepth = Path.of(path).getNameCount();
        System.out.println("Contents of " + path);
        Statistics statistics = printFileDirectory(path, originalPathDepth);
        System.out.println();
        System.out.println("\n" + statistics.numberOfDirectories + " Directories " + statistics.numberOfFiles + " Files");
    }

    static class Statistics {
        int numberOfDirectories;
        int numberOfFiles;

        public void add(Statistics statistics) {
            this.numberOfDirectories += statistics.numberOfDirectories;
            this.numberOfFiles += statistics.numberOfFiles;
        }

    }

    private Statistics printFileDirectory(String path, int pathDepth) {
        Statistics statistics = new Statistics();
        String[] filesAndDirectories = new File(path).list();
        if (filesAndDirectories == null) throw new RuntimeException("File path is invalid");
        for (String fileOrDirectoryName : filesAndDirectories) {
            int currentPathDepth = Path.of(path).getNameCount() - pathDepth;
            if (currentPathDepth != 0) {
                System.out.print("|");
            }
            File fileOrDirectory = new File(path, fileOrDirectoryName);
            System.out.println("    ".repeat(currentPathDepth) + "|-- " + fileOrDirectoryName);

            if (fileOrDirectory.isDirectory()) {
                statistics.numberOfDirectories++;
                statistics.add(printFileDirectory(fileOrDirectory.getPath(), pathDepth));
            } else {
                statistics.numberOfFiles++;
            }
        }
        return statistics;
    }
}
