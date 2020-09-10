package ovh.enyo.hlm.model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name cannot be empty!")
    private String name;
    private String authors;
    private String publisher;
    private String genres;
    private String format;
    private String quality;
    private String isbn;
    @Pattern(regexp = "[0-9]{0,5}", message = "Must be digital in range 0 - 99999")
    private String pages;
    @Pattern(regexp = "[0-9]{1,5}\\.?[0-9]{0,2}", message = "Must be digital in range 0 - 99999.99")
    private String price;
    private boolean read;
    private boolean hardcover;
    private boolean bought;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "book")
    private Set<Note> notes = new HashSet<>();

   public Book() {
       super();
   }

    public Book(int id, String name, String isbn, String format, String authors,
                String genres, String publisher, String quality, String pages, String price,
                boolean read, boolean hardcover, boolean bought, Set<Note> notes) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
        this.format = format;
        this.authors = authors;
        this.genres = genres;
        this.publisher = publisher;
        this.quality = quality;
        this.pages = pages;
        this.price = price;
        this.read = read;
        this.hardcover = hardcover;
        this.bought = bought;
        this.notes = notes;
    }

//    public Set<Note> getNotes() {
//        return notes;
//    }
//
//    public void setNotes(Set<Note> notes) {
//        this.notes = notes;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isHardcover() {
        return hardcover;
    }

    public void setHardcover(boolean hardcover) {
        this.hardcover = hardcover;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public String convertBool(boolean bool) {
       if(bool) return "Yes";
       else return "No";
    }
}
