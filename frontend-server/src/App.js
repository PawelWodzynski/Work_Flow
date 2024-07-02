import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import ToDoPage from "./components/ToDoComponents/ToDoPage/ToDoPage";
import LoginPage from "./components/LoginPageComponents/LoginPage/LoginPage";
import ProtectedRoute from "./ProtectedRoute/ProtectedRoute";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/login" element={<LoginPage />} />
        <Route
          path="/todo"
          element={<ProtectedRoute element={<ToDoPage />} />}
        />
      </Routes>
    </Router>
  );
}

export default App;
