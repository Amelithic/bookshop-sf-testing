package bookshop.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a book in the bookshop inventory.
 */
public class Book {

    private String title;
    private String author;
    private String isbn;        // 10 or 13 digits
    private String barcode;     // Custom or ISBN-based
    private double price;
    private double weightGrams; // Used for postage calculation
    private int stockCount;

    public Book(String title, String author, String isbn,
                String barcode, double price, double weightGrams, int stockCount) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.barcode = barcode;
        this.price = price;
        this.weightGrams = weightGrams;
        this.stockCount = stockCount;
    }

    // --- Getters ---
    public String getTitle()        { return title; }
    public String getAuthor()       { return author; }
    public String getIsbn()         { return isbn; }
    public String getBarcode()      { return barcode; }
    public double getPrice()        { return price; }
    public double getWeightGrams()  { return weightGrams; }
    public int getStockCount()      { return stockCount; }

    // --- Setters ---
    public void setPrice(double price)              { this.price = price; }
    public void setWeightGrams(double weightGrams)  { this.weightGrams = weightGrams; }
    public void setStockCount(int stockCount)       { this.stockCount = stockCount; }
    public void setBarcode(String barcode)          { this.barcode = barcode; }

    /** Converts this Book to a CSV row. */
    public String toCsvRow() {
        return String.join(",",
                escapeCsv(title), escapeCsv(author), escapeCsv(isbn),
                escapeCsv(barcode), String.valueOf(price),
                String.valueOf(weightGrams), String.valueOf(stockCount));
    }

    /** Creates a Book from a CSV row string. */
    public static Book fromCsvRow(String csvRow) {
        String[] p = parseCsvLine(csvRow);
        if (p.length < 7) throw new IllegalArgumentException("Invalid Book CSV row: " + csvRow);

        double price = Double.parseDouble(p[4].trim());
        double weight = Double.parseDouble(p[5].trim());
        int stock = (int) Double.parseDouble(p[6].trim()); // tolerant of "1" and "1.0"

        return new Book(
                p[0].trim(), p[1].trim(), p[2].trim(), p[3].trim(),
                price, weight, stock
        );
    }

    private static String[] parseCsvLine(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (inQuotes) {
                if (c == '"') {
                    // look ahead for escaped quote
                    if (i + 1 < line.length() && line.charAt(i + 1) == '"') {
                        cur.append('"');
                        i++; // skip the escaped quote
                    } else {
                        inQuotes = false; // end quote
                    }
                } else {
                    cur.append(c);
                }
            } else {
                if (c == '"') {
                    inQuotes = true;
                } else if (c == ',') {
                    fields.add(cur.toString());
                    cur.setLength(0);
                } else {
                    cur.append(c);
                }
            }
        }
        fields.add(cur.toString());
        return fields.toArray(new String[0]);
    }

    private String escapeCsv(String v) {
        if (v == null) return "";
        return v.contains(",") ? "\"" + v + "\"" : v;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', isbn='" + isbn + "', price=" + price
                + ", stock=" + stockCount + "}";
    }
}