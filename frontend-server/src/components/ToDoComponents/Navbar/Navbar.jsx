import React from "react";
import "./Navbar.css";
import WorkFlowLogo from "./WorkFlowLogo/WorkFlowLogo";
import ButtonGroup from "./ButtonGroup/ButtonGroup";
import MenuButton from "./MenuButton/MenuButton";

const Navbar = () => {
  return (
    <div className="navbar navbar-grid">
      <WorkFlowLogo />
      <ButtonGroup />
      <MenuButton />
    </div>
  );
};

export default Navbar;
