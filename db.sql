DROP DATABASE IF EXISTS untact;
CREATE DATABASE untact;
USE untact;

CREATE TABLE article (
id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
regDate DATETIME NOT NULL,
updateDate DATETIME NOT NULL,
title CHAR(10) NOT NULL,
`body` TEXT NOT NULL
);

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = "제목1",
`body` = "내용1";

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = "제목2",
`body` = "내용2";

INSERT INTO article
SET regDate = NOW(),
updateDate = NOW(),
title = "제목3",
`body` = "내용3";

# 회원 테이블 생성
CREATE TABLE `member` (
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    loginId CHAR(30) NOT NULL,
    loginPw VARCHAR(100) NOT NULL,
    `name` CHAR(30) NOT NULL,
    `nickname` CHAR(30) NOT NULL,
    `email` CHAR(100) NOT NULL,
    `cellphoneNo` CHAR(20) NOT NULL
);

# 로그인 ID로 검색했을 때
ALTER TABLE `member` ADD UNIQUE INDEX (`loginId`);

# 회원, 테스트 데이터 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = "user1",
loginPw = "user1",
`name` = "user1",
nickname = "user1",
cellphoneNo = "01012341234",
email = "jangka512@gmail.com";

ALTER TABLE article ADD COLUMN memberId INT(10) UNSIGNED NOT NULL AFTER updateDate;

# 기존 게시물의 작성자를 회원1로 지정
UPDATE article
SET memberId = 1
WHERE memberId = 0;