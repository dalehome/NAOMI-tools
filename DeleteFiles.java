package com.daleman;
 
import java.io.File;

/**
 *	Delete files older than a specified number of days - in this case
 * 	currently hardcoded at 5
 *
 * 	@author Dale © 2019
 *
 */
public class DeleteFiles {
 
    private String dirPath = "c:\\temp";
 
    public static void main(String[] args) {
        DeleteFiles deleteFiles = new DeleteFiles();
        deleteFiles.delete(5, ".jpg");
    }
 
    public void delete(long days, String fileExtension) {
 
        File folder = new File(dirPath);
 
        if (folder.exists()) {
 
            File[] listFiles = folder.listFiles();
 
            long eligibleForDeletion = System.currentTimeMillis() -
                (days * 24 * 60 * 60 * 1000 L);
 
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
