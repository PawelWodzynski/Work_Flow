import React from "react";
import { Navigate } from "react-router-dom";

const ProtectedRoute = ({ element }) => {
  const token = localStorage.getItem("token");
  console.log("Token:", token); // Dodane logowanie
  const isAuthenticated = token !== null;

  if (!isAuthenticated) {
    console.log("User not authenticated"); // Dodane logowanie
    return <Navigate to="/login" replace />;
  }

  console.log("User authenticated"); // Dodane logowanie
  return element;
};

export default ProtectedRoute;
