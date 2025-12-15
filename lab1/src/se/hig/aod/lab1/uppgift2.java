package src.se.hig.aod.lab1;

import java.io.*;
import java.util.*;

public class uppgift2 {


    private static List<Integer> loadListFromFile(String path, int size) throws IOException {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        try (Scanner in = new Scanner(new FileReader(path))) {
            while (cnt < size && in.hasNextLine()) {
                try {
                    list.add(Integer.parseInt(in.nextLine()));
                    cnt++;
                } catch (NumberFormatException ignored) {}
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> searchElements;
        try {
            searchElements = loadListFromFile("unique_integers.txt", 2500000);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        int[] searchSpaces = {10000, 20000};

        for (int searchSpace : searchSpaces) {
            long totalTime = 0;
            for (int rep = 0; rep < 10; rep++) {
                BinarySearchTree<Integer> bst = new BinarySearchTree<>();
                List<Integer> numbersToSearch = null;
                try (BufferedReader br = new BufferedReader(new FileReader("unique_integers.txt"))) {
                    numbersToSearch = new ArrayList<>();
                    String line;
                    int i = 0;
                    while ((line = br.readLine()) != null && i < searchSpace) {
                        numbersToSearch.add(Integer.parseInt(line));
                        i++;
                    }
                    // Collections.shuffle(numbersToSearch);  // Studie 1
                    Collections.sort(numbersToSearch);  // För Studie 2
                    for (Integer num : numbersToSearch) {
                        bst.addElement(num);
                    }
                    long startTime = System.currentTimeMillis();
                    for (Integer num : searchElements) {  
                        bst.searchElement(num);
                    }
                    totalTime += System.currentTimeMillis() - startTime;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            double avg = totalTime / 10;
            System.out.printf("%d %f n", searchSpace, avg);
        }
    }
}