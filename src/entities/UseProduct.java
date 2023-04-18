package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UseProduct extends Product {
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate manufactureDate;

    public UseProduct() {
        super();
    }

    public UseProduct(String name, Double price, LocalDate manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();

        sb.append(getName() + " (used) $ ");
        sb.append(String.format("%.2f", getPrice()));
        sb.append(" (Manufacture date: " + String.format(fmt.format(manufactureDate)));
        sb.append(")");

        return sb.toString();
    }
}