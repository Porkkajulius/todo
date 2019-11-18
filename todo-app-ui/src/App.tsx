import React from "react";
import { Switch, Route } from "react-router";
import { BrowserRouter } from "react-router-dom";
import { TodoView } from "./view/TodoView";

const App: React.FC = () => {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact={true} component={TodoView} />
      </Switch>
    </BrowserRouter>
  );
};

export default App;
