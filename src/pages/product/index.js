// import Button from "@restart/ui/esm/Button";
import React, { Component } from "react";
import {
  Row,
  Col
} from "react-bootstrap";
import { connect } from "react-redux";
import CartItem from "../../components/CartItem";

class Product extends Component {
  constructor(props) {
    super(props);
    this.state = {
    };
  }
  setValue = (e) => {
    this.setState({
      [e.target.name]: e.target.value,
    });
  };
  buttonLogin() {
    const { username, password } = this.state;
    const url = "http://localhost:8080/api/authenticate";
    const headers = {
      Accept: "application/json, text/plain",
      "Content-Type": "application/json",
    };
    fetch(url, {
      method: "POST",
      body: JSON.stringify({ username, password }),
      headers: headers,
    })
      .then(async (respone) => {
        const data = await respone.json();
        const { token } = data;

        console.log("token ", data);
        if (token) {
          localStorage.setItem("token", token); // for persistent login
          this.props.loginHandler(token);
          this.setState({ isLogin: true });
          // this.props.statuslog(true)
        } else {
          alert("Username & Password Invalid");
        }
      })
      .catch((err) => {
        console.warn(err);
      });
  }

  renderListProduct = () => {
    const list = this.props.product.map((products, idx) => {
      return (
        <tr key={idx}>
          <th scope="raw">{idx + 1}</th>
          <td>{products.judul}</td>
          <td>{products.penerbit}</td>
          <td>{products.stock}</td>
          <td>
          <button type="button" class="btn btn-outline-primary" onClick>Update</button>

          </td>
          <td>
          <button type="button" class="btn btn-outline-primary" onClick>Delete</button>
          </td>
        </tr>
      );
    });
    return list;
  };
  render() {
    const carts = this.props.carts
    console.log("Login", this.props.statusLogin);
    return (

        <Row style={{
          paddingTop :"-15"
        }}>
          <Col sm={8}>
            <table class="table table-hover">
              <thead>
                <tr>
                  <th scope="col">No</th>
                  <th scope="col">Judul</th>
                  <th scope="col">Penerbit</th>
                  <th scope="col">Stock</th>
                  <th scope="col" colSpan="2" style={{textAlign :"center"}}>Action</th>
                </tr>
              </thead>
              <tbody>
              {this.renderListProduct()}
              </tbody>
            </table>
          </Col>
          <Col height style={{background :"#ffc107"}} sm={4}>
          <p>{carts ? `${carts.length} item in cart` : `0 item in cart`}</p>
          {carts.map(item => 
            <CartItem key={item.id} item={item}/>
          )}
          </Col>
        </Row>
    );
  }
}

const mapStateToProps = (state) => ({
  statusLogin: state.statusLogin,
  token : state.token,
  product : state.product,
  carts : state.carts
});

const mapDispatchToProps = (dispatch) => ({
  loginHandler: (token) =>
    dispatch({
      type: "LOGIN_OK",
      payload: token,
      statusLogin: true,
    }),
});
export default connect(mapStateToProps, mapDispatchToProps)(Product);

