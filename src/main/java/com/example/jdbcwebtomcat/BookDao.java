package com.example.jdbcwebtomcat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public boolean addBook(Book book) {
        // TODO Auto-generated method stub
        Connection con = DBConnection.getConn();
        String sql = "insert into book (bid,author,status,title) values (?,?,?,?) ";
        int i = 0;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, book.getBid());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setString(3, book.getStatus());
            preparedStatement.setString(4, book.getTitle());

            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    public boolean editBook(Book book) {
        Connection connection = DBConnection.getConn();
        String sql = "update book set author=?, status=?, title=? where bid=? ";
        int i = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, book.getAuthor());
            preparedStatement.setString(2, book.getStatus());
            preparedStatement.setString(3, book.getTitle());
            preparedStatement.setString(4, book.getBid());
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (i == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void deleteBook(String bid) {
        Connection connection = DBConnection.getConn();
        String sql = "delete from book where bid=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bid);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<Book> listBook() {
        List<Book> list = new ArrayList<>();
        Connection connection = DBConnection.getConn();
        String sql = "select bid,author,status,title from book";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            while (rst.next()) {
                Book book = new Book();
                book.setBid(rst.getString("bid"));
                book.setAuthor(rst.getString("author"));
                book.setStatus(rst.getString("status"));
                book.setTitle(rst.getString("title"));
                list.add(book);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return list;
    }

    public Book findBook(String bid) {
        Connection connection = DBConnection.getConn();
        String sql = "select bid,author,status,title from book where bid=?";
        Book book = new Book();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bid);
            Statement stmt = connection.createStatement();

            ResultSet rst = preparedStatement.executeQuery();
            while (rst.next()) {

                book.setBid(rst.getString("bid"));
                book.setAuthor(rst.getString("author"));
                book.setStatus(rst.getString("status"));
                book.setTitle(rst.getString("title"));

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return book;
    }
}
