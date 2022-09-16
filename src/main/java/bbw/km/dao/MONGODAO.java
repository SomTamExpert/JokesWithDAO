package bbw.km.gui.dao;


import bbw.km.gui.model.Joke;
import bbw.km.gui.model.JokeBook;
import com.mongodb.Block;
import com.mongodb.client.*;
import org.bson.Document;
import java.text.ParseException;


public class MONGODAO implements JokeDAO {

    public static MongoCollection<Document> createConnection() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase mongoDatabase = mongoClient.getDatabase("jokedb");
        return mongoDatabase.getCollection("jokes");
    }

    @Override
    public JokeBook getAllJokes() {
        System.out.println("MONGODAO.getAllJokes");
        JokeBook jokeBook = new JokeBook();
        MongoCollection<Document> collection = createConnection();
        FindIterable<Document> foundEntries = collection.find();
        foundEntries.forEach((Block<Document>) document -> {
            try {
                jokeBook.addJoke(JokeFillerMONGO.createJoke(document));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        });

        jokeBook.printJokeBook();
        return jokeBook;
    }

    @Override
    public void createJoke(Joke joke) {
        System.out.println("MONGODAO.createJoke");
        MongoCollection<Document> collection = createConnection();
        Document document = new Document();
        document.append("id", joke.getId());
        document.append("joke", joke.getJoke());
        document.append("date", joke.getDate());
        document.append("rating", joke.getRating());
        collection.insertOne(document);
        getAllJokes();
    }


    @Override
    public void updateJoke(Joke joke) {
        System.out.println("MONGODAO.updateJoke");
        MongoCollection<Document> collection = createConnection();
        Document document = new Document();
        document.append("id", joke.getId());
        document.append("joke", joke.getJoke());
        document.append("date", joke.getDate());
        document.append("rating", joke.getRating());
        collection.updateOne(new Document("id", joke.getId()), new Document("$set", document));
        getAllJokes();
    }

    @Override
    public void deleteJoke(int id) {
        System.out.println("MONGODAO.deleteJoke");
        MongoCollection<Document> collection = createConnection();
        collection.deleteOne(new Document("id", id));
        getAllJokes();
    }
}
