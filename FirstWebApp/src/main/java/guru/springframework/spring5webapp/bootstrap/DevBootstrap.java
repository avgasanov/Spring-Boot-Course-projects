package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.model.repositories.AuthorRepository;
import guru.springframework.spring5webapp.model.repositories.BookRepository;
import guru.springframework.spring5webapp.model.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository,
                        BookRepository bookRepository,
                        PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author eric = new Author("Eric", "Evans");
        Publisher gunduz = new Publisher("Gunduz", "Ganja city");
        Book ddd = new Book("Domain Driven Design", "1234", gunduz);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(gunduz);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher osman = new Publisher("Osman", "Baku city");
        Book noEJB = new Book ("J2EE Development without EJB", "23444", osman);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(osman);
        bookRepository.save(noEJB);

    }
}
