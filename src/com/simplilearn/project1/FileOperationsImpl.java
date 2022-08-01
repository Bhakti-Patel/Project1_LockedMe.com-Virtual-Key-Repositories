package com.simplilearn.project1;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileOperationsImpl implements FileOperationsInterface {

	@Override
	public void displayFileNames() {

		System.out.println("****************************************************");
		System.out.println("Program to display filenames in Ascending order\n");
		System.out.println("****************************************************");

		// logic to get the fileNames in Ascending Order
		File fileDir = new File("main");
		if (fileDir.isDirectory()) {

			List<String> listFile = Arrays.asList(fileDir.list());
			if (listFile.isEmpty()) {

				System.out.println("There are no files in the Directory. \n");
			} else {
				System.out.println("Listing the Files in unsorted order: \n");
				for (String s : listFile) {
					System.out.println(s);
				}
				Collections.sort(listFile);
				System.out.println("The file names in Ascending order:\n");

				for (String s : listFile) {

					System.out.println(s);
				}
			}
		} else {

			System.out.println("The Directory " + fileDir.getAbsolutePath() + "does not exist");
		}

	}

	@Override
	public void addFile() {

		System.out.println("****************************************************");
		System.out.println("Program to add a user specified File ");
		System.out.println("****************************************************");

		try {
			System.out.println("Enter the file to be added in the directory alongwith the file extension ");
			Scanner sc = new Scanner(System.in);
			String filename = sc.next();
			File file = new File("main", filename);
			// if file does not exist create it
			if (!file.exists()) {

				file.createNewFile();
				System.out.println("File " + file.getName()+" created at the location "+file.getAbsolutePath());

			} else
				System.out.println("File already exists.");
		} catch (IOException e) {
			System.out.println("An error occurred while creating the file");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteFile() {

		System.out.println("****************************************************");
		System.out.println("Program to delete a user specified File ");
		System.out.println("****************************************************");

		try {
			File directory = new File("main");
			System.out.println("Enter the file to be deleted alongwith with the file extension");
			Scanner sc = new Scanner(System.in);
			String fileName = sc.next();
			String[] fileList = directory.list();
			Boolean fileFound = Boolean.FALSE;
			if (fileList != null) {
				for (int i = 0; i < fileList.length; i++) {

					String fileInDir = fileList[i];
					if (fileInDir.equals(fileName)) {
						fileFound = Boolean.TRUE;
						File file = new File("main", fileInDir);
						if (file.delete()) {
							System.out.println("File " + fileInDir + " deleted successfully from the location "+directory.getAbsolutePath());
						}
					}

				}
				if (!fileFound) {
					System.out.println("File ::" + fileName + " not Found ");
				}
			} else {
				System.out.println("The directory main is empty");
			}

		} catch (Exception e) {
			System.out.println("An error occured while deleting the file");
			e.printStackTrace();
		}
	}

	@Override
	public void searchFiles() {

		System.out.println("****************************************************");
		System.out.println("Program to Search a user specified File ");
		System.out.println("****************************************************");
		Scanner sc = new Scanner(System.in);
		try {

			System.out.println("Enter the filename to be searched alongwith the extension");
			File directory = new File("main");
			String usrFileName = sc.next();

			String[] flist = directory.list();
			int flag = 0;
			if (flist == null) {
				System.out.println("Empty directory.");
			} else {

				// Linear search in the array
				for (int i = 0; i < flist.length; i++) {
					String filename = flist[i];
					if (filename.equals(usrFileName)) {
						System.out.println(filename + " found " + "at the location:" + directory.getAbsolutePath());
						flag = 1;
					}
				}
			}

			if (flag == 0) {
				System.out.println("File Not Found at the location "+directory.getAbsolutePath());
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
