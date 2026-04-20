package bookshop.model;

import java.time.LocalDateTime;
import java.util.List;

public class Sale {
    private String id;
    private User user;
    private List<SaleItem> items;
    private LocalDateTime date;

    public Sale() {
    }

    public Sale(String id, User user, List<SaleItem> items, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.items = items;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<SaleItem> getItems() {
        return items;
    }

    public void setItems(List<SaleItem> items) {
        this.items = items;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
