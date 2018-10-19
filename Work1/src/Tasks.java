import java.util.Scanner;

public class Tasks {

    public static void main(String[] args) {

                /*  TASK 1 */

        int N = 5;
        int arr[] = new int[N];

        System.out.println("Введите '0' если захотите прекратить ввод");
        Scanner input = new Scanner(System.in);

        for (int i = 0; i <= arr.length; i++) {
            if (i == arr.length) {
                int arr2[] = new int[N];
                for (int j = 0; j < arr.length; j++) {
                    arr2[j] = arr[j];
                }
                N = N * 2;
                arr = new int[N];
                for (int j = 0; j < arr2.length; j++) {
                    arr[j] = arr2[j];
                }
                System.out.print("Массив удвоен..." + "\n");
            }
            System.out.println("Введите " + (i + 1) + "-ый элемент");
            arr[i] = input.nextInt();
            if (arr[i] == 0) {
                break;
            }
        }

        System.out.print("\n" + "Получившийся массив:" + "\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

                    /*  TASK 2 */

        System.out.print("\n" + "Введите число, которое необходимо удалить из массива: ");
        int a = input.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == a) {
                arr[i] = 0;
            }
        }

        System.out.print("\n" + "Получившийся массив:" + "\n");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }
}

