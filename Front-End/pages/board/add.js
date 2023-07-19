import axios from "axios";
import { useRouter } from "next/router";
import { useState } from "react";

const Home = () => {
  const router = useRouter();
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");
  const displayTitle = (e) => {
    setTitle(e.target.value);
  };
  const displayContent = (e) => {
    setContent(e.target.value);
  };

  const addBoard = () => {
    axios.defaults.withCredentials = true;
    axios.post("http://localhost:8080/boards", {
      title: title,
      content: content,
    });
    router.push("/board");
  };

  return (
    <div>
      <h2>게시글 작성할게요</h2>
      <label htmlFor="">제목</label>
      <input id="title" value={title} onChange={displayTitle} type="text" />
      <label htmlFor="">내용</label>
      <input type="text" value={content} onChange={displayContent} />
      <button onClick={addBoard}>게시글 작성</button>
    </div>
  );
};
export default Home;
