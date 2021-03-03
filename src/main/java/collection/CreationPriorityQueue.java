package collection;
import exceptions.TooMuchElementsException;
import exceptions.WrongValuesException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Класс для создания коллекции и ее хранения.
 */

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
        if (city.getGovernor().getAge()!=null && city.getGovernor().getAge() <= 0) throw e;
    }
    public HashSet<Integer> getIdSet() {
        return idSet;
    }
    public Integer generateId() throws TooMuchElementsException {
        Integer id;
        int count = 0;
        TooMuchElementsException e = new TooMuchElementsException();
        if (Collections.max(idSet) == Integer.MAX_VALUE) {
            id = 1;
            count += 1;
        }
        else id = Collections.max(idSet) + 1;
        while (!idSet.add(id)) {
            if (id == Integer.MAX_VALUE) {
                id = 1;
                count += 1;
            }
            else id += 1;
            if (count == 2) throw e;
        }
        return id;
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
    public String makeQueue() throws ParseException, WrongValuesException {
        creationDate = LocalDate.now();
        Parser parser = new Parser(this);
        parser.parseCSV(lines);
        return "Коллекция успешно создана";
    }
}

