package com.simplilearn.project1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LockedMeDemo {

	public static void main(String args[]) {

		welcomePage();

		FileOperationsImpl bo = new FileOperationsImpl();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int choice;

		while (flag) {
			try {
				displayMainMenu();
				choice = sc.nextInt();

				switch (choice) {
				case 1:

					bo.displayFileNames();
					break;

				case 2:

					int ch;
					try {
						boolean flag1 = true;
						while (flag1) {
							displaySubMenu();
							ch = sc.nextInt();
							switch (ch) {
							case 1:

								bo.addFile();
								break;

							case 2:

								bo.deleteFile();
								break;

							case 3:
								bo.searchFiles();
								break;

							case 4:

								System.out.println("Exiting from the File Handling Operations Menu..........\n");
								flag1 = false;
								break;

							default:
								System.out.println("Invalid choice: " + ch);
							}
						}
					} catch (InputMismatchException e) {

						System.out.println("Invalid choice: ");
						sc.nextLine();
						

					}

					break;

				case 3:
					System.out.println("Exiting from the Application...........\n");
					flag = false;
					sc.close();
					System.exit(0);
					break;

				default:
					System.out.println("Invalid Input value: " + choice);
				}

			} catch (InputMismatchException e) {

				System.out.println("Invalid choice: ");
				sc.nextLine();
				
			}

		}

	}

	public static void welcomePage() {

		System.out.println("Application Name : LockedMe.com ");
		System.out.println("Developer Details : Bhakti Patel \n");

	}

	public static void displaySubMenu() {

		System.out.println("####################################################");
		System.out.println("File Handling Operations");
		System.out.println("####################################################");

		System.out.println("1. Add a user specified file to the application \n");
		System.out.println("2. Delete a user specified file from the application \n");
		System.out.println("3. Search a user specified file from the application \n");
		System.out.println("4. Close the Business Level Operations Menu and return to the Main Menu \n");
		System.out.println("####################################################");
		System.out.println("Enter your choice : \n");


	}

	public static void displayMainMenu() {

		System.out.println("####################################################");
		System.out.println("Main Menu");
		System.out.println("####################################################");
		System.out.println("1.Display the current file names in ascending order \n");
		System.out.println("2.File Handling Operations \n");
		System.out.println("3.Exit the application \n");
		System.out.println("####################################################");
		System.out.println("Enter your choice : \n");


	}

}
