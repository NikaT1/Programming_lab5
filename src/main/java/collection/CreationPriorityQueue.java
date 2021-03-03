package collection;
import com.opencsv.exceptions.CsvValidationException;
import exceptions.WrongValuesException;

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
    public void checkCity(City city) throws WrongValuesException {
        WrongValuesException e = new WrongValuesException();
        if (city.getName().equals("")) throw e;
        if (city.getCoordinates() == null) throw e;
        if (city.getCoordinates().getX() == null || city.getCoordinates().getX() <= -724) throw e;
        if (city.getCoordinates().getY() == null || city.getCoordinates().getY() <= -989) throw e;
        if (city.getPopulation() <= 0) throw e;
        if (city.getArea() <= 0) throw e;
        if (city.getClimate() == null) throw e;
        if (city.getGovernor() == null) throw e;
        if (city.getGovernor().getAge() <= 0) throw e;
    };
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
    public void makeQueue() throws CsvValidationException, ParseException, IOException, WrongValuesException {
        creationDate = LocalDate.now();
        Parser parser = new Parser(this);
        parser.parseCSV(lines);
    }
}

