package collection;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Random;

public class CreationPriorityQueue {
    private InputStreamReader lines;
    private String filePath;
    private LocalDate creationDate;
    private HashSet<Integer> idSet;
    public CreationPriorityQueue(FileInputStream fileInputStream, String args){
        filePath = args;
        BufferedInputStream file = new BufferedInputStream(fileInputStream);
        this.lines = new InputStreamReader(file);
        idSet = new HashSet<>();
    }
    public int generateId(int millis) {
        Random rand = new Random();
        while (!idSet.add(millis)) {
            millis += rand.nextInt(10);
        }
        return millis;
    }
    private PriorityQueue<City> priorityQueue = new PriorityQueue<>(10, new Comparator<>(){
        public int compare(City c1, City c2) {
            return c2.getArea() - c1.getArea();
        }
    }
    );
    public String getFilePath() {
        return filePath;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public PriorityQueue<City> getPriorityQueue() {
        return priorityQueue;
    }
    public void addToQueue(City c) {
        priorityQueue.add(c);
    }
    public City pollFromQueue() {
        return priorityQueue.poll();
    }
    public void makeQueue() throws CsvValidationException, ParseException, IOException {
        creationDate = LocalDate.now();
        Parser parser = new Parser(this);
        parser.parseCSV(lines);
    }
}

