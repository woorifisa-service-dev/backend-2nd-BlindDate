"use client";

const Home = () => {
  const signup = () => {
    window.location.href = "/user";
  };

  const signin = () => {
    window.location.href = "/user/login";
  };
  const mainStyle = {
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
    width: "100%",
    height: "100vh",
  };
  return (
    <>
      <main style={mainStyle}>
        <button onClick={signup}>회원 가입</button>
        <button onClick={signin}>로그인</button>
      </main>
    </>
  );
};

export default Home;
