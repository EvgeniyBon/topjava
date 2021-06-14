package ru.javawebinar.topjava.repository.inmemory;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.repository.UserRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Repository
public class InMemoryUserRepository implements UserRepository {
    private final Map<Integer, User> repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger(0);
    private static final Logger log =  LoggerFactory.getLogger(InMemoryUserRepository.class);

    {
        User user = new User(counter.getAndIncrement(),"Valek","ad","123",200,true,new HashSet<>(Collections.singleton(Role.USER)));
       this.save(user);
    }
    @Override
    public boolean delete(int id) {
        log.info("delete {}", id);
        return repository.remove(id) != null;
    }

    @Override
    public User save(User user) {
        if (user.isNew()) {
            user.setId(counter.incrementAndGet());
            repository.put(user.getId(), user);
            return user;
        }
        return repository.computeIfPresent(user.getId(), (id,oldMeal) -> user);
    }

    @Override
    public User get(int id) {
        log.info("get {}", id);
        return repository.get(id);
    }

    @Override
    public List<User> getAll() {
        log.info("getAll");
        List<User>userList = new ArrayList<>();
        repository.forEach((a,b)->userList.add(b));
        return userList;
    }

    @Override
    public User getByEmail(String email) {
        AtomicReference<User> user = null;
        log.info("getByEmail {}", email);
        repository.forEach((a,b)->{
            if (b.getEmail().equals(email)){
                user.set(b);
            }
        });
        return user.get();

    }
}
