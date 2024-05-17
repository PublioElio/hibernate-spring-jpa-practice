package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final Logger logger = Logger.getLogger(DataInitializer.class.getName());
    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        bookRepository.deleteAll();

        Book book01 = new Book("Domain Driven Design", "RandomHouse", "1234");
        Book savedBook1 = bookRepository.save(book01);

        Book book02 = new Book("Spring in Action", "Manning", "5678");
        Book savedBook02 = bookRepository.save(book02);

        bookRepository.findAll().forEach(book -> {
            logger.log(Level.INFO, () -> "Book Id: " + book.getId());
            logger.log(Level.INFO, () -> "Book: " + book.getTitle());
        });
    }
}
