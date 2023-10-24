import { useEffect, useState } from "react";

function App() {
  const SERVER_URL = "http://localhost:8080/todo";
  const [todoList, setTodoList] = useState([]);

  const fetchData = () => {
    fetch(`${SERVER_URL}`)
      .then((response) => response.json())
      .then((data) => setTodoList(data));
  };

  // fetch 요청을 처음 로딩 시 한 번만 하도록 한다. (두번째 파라미터 빈 배열)
  useEffect(() => fetchData(), []);

  const onSubmitHandler = (e) => {
    // 쿼리파라미터로 자동 get 요청 보내는 것 방지
    e.preventDefault();

    const text = e.target.text.value;
    const done = e.target.done.checked;

    fetch(`${SERVER_URL}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        text,
        done,
      }),
    }).then(() => fetchData()); // 데이터 추가 후 다시 로딩
  };

  console.log(todoList);

  return (
    <div className="App">
      <h1>Axios Test</h1>
      <form onSubmit={onSubmitHandler}>
        <input name="text" />
        <input name="done" type="checkbox" />
        <input type="submit" value="추가" />
      </form>
      {todoList?.map((todo) => (
        <div key={todo.id} style={{ display: "flex", margin: "10px" }}>
          <div>{todo.text}</div>
          <div>{todo.done ? "Yes" : "No"}</div>
        </div>
      ))}
    </div>
  );
}

export default App;
