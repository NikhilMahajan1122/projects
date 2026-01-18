import { Link } from "react-router-dom";
import { ListGroup, ListGroupItem } from "reactstrap";

const Menus = () => {
  return (
    <ListGroup>
      <ListGroupItem tag={Link} to="/" action>
        Home
      </ListGroupItem>
      <ListGroupItem tag={Link} to="/all-employees" action>
        All Employees
      </ListGroupItem>
      <ListGroupItem tag={Link} to="/add-employee" action>
        Add Employee
      </ListGroupItem>
      <ListGroupItem tag={Link} to="#" action>
        About
      </ListGroupItem>
    </ListGroup>
  );
};

export default Menus;
