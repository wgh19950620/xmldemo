package com.imooc.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.imooc.entity.User;

@Repository
public class UserDAOImpl {

    /**
     * 采用内存型的存储方式 ->Map
     * 考虑到高并发的情况使用
     */
    private final        ConcurrentMap<Integer, User> repository  =
            new ConcurrentHashMap<>();
    /**
     * 采用自增长策略
     */
    private final static AtomicInteger                idGenerator =
            new AtomicInteger();

    /**
     * 保存用户对象
     *
     * @param user {@link User} 对象
     * @return 如果保存成功，返回<code>true</code>，否则返回<code>false</code>
     */
    public boolean save(User user) {
        // ID 从1开始自增长
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;
    }

    public Collection<User> findAll() {
        return repository.values();
    }

    public Collection<User> findAll1() {
        List<User> users = new ArrayList<>();
        Iterator<Map.Entry<Integer, User>> entries = repository.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Integer, User> entry = entries.next();
            users.add(entry.getValue());
        }
        return users;
    }
}
