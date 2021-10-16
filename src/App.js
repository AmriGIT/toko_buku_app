import React, { Component } from "react";
// import Header from './template/Header';
// import Navbar from './template/Navbar';
// import Content from './template/Content';
import { Header, Navbar, Content } from "./template";
// import "./App.css"
import { BrowserRouter as Router } from "react-router-dom";
import { Container } from "react-bootstrap";
import { connect } from "react-redux";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      menu: "home",
      setStatus: false,
    };
  }
componentDidMount(){
  const token = localStorage.getItem("token")
  if (token) {
    fetch("http://localhost:8181/list-buku", {
      method: "GET",
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + token
        // 'Content-Type': 'application/x-www-form-urlencoded',
      }
    })
      .then(async resp => {
        const data = await resp.json()
        const { token } = data
        if (!token==={}) {
          this.props.loginHandler(token)
        } else {
          alert("Login Ulang")
          localStorage.removeItem('token')
        }
      })
      .catch(err => {
        console.warn(err)
        alert("Internal Server Error!")
        localStorage.removeItem('token')
      })
  }
}
  render() {
    console.log("AppJS", this.state.setStatus);
    return (
      <Router>
        <Container>
          <Header />
          <Navbar sts2={this.state.setStatus} />
          <Content
            menu={this.state.menu}
            // sts={this.changeStatus}
            sts2={this.state.setStatus}
          />
        </Container>
      </Router>
    );
  }
}
const mapDispatchToProps = dispatch => ({
  loginHandler: token => dispatch({ type: "LOGIN_OK", payload: token })
})

export default connect(null, mapDispatchToProps)(App);
