import axios from "axios";
import { useRouter } from "next/router";
import { useEffect, useState } from "react";
import BoardComponent from "../../components/board/boardComponent";

const Board = () => {
  const router = useRouter();
  const [name, setName] = useState("익명의 사용자");
  const [board, setBoard] = useState([]);
  const addBoard = () => {
    router.push("/board/add");
  };
  useEffect(() => {
    axios.defaults.withCredentials = true;
    axios.get("http://localhost:8080/users").then((response) => {
      setName(response.data);
    });
  }, []);

  useEffect(() => {
    axios.defaults.withCredentials = true;
    axios.get("http://localhost:8080/boards").then((response) => {
      console.log(response);
    }, []);
  });

  return (
    <>
      <h1>{name}님 환영합니다</h1>
      <button onClick={addBoard}>게시글 쓰러가기</button>
    </>
  );
};
export default Board;
