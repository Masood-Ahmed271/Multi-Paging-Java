// Description: This is a program which finds statistics for multi-paging in OS.
// Note: The input is in whole numbers. It is not in the form of 2^32, but it is in the form of 4294967296

package PagingStatistical;

public class PagingStatisticalProcessor {
    private long physicalMemorySize;
    private long pageSize;
    private int pageOffsetNumOfBits;

    public PagingStatisticalProcessor() {
        super();
    }

    public PagingStatisticalProcessor(long physicalMemorySize, long pageSize, int pageOffsetNumOfBits) {
        super();
        this.physicalMemorySize = physicalMemorySize;
        this.pageSize = pageSize;
        this.pageOffsetNumOfBits = pageOffsetNumOfBits;
    }

    public void PrintStatisticalInformation() {

        //  formula to calculate total number of frames =  physicalMemorySize / pageSize
        long numOfFrames = physicalMemorySize / pageSize;
        System.out.println("Number of frames: " + numOfFrames); 

        long numOfPages = numOfFrames;
        int entriesInPageTable = (int) Math.pow(2, pageOffsetNumOfBits);
        double numberOfPagingLevels = (Math.log(numOfPages) / Math.log(entriesInPageTable));
        int roundedNumberOfPagingLevels = (int) Math.ceil(numberOfPagingLevels);
        System.out.println("Number of paging levels: " + roundedNumberOfPagingLevels); 


        int numberOfBitsInVirtualAddress = (int) (Math.log(physicalMemorySize) / Math.log(2));
        int numberOfBitsForPageNumber = numberOfBitsInVirtualAddress - pageOffsetNumOfBits;
        int numberOfBitsToAccessEachLevel = numberOfBitsForPageNumber / roundedNumberOfPagingLevels;
        System.out.println("Number of bits required to access each page table level: " + numberOfBitsToAccessEachLevel); 

        int entriesInPageTableInEachPagingLevel = (int) Math.pow(2, numberOfBitsToAccessEachLevel);
        System.out.println("Number of entries in the page table at each paging level: " + entriesInPageTableInEachPagingLevel);

        int entriesPageTable = (int) Math.pow(2, numberOfBitsToAccessEachLevel);
        int sizeOfVirtualAddress = numberOfBitsInVirtualAddress / 8;
        int sizeOfPageTable = entriesPageTable * sizeOfVirtualAddress;
        System.out.println("Size in bytes of the page table at each paging level: " + sizeOfPageTable); 

    }

    public void PrintInformationAboutAProgram(long programSizeInBytes) {

        long numOfPages = physicalMemorySize / pageSize;
        int entriesPageTable = (int) Math.pow(2, pageOffsetNumOfBits);
        double numberOfPagingLevels = (Math.log(numOfPages) / Math.log(entriesPageTable));
        int roundedNumberOfPagingLevels = (int) Math.ceil(numberOfPagingLevels);

        int numberOfPages = (int) Math.ceil((double) programSizeInBytes / pageSize);

        int numberOfBitsInVirtualAddress = (int) (Math.log(physicalMemorySize) / Math.log(2));
        int numberOfBitsForPageNumber = numberOfBitsInVirtualAddress - pageOffsetNumOfBits;
        int numberOfBitsToAccessEachLevel = numberOfBitsForPageNumber / roundedNumberOfPagingLevels;
        int entriesInPageTable = (int) Math.pow(2, numberOfBitsToAccessEachLevel);

        int totalPageTables = 0;

        for (int i = 0; i < numberOfPagingLevels; i++) {
            if (i == 0) {
                totalPageTables += 1;
            } else {
                totalPageTables += (int) Math.ceil((double) numberOfPages / Math.pow(entriesInPageTable, i - 1));
            }
        }

        System.out.println("Number of pages required for the program: " + numberOfPages);
        System.out.println("Number of page tables required to map the program to physical memory: " + totalPageTables); 
    }


    

    public void PrintInformationAboutAVirtualAddress(String virtualAddress) {
     
        long numOfPages = physicalMemorySize / pageSize;
        int entriesPageTable = (int) Math.pow(2, pageOffsetNumOfBits);
        double numberOfPagingLevels = (Math.log(numOfPages) / Math.log(entriesPageTable));
        int roundedNumberOfPagingLevels = (int) Math.ceil(numberOfPagingLevels);

        int numberOfBitsInVirtualAddress = (int) (Math.log(physicalMemorySize) / Math.log(2));
        int numberOfBitsForPageNumber = numberOfBitsInVirtualAddress - pageOffsetNumOfBits;
        int numberOfBitsToAccessEachLevel = numberOfBitsForPageNumber / roundedNumberOfPagingLevels;

        String[] parts = new String[roundedNumberOfPagingLevels + 1];
        for (int i = 0; i < roundedNumberOfPagingLevels; i++) {
            int startIndex = i * numberOfBitsToAccessEachLevel;
            int endIndex = startIndex + numberOfBitsToAccessEachLevel;
            parts[i] = virtualAddress.substring(startIndex, endIndex);
        }
        parts[roundedNumberOfPagingLevels] = virtualAddress.substring(numberOfBitsForPageNumber);

        for (int i = 0; i < parts.length; i++) {
            int value = Integer.parseInt(parts[i], 2);
            if (i < roundedNumberOfPagingLevels) {
                System.out.println("Level " + (i + 1) + " page table index: " + value);
            } else {
                System.out.println("Page offset: " + value);
            }
        }
    }
}


// 4294967296