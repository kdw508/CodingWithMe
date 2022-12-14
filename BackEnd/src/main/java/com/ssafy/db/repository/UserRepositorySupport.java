package com.ssafy.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.QUser;
import com.ssafy.db.entity.User;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
public class UserRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    QUser qUser = QUser.user;

    public Optional<User> findUserByUserId(Long userId) {
        User user = jpaQueryFactory.select(qUser).from(qUser)
                .where(qUser.userId.eq(userId)).fetchOne();
        if (user == null) return Optional.empty();
        return Optional.ofNullable(user);
    }

    public Optional<User> findUserById(String id) {
        User user = jpaQueryFactory.select(qUser).from(qUser)
                .where(qUser.id.eq(id)).fetchOne();
        if (user == null) return Optional.empty();
        return Optional.ofNullable(user);
    }

    public Optional<List<User>> findUserByName(String name) {
        List<User> userList = jpaQueryFactory.select(qUser).from(qUser)
                .where(qUser.name.startsWith(name))
                .where(qUser.role.eq("학생")).
                fetch();
        if (userList == null) return Optional.empty();
        return Optional.ofNullable(userList);
    }

    public boolean findByUserIdEquals(String id) {
        User user = jpaQueryFactory.select(qUser).from(qUser)
                .where(qUser.id.eq(id)).fetchOne();
        if (user == null) return true;
        return false;
    }

    public boolean findByUserEmailEquals(String email) {
        User user = jpaQueryFactory.select(qUser).from(qUser)
                .where(qUser.email.eq(email)).fetchOne();
        if (user == null) return true;
        return false;
    }
}
