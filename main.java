import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
 
public class main {
 
    public static void part1()
    {
        System.out.println("AoC Day 11 Part 1");
   
        ArrayList<Long> nums = new ArrayList<>();
 
        boolean full = true;
        Scanner scanner = null;
 
        try {
            if (full) {
                scanner = new Scanner(new File("input_full.txt"));
            } else {
                scanner = new Scanner(new File("input_test.txt"));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            String[] n = line.split(" ");
            for (String s : n) {
                nums.add(Long.valueOf(s));
            }
        }
 
        ArrayList<Long> newNums = new ArrayList<>();
       
        for (int i=0; i<25; i++) {
            newNums = blink(nums);
            nums = newNums;
        }
        System.out.println("Number of stones: " + newNums.size());
    }
 
    public static ArrayList<Long> blink(ArrayList<Long> input) {
        ArrayList<Long> newNums = new ArrayList<>();
       
        for (int i=0; i<input.size(); i++) {
            long number = input.get(i);
            String numberAsString = String.valueOf(number);
            int len = numberAsString.length();
 
           if (number == 0) {
                newNums.add((long)1);
            } else if ( (len % 2) == 0) {
                newNums.add(Long.valueOf(numberAsString.substring(0,len/2)));
                newNums.add(Long.valueOf(numberAsString.substring(len/2)));
            } else {
                newNums.add(number * 2024);
            }
        }
 
        return newNums;
    }
 
    public static LinkedHashMap<Long, Long> blink2(LinkedHashMap<Long, Long> input) {
        LinkedHashMap<Long, Long>newNums = new LinkedHashMap<>();

        for ( Map.Entry<Long, Long> e : input.entrySet() ) 
        {
            Long number = e.getKey();
            long occurrences = e.getValue();
            String numberAsString = String.valueOf(number);
            int len = numberAsString.length();
 
           if (number == 0) {
                if (newNums.containsKey(1l)) {
                    newNums.put(1l, newNums.get(1l)+occurrences);
                } else {
                    newNums.put(1l, occurrences);
                }
            } else if ( (len % 2) == 0) {
                long l1 = Long.parseLong(numberAsString.substring(0,len/2));
                long l2 = Long.parseLong(numberAsString.substring(len/2));
                if (newNums.containsKey(l1)) {
                    newNums.put(l1,newNums.get(l1)+occurrences);
                } else {
                    newNums.put(l1,occurrences);
                }
                if (newNums.containsKey(l2)) {
                    newNums.put(l2,newNums.get(l2)+occurrences);
                } else {
                    newNums.put(l2,occurrences);
                }
            } else {
                long n = number * 2024;
                if (newNums.containsKey(n)) {
                    newNums.put(n, newNums.get(n)+occurrences);
                } else {
                    newNums.put(n, occurrences);
                }
            }
        }
 
        return newNums;
    }
 
    public static void part2()
    {
        System.out.println("AoC Day 11 Part 2");
       
        LinkedHashMap<Long, Long> map = new LinkedHashMap<>();
 
        boolean full = true;
        Scanner scanner = null;
 
        try {
            if (full) {
                scanner = new Scanner(new File("input_full.txt"));
            } else {
                scanner = new Scanner(new File("input_test.txt"));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
            String[] n = line.split(" ");
            for (String s : n) {
                map.put(Long.valueOf(s),1l);
            }
        }
 
        LinkedHashMap<Long, Long> newMap = new LinkedHashMap<>();
 
        for (int i=0; i<75; i++) {
            newMap = blink2(map);
            map = newMap;
        }
        long numberOfStones = 0;
        for (long l : newMap.values()) {
            numberOfStones += l;
        }
        System.out.println("Number of stones: " + numberOfStones);
    }
    public static void main(String[] args) {
       
        //part1();
        part2();  
    }
}