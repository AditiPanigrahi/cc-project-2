/*
 * package com.cc.project2;
 * 
 * import java.util.Optional;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.ComponentScan; import
 * org.springframework.context.annotation.Configuration;
 * 
 * import com.cc.project2.User.User; import com.cc.project2.User.UserRepository;
 * 
 * @Configuration
 * 
 * @ComponentScan public class Config {
 * 
 * @Bean public UserRepository UserRepository() { return new UserRepository() {
 * 
 * @Override public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
 * // TODO Auto-generated method stub return null; }
 * 
 * @Override public <S extends User> S save(S entity) { // TODO Auto-generated
 * method stub return null; }
 * 
 * @Override public Optional<User> findById(Long id) { // TODO Auto-generated
 * method stub return null; }
 * 
 * @Override public Iterable<User> findAllById(Iterable<Long> ids) { // TODO
 * Auto-generated method stub return null; }
 * 
 * @Override public Iterable<User> findAll() { // TODO Auto-generated method
 * stub return null; }
 * 
 * @Override public boolean existsById(Long id) { // TODO Auto-generated method
 * stub return false; }
 * 
 * @Override public void deleteById(Long id) { // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * @Override public void deleteAll(Iterable<? extends User> entities) { // TODO
 * Auto-generated method stub
 * 
 * }
 * 
 * @Override public void deleteAll() { // TODO Auto-generated method stub
 * 
 * }
 * 
 * @Override public void delete(User entity) { a // TODO Auto-generated method
 * stub
 * 
 * }
 * 
 * @Override public long count() { // TODO Auto-generated method stub return 0;
 * } }; }
 * 
 * }
 */