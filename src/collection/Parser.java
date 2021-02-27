package collection;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Date;

public class Parser {
    private CreationPriorityQueue priorityQueue;
    public Parser(CreationPriorityQueue priorityQueue) {
        this.priorityQueue = priorityQueue;
    }
    public void parseCSV(InputStreamReader lines) throws IOException, CsvValidationException, ParseException {
        CSVReader reader = new CSVReader(lines);
        String[] nextLine;
        HashMap<String, Integer> fields = new HashMap<String, Integer>();
        if ((nextLine = reader.readNext()) != null) {
            int i=0;
            for (String str: nextLine) {
                fields.put(str, i);
                i++;
            }
        }
        while ((nextLine = reader.readNext()) != null) {
            City city = new City();
            Date date = new Date();
            city.setId(priorityQueue.generateId((int) (date.getTime()%100000000)));
            city.setName(nextLine[fields.get("name")]);
            city.setCoordinates(new Coordinates(Float.parseFloat(nextLine[fields.get("x")]), Integer.parseInt(nextLine[fields.get("y")])));
            city.setCreationDate(LocalDate.now());
            city.setArea(Integer.parseInt(nextLine[fields.get("area")]));
            city.setPopulation(Long.parseLong(nextLine[fields.get("population")]));
            if (!nextLine[fields.get("metersAboveSeaLevel")].equals("")) city.setMetersAboveSeaLevel(Long.parseLong(nextLine[fields.get("metersAboveSeaLevel")]));
            else city.setMetersAboveSeaLevel(null);
            if (!nextLine[fields.get("establishmentDate")].equals("")) {
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                city.setEstablishmentDate(formatter.parse(nextLine[fields.get("establishmentDate")]));
            } else city.setEstablishmentDate(null);
            if (!nextLine[fields.get("agglomeration")].equals(""))  city.setAgglomeration(Integer.parseInt(nextLine[fields.get("agglomeration")]));
            else city.setAgglomeration(null);
            city.setClimate(Climate.valueOf(nextLine[fields.get("climate")]));
            city.setGovernor(new Human(Integer.parseInt(nextLine[fields.get("age")])));
            priorityQueue.addToQueue(city);
        }
    }
}


