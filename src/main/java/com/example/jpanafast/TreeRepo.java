package com.example.jpanafast;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepo extends JpaRepository<Tree, Long> {

}
