import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Vocabulary {
    public static void main(String[] args) {
        int count = 'z'-'a'+1;
        LinkedList<String> vocabulary = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/date/vocabulary.txt"))) {
            String s;
            do {
                s=br.readLine();
                if (s!=null) vocabulary.add(s);
            }
            while (s!=null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(vocabulary.size());
        Collections.sort(vocabulary);
        Collections.reverse(vocabulary);
        for (String s:vocabulary)
            System.out.println(s);

        //вывести первые 10 слов
        ListIterator<String> iterator = vocabulary.listIterator(0);
        int i=0;
        while (iterator.hasNext()&& i<10){
            System.out.println();
            System.out.print(iterator.next()+ " " + i++);}
        iterator = vocabulary.listIterator(vocabulary.size());
        System.out.println();
        //вывести последние 10 слов
        i=0;
        while (iterator.hasPrevious()&& i<10){
            System.out.println();
            System.out.print(iterator.previous()+ " " + i++);
        }
        System.out.println();
        //сколько букв в самом длинном слове
        int max = 0;
        iterator = vocabulary.listIterator(0);
        String s;
        while (iterator.hasNext()) {
            s = iterator.next();
            if (s.length() > max) max = s.length();
        }
        System.out.println();
        System.out.println(max);

        //Сколько слов однобуквенныых, двухбуквенных и т.д.
        int[] hist = new int[max];
        iterator = vocabulary.listIterator(0);
        while (iterator.hasNext()) {
            s = iterator.next();
            hist[s.length()-1]++;
        }
        for (i=0; i<max; i++)
        System.out.printf("letters:%d, words:%d%n", i+1, hist[i]);

        System.out.println();
        //Вывести слова палиндромы
        iterator = vocabulary.listIterator(0);
        while (iterator.hasNext()) {
            s = iterator.next();
            if (s.equals(new StringBuilder(s).reverse().toString()))
                System.out.println(s);
        }

        System.out.println();
        //Вывести все слова - анограммы
        iterator = vocabulary.listIterator(0);
        while (iterator.hasNext()) {
            s = iterator.next();

        }
    }
}
