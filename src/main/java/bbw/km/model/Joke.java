package bbw.km.model;


import java.sql.Date;

public class Joke {
    private int id;
    private String joke;
    private Date date;
    private int rating;

    public Joke(int id, String joke, Date date, int rating) {
        this.id = id;
        this.joke = joke;
        this.date = date;
        this.rating = rating;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + id +
                ", joke='" + joke + '\'' +
                ", date=" + date +
                ", rating=" + rating +
                '}';
    }
}
