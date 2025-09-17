import java.util.Scanner;
public class ArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take initial input
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Create array with extra space
        int[] arr = new int[n + 10];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Step 3: Menu loop
        while (true) {
            System.out.println("   ARRAY OPERATIONS MENU");
            System.out.println("1. Traversal");
            System.out.println("2. Insert Element");
            System.out.println("3. Delete Element");
            System.out.println("4. Search Element");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Traversal
                    System.out.print("Array elements: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + " ");
                    }
                    System.out.println();
                    break;

                case 2: // Insertion
                    System.out.println("1. At Beginning\n 2. At Given Position\n 3. At End");
                    int insertChoice = sc.nextInt();
                    System.out.print("Enter element to insert: ");
                    int elem = sc.nextInt();

                    if (insertChoice == 1) { // At beginning
                        for (int i = n; i > 0; i--) {
                            arr[i] = arr[i - 1];
                        }
                        arr[0] = elem;
                        n++;
                    } else if (insertChoice == 2) { // At given position
                        System.out.print("Enter position (0 to " + n + "): ");
                        int pos = sc.nextInt();
                        if (pos >= 0 && pos <= n) {
                            for (int i = n; i > pos; i--) {
                                arr[i] = arr[i - 1];
                            }
                            arr[pos] = elem;
                            n++;
                        } else {
                            System.out.println("Invalid position!");
                        }
                    } else if (insertChoice == 3) { // At end
                        arr[n] = elem;
                        n++;
                    }
                    break;

                case 3: // Deletion
                    System.out.println("1. From Beginning\n 2. From Given Position\n 3. From End");
                    int delChoice = sc.nextInt();

                    if (n == 0) {
                        System.out.println("Array is empty!");
                        break;
                    }

                    if (delChoice == 1) { // From beginning
                        for (int i = 0; i < n - 1; i++) {
                            arr[i] = arr[i + 1];
                        }
                        n--;
                    } else if (delChoice == 2) { // From given position
                        System.out.print("Enter position (0 to " + (n - 1) + "): ");
                        int pos = sc.nextInt();
                        if (pos >= 0 && pos < n) {
                            for (int i = pos; i < n - 1; i++) {
                                arr[i] = arr[i + 1];
                            }
                            n--;
                        } else {
                            System.out.println("Invalid position");
                        }
                    } else if (delChoice == 3) { // From end
                        n--;
                    }
                    break;

                case 4: // Searching
                    System.out.print("Enter element to search: ");
                    int element = sc.nextInt();
                    boolean found = false;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] ==element ) {
                            System.out.println("Element found at index " + i);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Element not found.");
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
