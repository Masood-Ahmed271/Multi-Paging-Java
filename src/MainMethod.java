import java.util.Scanner;

import PagingStatistical.PagingStatisticalProcessor;

public class MainMethod {

    public static void PagingStatistical() {
        long physicalMemorySize = 0, pageSize, programSizeInBytes;
        int pageOffsetNumOfBits, part1Choice;
        Scanner scanner = new Scanner(System.in);
        String virtualAddress;
        System.out.println("Part 1 is activated!");
        System.out.println("Please enter the physical memory size in bytes: ");
        physicalMemorySize = scanner.nextLong();

        System.out.println("Please enter the page size in bytes: ");
        pageSize = Integer.parseInt(System.console().readLine());

        System.out.println("Please enter number of bits for the page offset of the virtual address: ");
        pageOffsetNumOfBits = Integer.parseInt(System.console().readLine());

        PagingStatisticalProcessor pagingStatisticalProcessor = new PagingStatisticalProcessor(
                physicalMemorySize, pageSize, pageOffsetNumOfBits);

        System.out.println(
                "Now enter your choice: \n\t- Enter 1 to print some statistics about the paging design. \n\t- Enter 2 to print some information about a given program specs\n\t- Enter 3 to print some information about a given virtual address. ");
        part1Choice = Integer.parseInt(System.console().readLine());
        switch (part1Choice) {
            case 1:
                pagingStatisticalProcessor.PrintStatisticalInformation();
            case 2:
                System.out.println("Please enter the size of the program in bytes: ");
                programSizeInBytes = Integer.parseInt(System.console().readLine());
                pagingStatisticalProcessor.PrintInformationAboutAProgram(programSizeInBytes);
                break;
            case 3:
                System.out.println("Please enter a valid virtual address: ");
                virtualAddress = System.console().readLine();
                pagingStatisticalProcessor.PrintInformationAboutAVirtualAddress(virtualAddress);
                break;
            default:
                break;
        }
    }


    public static void main(String[] args) {
        int partChoice = 0;

        do {
            System.out.println(
                    "Please enter your choice: \n\t- Enter 1 for start the program 1.\n\t- and Enter 0 to exit. ");
            partChoice = Integer.parseInt(System.console().readLine());
            switch (partChoice) {
                case 1:
                    PagingStatistical();
                    break;
                default:
                    break;
            }
        } while (partChoice != 0);
        System.out.println("The end of the simulation...");
    }
}
