package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.domain.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book book01 = new Book("Domain Driven Design", "RandomHouse", "1234");
        System.out.println("Id: " + book01.getId());

        Book savedBook1 = bookRepository.save(book01);

        System.out.println("Id: " + book01.getId());

        Book book02 = new Book("Spring in Action", "Manning", "5678");
        Book savedBook02 = bookRepository.save(book02);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book: " + book.getTitle());
        });
    }
}
