package pe.edu.ulima.is2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class VideoGame {
    private Long id;
    private String title;
    private String platform;
    private Double price;
    private Integer stock;

    public VideoGame() {
    }

    public VideoGame(Long id, String title, String platform, Double price, Integer stock) {
        this.id = id;
        this.title = title;
        this.platform = platform;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", platform='" + platform + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
