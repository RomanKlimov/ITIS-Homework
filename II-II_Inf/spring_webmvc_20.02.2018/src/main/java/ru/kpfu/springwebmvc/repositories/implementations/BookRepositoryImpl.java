package ru.kpfu.springwebmvc.repositories.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.kpfu.springwebmvc.models.Book;
import ru.kpfu.springwebmvc.repositories.interfaces.BookRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Roman on 24.02.2018.
 */
@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    @Qualifier("JDBC")
    private DataSource dataSource;

    private static final String FIND_QUERY = "SELECT * FROM \"Books\" WHERE id = ?";



    @Override
    public Book findById(Long id) {
        Book book = null;

        try(Connection conection = this.dataSource.getConnection()) {
            PreparedStatement preparedStatement = conection.prepareStatement(FIND_QUERY);

            preparedStatement.setLong(1, id);

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()){
                    book = new Book();
                    book.setId(resultSet.getLong(1));
                    book.setName(resultSet.getString(2));
                    book.setAuthor(resultSet.getString(3));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }
}
