import React, { useEffect, useState } from "react";
import axios from "axios";
import { useRouter } from "next/router";
const Home = () => {
  const router = useRouter();
  const [email, setEmail] = useState("");
  const displayEmail = (e) => {
    console.log(e.target.value);
    setEmail(e.target.value);
  };

  const [pw, setpw] = useState("");
  const displaypw = (e) => {
    console.log(e.target.value);
    setpw(e.target.value);
  };

  const [name, setname] = useState("");
  const displayname = (e) => {
    console.log(e.target.value);
    setname(e.target.value);
  };

  const [gender, setgender] = useState("");
  const displaygender = (e) => {
    console.log(e.target.value);
    setgender(e.target.value);
  };

  const [marry, setmarry] = useState("");
  const displaymarry = (e) => {
    console.log(e.target.value);
    setmarry(e.target.value);
  };

  const [couple, setcouple] = useState("");
  const displaycouple = (e) => {
    console.log(e.target.value);
    setcouple(e.target.value);
  };

  const [age, setage] = useState("");
  const displayage = (e) => {
    console.log(e.target.value);
    setage(e.target.value);
  };

  const [height, setheight] = useState("");
  const displayheight = (e) => {
    console.log(e.target.value);
    setheight(e.target.value);
  };

  const signUp = () => {
    axios.post("http://localhost:8080/users", {
      email: email,
      password: pw,
      name: name,
      gender: gender,
      marry: marry,
      couple: couple,
      age: age,
      height: height,
    });
    router.push("/user/login");
  };

  return (
    <main>
      <div>
        <label htmlFor="">이메일</label>
        <input value={email} onChange={displayEmail} type="email" />
      </div>
      <div>
        <label htmlFor="">비밀번호</label>
        <input value={pw} onChange={displaypw} type="password" />
      </div>
      <div>
        <label htmlFor="">이름</label>
        <input value={name} onChange={displayname} type="text" />
      </div>
      <div>
        <label htmlFor="">성별</label>
        <input value={gender} onChange={displaygender} type="text" />
      </div>
      <div>
        <label htmlFor="">결혼 유무</label>
        <input value={marry} onChange={displaymarry} type="text" />
      </div>
      <div>
        <label htmlFor="">커플 유무</label>
        <input value={couple} onChange={displaycouple} type="text" />
      </div>
      <div>
        <label htmlFor="">나이</label>
        <input value={age} onChange={displayage} type="text" />
      </div>
      <div>
        <label htmlFor="">키</label>
        <input value={height} onChange={displayheight} type="text" />
      </div>
      <button onClick={signUp}>회원 가입</button>
    </main>
  );
};

export default Home;
