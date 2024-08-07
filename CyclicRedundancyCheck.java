import java.util.Scanner;

public class CyclicRedundancyCheck {
    private static boolean[] remainder = new boolean[100];

    private static void performXOR(boolean[] dividend, boolean[] divisor, int dividendLength, int divisorLength) {
        for (int i = 0; i < dividendLength; i++) {
            if (dividend[i]) {
                for (int j = 0; j < divisorLength; j++) {
                    dividend[i + j] ^= divisor[j];
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input data
        System.out.print("Enter data frame length: ");
        int dataLength = input.nextInt();
        boolean[] dataFrame = inputBinarySequence(input, dataLength, "Enter data frame");

        System.out.print("Enter generator polynomial length: ");
        int genLength = input.nextInt();
        boolean[] generator = inputBinarySequence(input, genLength, "Enter generator polynomial");

        // Sender side
        System.out.println("\n--- Sender Side ---");
        displayBinarySequence("Original data frame", dataFrame, dataLength);
        displayBinarySequence("Generator polynomial", generator, genLength);

        int redundantBits = genLength - 1;
        System.out.println("Number of redundant bits to be appended: " + redundantBits);

        boolean[] augmentedFrame = new boolean[dataLength + redundantBits];
        System.arraycopy(dataFrame, 0, augmentedFrame, 0, dataLength);
        displayBinarySequence("Augmented data frame", augmentedFrame, augmentedFrame.length);

        boolean[] dividend = augmentedFrame.clone();
        performXOR(dividend, generator, dataLength, genLength);

        System.arraycopy(dividend, dataLength, remainder, 0, redundantBits);
        displayBinarySequence("CRC remainder", remainder, redundantBits);

        boolean[] transmittedFrame = new boolean[dataLength + redundantBits];
        System.arraycopy(dataFrame, 0, transmittedFrame, 0, dataLength);
        System.arraycopy(remainder, 0, transmittedFrame, dataLength, redundantBits);
        displayBinarySequence("Transmitted frame", transmittedFrame, transmittedFrame.length);

        // Receiver side
        System.out.println("\n--- Receiver Side ---");
        System.out.print("Enter received frame length: ");
        int receivedLength = input.nextInt();

        if (receivedLength != dataLength + redundantBits) {
            System.out.println("Error: Incorrect frame length received");
            System.exit(1);
        }

        boolean[] receivedFrame = inputBinarySequence(input, receivedLength, "Enter received frame");

        boolean[] receivedDividend = receivedFrame.clone();
        performXOR(receivedDividend, generator, dataLength, genLength);

        boolean[] receivedRemainder = new boolean[redundantBits];
        System.arraycopy(receivedDividend, dataLength, receivedRemainder, 0, redundantBits);
        displayBinarySequence("Received remainder", receivedRemainder, redundantBits);

        boolean isErrorFree = true;
        for (int i = 0; i < redundantBits; i++) {
            if (receivedRemainder[i]) {
                isErrorFree = false;
                break;
            }
        }

        System.out.println(isErrorFree ? 
            "Transmission successful: No errors detected" : 
            "Transmission error: Data corruption detected");

        input.close();
    }

    private static boolean[] inputBinarySequence(Scanner scanner, int length, String prompt) {
        System.out.print(prompt + ": ");
        boolean[] sequence = new boolean[length];
        for (int i = 0; i < length; i++) {
            sequence[i] = scanner.nextInt() == 1;
        }
        return sequence;
    }

    private static void displayBinarySequence(String label, boolean[] sequence, int length) {
        System.out.print(label + ": ");
        for (int i = 0; i < length; i++) {
            System.out.print(sequence[i] ? "1" : "0");
        }
        System.out.println();
    }
}