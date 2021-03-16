package collectionUtils;

import collection.City;
import exceptions.TooMuchElementsException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Класс для создания коллекции и ее хранения.
 */

public class CreationPriorityQueue {
    private final InputStreamReader lines;
    private final String filePath;
    private LocalDate creationDate;
    private final HashSet<Integer> idSet;


    public CreationPriorityQueue(FileInputStream fileInputStream, String args) throws UnsupportedEncodingException {
        filePath = args;
        BufferedInputStream file = new BufferedInputStream(fileInputStream);
        this.lines = new InputStreamReader(file, StandardCharsets.UTF_8);
        idSet = new HashSet<>();
    }

    public void checkCity(City city) throws NumberFormatException {
        if (city.getName().equals("") || city.getCoordinates() == null || city.getCoordinates().getX() == null ||
                city.getCoordinates().getY() == null || city.getClimate() == null || city.getGovernor() == null)
            throw new NullPointerException();
        if (city.getCoordinates().getX() <= -724 || city.getCoordinates().getY() <= -989 || city.getPopulation() <= 0 ||
                city.getArea() <= 0 || city.getGovernor().getAge() != null && city.getGovernor().getAge() <= 0)
            throw new NumberFormatException();
    }

    public HashSet<Integer> getIdSet() {
        return idSet;
    }

    public Integer generateId() throws TooMuchElementsException {
        int id;
        int count = 0;
        TooMuchElementsException e = new TooMuchElementsException();
        if (Collections.max(idSet) == Integer.MAX_VALUE) {
            id = 1;
            count += 1;
        } else id = Collections.max(idSet) + 1;
        while (!idSet.add(id)) {
            if (id == Integer.MAX_VALUE) {
                id = 1;
                count += 1;
            } else id += 1;
            if (count == 2) throw e;
        }
        return id;
    }

    private final PriorityQueue<City> priorityQueue = new PriorityQueue<>(10, (c1, c2) -> c2.getArea() - c1.getArea());

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

    public String makeQueue() throws ParseException, NumberFormatException {
        creationDate = LocalDate.now();
        Parser parser = new Parser(this);
        parser.parseFile(lines);
        return "Коллекция успешно создана";
    }
}

