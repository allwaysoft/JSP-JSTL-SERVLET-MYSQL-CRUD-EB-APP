package com.example.jdbcwebtomcat;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BookServlet", urlPatterns = {"/BookServlet"})
public class BookServlet extends HttpServlet {

    private BookDao bookDao;

    @Override
    public void init() {

        bookDao = new BookDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "insert":
                insertBook(request, response);
                break;
            case "delete":
                deleteBook(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "update":
                updateBook(request, response);
                break;
            default:
                listBook(request, response);
                break;
        }

    }

    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Book> listBook = bookDao.listBook();
        request.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("showEditForm:" + request.getParameter("bid"));
        Book existingBook = bookDao.findBook(request.getParameter("bid"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("book-form.jsp");
        request.setAttribute("book", existingBook);
        dispatcher.forward(request, response);

    }

    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Book newBook = new Book();
        newBook.setAuthor(request.getParameter("author"));
        newBook.setBid(request.getParameter("bid"));
        newBook.setTitle(request.getParameter("title"));
        newBook.setStatus(request.getParameter("status"));

        try {
            bookDao.addBook(newBook);
        } catch (Exception ex) {
            Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("?action=list");
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        Book book = new Book();
        book.setAuthor(request.getParameter("author"));
        book.setBid(request.getParameter("bid"));
        book.setTitle(request.getParameter("title"));
        book.setStatus(request.getParameter("status"));
        try {
            bookDao.editBook(book);
        } catch (Exception ex) {
            Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("?action=list");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        try {
            bookDao.deleteBook(request.getParameter("bid"));
        } catch (Exception ex) {
            Logger.getLogger(BookServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("?action=list");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
