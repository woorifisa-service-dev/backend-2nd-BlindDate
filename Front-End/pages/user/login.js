import axios from "axios";
import { useEffect, useState } from "react";
import Cookies from "js-cookie";
import { useRouter } from "next/router";

const LogIn = () => {
  const router = useRouter();
  const [email, setEmail] = useState("2");
  const [pw, setPw] = useState("2");

  const displayEmail = (e) => {
    console.log(e.target.value);
    setEmail(e.target.value);
  };

  const displayPw = (e) => {
    console.log(e.target.value);
    setPw(e.target.value);
  };

  const signIn = async () => {
    try {
      axios.defaults.withCredentials = true;
      await axios
        .post("http://localhost:8080/users/login", {
          email: email,
          password: pw,
        })
        .then((response) => {
          console.log(response);
          router.push("/board");
        });
    } catch (error) {
      console.log(error);
    }
  };
  const getCookie = async () => {
    axios.get("http://localhost:8080/users");
  };

  return (
    <>
      <h1>로그인</h1>
      <div>
        <label htmlFor="">이메일</label>
        <input value={email} onChange={displayEmail} type="email" />
      </div>
      <div>
        <label htmlFor="">비밀번호</label>
        <input value={pw} onChange={displayPw} type="password" />
      </div>
      <button onClick={signIn}>로그인하기</button>
      <button onClick={getCookie}>쿠키 가져오기</button>
    </>
  );
};

export default LogIn;
