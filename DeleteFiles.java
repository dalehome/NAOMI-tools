package com.daleman;
 
import java.io.File;

/**
 *	Delete files older than a specified number of days - in this case
 * 	currently hardcoded at 5
 *
 * 	@author Dale � 2019
 *
 */
public class DeleteFiles {
 
    private static String srcPath = ".";
    private static int quantity = 0;
    private static String unit = "h";
    private static String fileExtension = "";
 
    public static void main(String[] args) {
        processArgs(args);
        System.out.println("This will run: DeleteFiles "+ srcPath + " " + quantity + " " + unit + " " + fileExtension);
        //DeleteFiles deleteFiles = new DeleteFiles();
        //deleteFiles.delete(5, ".jpg");
    }

    private static void processArgs(String[] lArgs) {
        
        if (lArgs.length >= 1 && lArgs[0].equals("-h")) {
            System.out.println("Syntax: DeleteFiles [path to delete] [+/- quantity] [unit] [file extension]");
            System.exit(1);
        }

        switch (lArgs.length) {
            case 5:
                System.out.println("Too many arguments");
                System.exit(1);
                break;
            case 4:
                fileExtension = lArgs[3];
            case 3:
                //TODO: possibly remove the try catch block
                try {
                    char c = lArgs[2].charAt(0);
                    switch (c) {
                        case 'd':
                        case 'D':
                            unit = "d";
                            break;
                        case 'h':
                        case 'H':
                            unit = "h";
                            break;
                        case 'm':
                        case 'M':
                            unit = "m";
                    }
                } catch (Exception e) {
                    System.out.println("Unit of time not specified in correct format!!");
                    System.exit(1);
                }
            case 2:
                try {
                    int i = Integer.parseInt(lArgs[1]);
                    quantity = i;
                } catch (Exception e) {
                    System.out.println("Quantity not specified in correct format!!");
                    System.exit(1);
                }
            case 1:
                srcPath = lArgs[0];
            case 0:
                // correct the args to a n empty string for full delete 
        }
    }
 
    public void delete(long days, String fileExtension) {
 
        File folder = new File(srcPath);
 
        if (folder.exists()) {
 
            File[] listFiles = folder.listFiles();
 
            long eligibleForDeletion = System.currentTimeMillis() -
                (days * 24 * 60 * 60 * 1000L);
 
            for (File listFile: listFiles) {
 
                if (listFile.getName().endsWith(fileExtension) &&
                    listFile.lastModified() < eligibleForDeletion) {
 
                    if (!listFile.delete()) {
 
                        System.out.println("Sorry Unable to Delete Files..");
 
                    }
                }
            }
        }
    }
}  
