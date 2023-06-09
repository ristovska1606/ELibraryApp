import logo from '../../logo.svg';
import './App.css';
import {Component} from "react";
import {
    BrowserRouter as Router,
    Routes,
    Route
} from "react-router-dom";
import Books from "../Books/BookList/books";
import ELibraryService from "../../repository/ELibraryRepository";
import BookEdit from "../Books/BookEdit/bookEdit";
import BookAdd from "../Books/BookAdd/bookAdd";
import Header from "../Header/header";
import Categories from "../Categories/categories";

class App extends Component{
  constructor(props) {
    super(props);
    this.state = {
        books: [],
        authors: [],
        categories: [],
        selectedBook : {}
    }
  }

  render() {
    return (
        <Router>
        <Header/>
         <main>
             <div className="container">

              <Routes>
                  <Route path="/books" element={
                      <Books books={this.state.books}
                             onDelete={this.deleteBook}
                             onEdit={this.getBook}
                             onMarkAsTaken={this.markBookAsTaken}/>}/>
                  <Route path="/" element={
                      <Books books={this.state.books}
                             onDelete={this.deleteBook}
                             onEdit={this.getBook}
                             onMarkAsTaken={this.markBookAsTaken}/>}/>
                  <Route path="/books/add" element={
                      <BookAdd categories={this.state.categories}
                               authors={this.state.authors}
                               onAddBook={this.addBook}/>}/>
                  <Route path="/books/edit/:id" element={
                      <BookEdit categories={this.state.categories}
                                   authors={this.state.authors}
                                   onEditBook={this.editBook}
                                   book={this.state.selectedBook}/>}/>
                  <Route path="/categories" element={
                      <Categories categories={this.state.categories} />}/>
              </Routes>

          </div>
        </main>
        </Router>
    )
  }

  componentDidMount() {
      this.loadBooks();
      this.loadAuthors();
      this.loadCategories();
  }

      loadBooks = () => {
          ELibraryService.fetchBooks()
              .then((data) => {
                  this.setState({
                      books: data.data
                  })
              })
      }

      loadAuthors = () => {
          ELibraryService.fetchAuthors()
              .then((data) => {
                  this.setState({
                      authors: data.data
                  })
              })
      }

      loadCategories = () => {
          ELibraryService.fetchCategories()
              .then((data) => {
                  this.setState({
                      categories: data.data
                  })
              })
      }

      deleteBook = (id) => {
          ELibraryService.deleteBook(id)
              .then(() => {
                  this.loadBooks();
              });
      }

      addBook = (name, category, author, availableCopies) => {
          ELibraryService.addBook(name, category, author, availableCopies)
              .then(() => {
                  this.loadBooks();
              })
      }

      getBook = (id) => {
          ELibraryService.getBook(id)
              .then((data) => {
                  this.setState({
                      selectedBook: data.data
                  });
              })
      }

      editBook = (id, name, category, author, availableCopies) => {
          ELibraryService.editBook(id, name, category, author, availableCopies)
              .then(() =>{
                  this.loadBooks();
              });
      }

      markBookAsTaken = (id) => {
          ELibraryService.markBookAsTaken(id)
              .then(() => {
                  this.loadBooks();
              });
      }


}

export default App;
