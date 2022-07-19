-- 데이터 베이스 생성
CREATE DATABASE unimon;

-- 디비 확인
SHOW DATABASES;

-- 유저 생성 나만해
CREATE USER 'joje'@'%' IDENTIFIED BY 'zxzx2324';

-- 권한 부여
GRANT ALL PRIVILEGES ON sportscenter.* TO 'joje'@'%';

-- 새로 고침
FLUSH PRIVILEGES;

select user from user;